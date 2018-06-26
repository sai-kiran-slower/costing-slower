package com.tm.kafka.connect.rest.converter;

import com.tm.kafka.connect.rest.sink.RestSinkConnectorConfig;
import com.tm.kafka.connect.rest.source.RestSourceConnectorConfig;
import com.tm.kafka.connect.rest.selector.TopicSelector;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.source.SourceRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

public class BytesPayloadConverter
  implements SinkRecordToPayloadConverter, PayloadToSourceRecordConverter {

  private TopicSelector topicSelector;
  private String url;

  // Convert to String for outgoing REST calls
  public String convert(final SinkRecord record) {
    return record.value().toString();
  }

  // Just bytes for incoming messages
  public List<SourceRecord> convert(final byte[] bytes) {
    ArrayList<SourceRecord> records = new ArrayList<>();
    Map<String, String> sourcePartition = Collections.singletonMap("URL", url);
    Map<String, Long> sourceOffset = Collections.singletonMap("timestamp", currentTimeMillis());
    records.add(new SourceRecord(sourcePartition, sourceOffset, topicSelector.getTopic(bytes),
      Schema.BYTES_SCHEMA, bytes));
    return records;
  }

  @Override
  public void start(final RestSourceConnectorConfig config) {
    url = config.getUrl();
    topicSelector = config.getTopicSelector();
    topicSelector.start(config);
  }

  @Override
  public void start(final RestSinkConnectorConfig config) {
    url = config.getUrl();
  }
}
