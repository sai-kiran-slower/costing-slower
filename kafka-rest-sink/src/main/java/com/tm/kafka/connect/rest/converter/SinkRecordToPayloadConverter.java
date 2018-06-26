package com.tm.kafka.connect.rest.converter;

import com.tm.kafka.connect.rest.sink.RestSinkConnectorConfig;
import org.apache.kafka.connect.sink.SinkRecord;

public interface SinkRecordToPayloadConverter {
  String convert(final SinkRecord record);

  void start(final RestSinkConnectorConfig config);
}
