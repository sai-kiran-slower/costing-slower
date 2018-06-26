package com.tm.kafka.connect.rest.selector;

import com.tm.kafka.connect.rest.source.RestSourceConnectorConfig;

public class SimpleTopicSelector implements TopicSelector {
  private String topic;

  @Override
  public String getTopic(final Object data) {
    return topic;
  }

  @Override
  public void start(final RestSourceConnectorConfig config) {
    // Always return the first topic in the list
    topic = config.getTopics().get(0);
  }
}
