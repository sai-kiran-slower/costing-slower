package com.tm.kafka.connect.rest.sink;

import com.tm.kafka.connect.rest.VersionUtil;
import com.tm.kafka.connect.rest.converter.SinkRecordToPayloadConverter;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

public class RestSinkTask extends SinkTask {
  private static Logger log = LoggerFactory.getLogger(RestSinkTask.class);

  private String method;
  private Map<String, String> httpRequestProperties;
  private String url;
  private SinkRecordToPayloadConverter converter;
  private Long retryBackoff;

  @Override
  public void start(final Map<String, String> map) {
    RestSinkConnectorConfig connectorConfig = new RestSinkConnectorConfig(map);
    retryBackoff = connectorConfig.getRetryBackoff();
    method = connectorConfig.getMethod();
    httpRequestProperties = connectorConfig.getHttpRequestProperties();
    url = connectorConfig.getUrl();
    converter = connectorConfig.getSinkRecordToPayloadConverter();
    converter.start(connectorConfig);
  }

  @Override
  public void put(final Collection<SinkRecord> records) {
    for (SinkRecord record : records) {
      while (true) {
        try {
          final String data = converter.convert(record);
          String urlString = url;
          if ("GET".equals(method)) {
            urlString = urlString + URLEncoder.encode(data, "UTF-8");
          }
          final HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection();

          // TODO look up http request properties
          httpRequestProperties.forEach(conn::setRequestProperty);
          conn.setRequestMethod(method);
          if ("POST".equals(method)) {
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
          }

          // Also retry if there's a timeout, figure out how to timeout the URL request

          // TODO We need to not just get a response code but get the full message so we can publish it if we need to

          int responseCode = conn.getResponseCode();
          if (log.isTraceEnabled()) {
            log.trace("Response code: {}, Request data: {}", responseCode, data);
          }
          break;
        } catch (ProtocolException e) {
          log.error("Unexpected connection protocol.", e);
        } catch (MalformedURLException e) {
          log.error("Malformed url: " + url, e);
        } catch (UnsupportedEncodingException e) {
          log.error("HTTP call failed. ", e);
        } catch (IOException e) {
          log.error("Error while writing output.", e);
        } finally {

          try {
            Thread.sleep(retryBackoff);
          } catch (InterruptedException ignored) {

          }
        }
      }
    }
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
