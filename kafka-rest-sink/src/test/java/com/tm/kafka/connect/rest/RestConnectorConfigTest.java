package com.tm.kafka.connect.rest;

import org.junit.Test;

import com.tm.kafka.connect.rest.sink.RestSinkConnectorConfig;
import com.tm.kafka.connect.rest.source.RestSourceConnectorConfig;

public class RestConnectorConfigTest {
  @Test
  public void docSource() {
    System.out.println(RestSourceConnectorConfig.generateConfig().toRst());
  }

  @Test
  public void docSink() {
    System.out.println(RestSinkConnectorConfig.generateConfig().toRst());
  }
}
