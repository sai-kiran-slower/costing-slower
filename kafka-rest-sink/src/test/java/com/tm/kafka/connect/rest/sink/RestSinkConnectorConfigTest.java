package com.tm.kafka.connect.rest.sink;

import org.junit.Test;

import com.tm.kafka.connect.rest.sink.RestSinkConnectorConfig;

public class RestSinkConnectorConfigTest {
  @Test
  public void doc() {
    System.out.println(RestSinkConnectorConfig.generateConfig().toRst());
  }
}
