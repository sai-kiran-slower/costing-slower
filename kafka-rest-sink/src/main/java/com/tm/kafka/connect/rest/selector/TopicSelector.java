package com.tm.kafka.connect.rest.selector;

import com.tm.kafka.connect.rest.source.RestSourceConnectorConfig;

public interface TopicSelector {
  String getTopic(final Object data);

  void start(final RestSourceConnectorConfig config);
}
