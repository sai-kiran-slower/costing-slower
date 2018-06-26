package com.tm.kafka.connect.rest.source;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tm.kafka.connect.rest.VersionUtil;

public class RestSourceConnector extends SourceConnector {
  private static Logger log = LoggerFactory.getLogger(RestSourceConnector.class);
  private RestSourceConnectorConfig config;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new RestSourceConnectorConfig(map);
  }

  @Override
  public Class<? extends Task> taskClass() {
    return RestSourceTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int maxTasks) {
    Map<String, String> taskProps = new HashMap<>(config.originalsStrings());
    List<Map<String, String>> taskConfigs = new ArrayList<>(maxTasks);
    for (int i = 0; i < maxTasks; ++i) {
      taskConfigs.add(taskProps);
    }
    return taskConfigs;
  }

  @Override
  public void stop() {
  }

  @Override
  public ConfigDef config() {
    return RestSourceConnectorConfig.generateConfig();
  }
}
