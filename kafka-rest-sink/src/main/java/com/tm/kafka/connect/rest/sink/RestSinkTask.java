package com.tm.kafka.connect.rest.sink;

import com.tm.kafka.connect.rest.VersionUtil;
import com.tm.kafka.connect.rest.converter.SinkRecordToPayloadConverter;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Collection;
import java.util.Map;

public class RestSinkTask extends SinkTask {
  private static Logger log = LoggerFactory.getLogger(RestSinkTask.class);

  private String method;
  private Map<String, String> httpRequestProperties;
  private String url;
  private SinkRecordToPayloadConverter converter;
  private Long retryBackoff;
  private Integer requestRetries;
  private Integer requestTimeout;

  @Override
  public void start(final Map<String, String> map) {
    RestSinkConnectorConfig connectorConfig = new RestSinkConnectorConfig(map);
    retryBackoff = connectorConfig.getRetryBackoff();
    method = connectorConfig.getMethod();
    httpRequestProperties = connectorConfig.getHttpRequestProperties();
    url = connectorConfig.getUrl();
    converter = connectorConfig.getSinkRecordToPayloadConverter();
    converter.start(connectorConfig);
    requestTimeout = connectorConfig.getSinkResponseTimeoutMsConfig();
    requestRetries = connectorConfig.getSinkRetryAttemptsConfig();
  }

  @Override
  public void put(final Collection<SinkRecord> records) {
    log.info("Received records: " + StringUtils.join(records.stream().map(SinkRecord::toString)));
    HttpURLConnection conn = null;
    String data = "";

    for (SinkRecord record : records) {
      while (true) {
        try {
          data = converter.convert(record);
          String urlString = url;
          if ("GET".equals(method)) {
            urlString = urlString + URLEncoder.encode(data, "UTF-8");
          }
           conn = (HttpURLConnection) new URL(urlString).openConnection();

          log.info("Writing data: \n" + data);
          httpRequestProperties.forEach(conn::setRequestProperty);

          conn.setRequestMethod(method);

          // Set how long to wait for a response before giving up
          conn.setReadTimeout(requestTimeout);

          if ("POST".equals(method)) {
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( data.length() ));
            conn.setDoOutput(true);
            conn.setUseCaches( false );
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            log.info("Flushed data" + data);
          }

          if (conn.getReadTimeout() == 0) {
            log.warn("No timeout is specified for awaiting response from server, this method may hang indefinitely.");
          }

          int responseCode = conn.getResponseCode();

          // TODO Delete info line
          log.info("Response code: {}, Request data: {}, Message: {}", responseCode, data, conn.getResponseMessage());
          if (log.isTraceEnabled()) {
            log.trace("Response code: {}, Request data: {}, Message: {}", responseCode, data, conn.getResponseMessage());
          }

          break;
        } catch (ProtocolException e) {
          log.error("Unexpected connection protocol.", e);
          retry();
        } catch (SocketTimeoutException e) {
          log.error("Timed out while awaiting response from server for data: {} with connection: {}.", data, conn);
          retry();
        }
        catch (MalformedURLException e) {
          log.error("Malformed url: " + url, e);
          retry();
        } catch (UnsupportedEncodingException e) {
          log.error("HTTP call failed. ", e);
          retry();
        } catch (IOException e) {
          log.error("Error while writing output.", e);
          retry();
        } finally {
          if (conn != null) {
            conn.disconnect();
          }
        }
      }
    }
  }

  private void retry()
  {
    try {
      Thread.sleep(retryBackoff);
    } catch (InterruptedException ignored) {}
  }

  @Override
  public void flush(Map<TopicPartition, OffsetAndMetadata> currentOffsets)
  {
    super.flush(currentOffsets);
  }

  @Override
  public void stop() {
    log.debug("Stopping sink task, setting client to null");
  }

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }
}
