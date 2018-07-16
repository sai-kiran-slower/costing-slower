package com.tm.kafka.connect.rest.sink;

import com.tm.kafka.connect.rest.converter.BytesPayloadConverter;
import com.tm.kafka.connect.rest.converter.SinkRecordToPayloadConverter;
import com.tm.kafka.connect.rest.converter.StringPayloadConverter;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.errors.ConnectException;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.kafka.common.config.ConfigDef.NO_DEFAULT_VALUE;

public class RestSinkConnectorConfig extends AbstractConfig {
  // TODO Clean these up as enums so it's easier to read

  public static final String SINK_METHOD_CONFIG = "rest.sink.method";
  public static final String SINK_PROPERTIES_LIST_CONFIG = "rest.sink.properties";
  public static final String SINK_URL_CONFIG = "rest.sink.url";
  public static final String SINK_RESPONSE_TIMEOUT_MS_CONFIG = "rest.sink.response.timeout.ms";
  public static final String SINK_RETRY_ATTEMPTS_CONFIG = "rest.sink.retry.attempts";
  public static final String SINK_PAYLOAD_CONVERTER_CONFIG = "rest.sink.payload.converter.class";
  private static final String SINK_PAYLOAD_CONVERTER_SCHEMA_CONFIG = "rest.sink.payload.converter.schema";
  private static final String SINK_RETRY_BACKOFF_CONFIG = "rest.sink.retry.backoff.ms";

  private final SinkRecordToPayloadConverter sinkRecordToPayloadConverter;
  private final Map<String, String> httpRequestProperties;

  @SuppressWarnings("unchecked")
  private RestSinkConnectorConfig(final ConfigDef config, final Map<String, String> parsedConfig) {
    super(config, parsedConfig);
    try {
      sinkRecordToPayloadConverter = ((Class<? extends SinkRecordToPayloadConverter>)
        getClass(SINK_PAYLOAD_CONVERTER_CONFIG)).getDeclaredConstructor().newInstance();
    } catch (IllegalAccessException | InstantiationException
      | InvocationTargetException | NoSuchMethodException e) {
      throw new ConnectException("Invalid class for: " + SINK_PAYLOAD_CONVERTER_CONFIG, e);
    }
    httpRequestProperties = getPropertiesList().stream()
      .map(a -> a.split(":"))
      .collect(Collectors.toMap(a -> a[0], a -> a[1]));
  }

  public RestSinkConnectorConfig(final Map<String, String> parsedConfig) {
    this(generateConfig(), parsedConfig);
  }

  public static ConfigDef generateConfig() {
    String group = "REST";
    int orderInGroup = 0;
    return new ConfigDef()
      .define(
        SINK_METHOD_CONFIG,
        Type.STRING,
        "POST",
        new MethodValidator(),
        Importance.HIGH,
        "The HTTP method for REST sink connector.",
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        "Sink method",
        new MethodRecommender()
      )

      .define(
        SINK_PROPERTIES_LIST_CONFIG,
        Type.LIST,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        "The request properties (headers) for REST sink connector.",
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        "Sink properties"
      )

      .define(
        SINK_URL_CONFIG,
        Type.STRING,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        "The URL for REST sink connector.",
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        "URL for REST sink connector."
      )

      .define(
        SINK_PAYLOAD_CONVERTER_CONFIG,
        Type.CLASS,
        StringPayloadConverter.class,
        new PayloadConverterValidator(),
        Importance.LOW,
        "Class to be used to convert messages from SinkRecords to Strings for REST calls",
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        "Payload converter class",
        new PayloadConverterRecommender()
      )

      .define(
        SINK_PAYLOAD_CONVERTER_SCHEMA_CONFIG,
        Type.BOOLEAN,
        "false",
        new PayloadConverterSchemaValidator(),
        Importance.LOW,
        "Include schema in JSON output for JsonPayloadConverter",
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        "Include schema in JSON output (true/false)"
      )

      .define(
        SINK_RETRY_BACKOFF_CONFIG,
        Type.LONG,
        5000L,
        Importance.LOW,
        "The retry backoff in milliseconds. This config is used to notify Kafka connect to retry "
          + "delivering a message batch or performing recovery in case of transient exceptions.",
        group,
        ++orderInGroup,
        ConfigDef.Width.NONE,
        "Retry Backoff (ms)"
      )

      .define(
        SINK_RESPONSE_TIMEOUT_MS_CONFIG,
        Type.INT,
        5000,
        Importance.HIGH,
        "How long to wait in milliseconds before trying to re-send a HTTP request.",
        group,
        ++orderInGroup,
        ConfigDef.Width.NONE,
        "Read Timeout (ms)"
      )

      .define(
        SINK_RETRY_ATTEMPTS_CONFIG,
        Type.INT,
        5,
        Importance.HIGH,
        "How any times to attempt to retry sending a POST before throwing an error to notify of failure.",
        group,
        ++orderInGroup,
        ConfigDef.Width.NONE,
        "Retry Count"
      )
      ;
  }

  String getMethod() {
    return this.getString(SINK_METHOD_CONFIG);
  }

  private List<String> getPropertiesList() {
    return this.getList(SINK_PROPERTIES_LIST_CONFIG);
  }

  public String getUrl() {
    return this.getString(SINK_URL_CONFIG);
  }

  Long getRetryBackoff() {
    return this.getLong(SINK_RETRY_BACKOFF_CONFIG);
  }

  public Boolean getIncludeSchema() {
    return this.getBoolean(SINK_PAYLOAD_CONVERTER_SCHEMA_CONFIG);
  }

  SinkRecordToPayloadConverter getSinkRecordToPayloadConverter() {
    return sinkRecordToPayloadConverter;
  }

  Map<String, String> getHttpRequestProperties() {
    return httpRequestProperties;
  }

  public Integer getSinkResponseTimeoutMsConfig() {
    return this.getInt(SINK_RESPONSE_TIMEOUT_MS_CONFIG);
  }

  public Integer getSinkRetryAttemptsConfig() {
    return this.getInt(SINK_RETRY_ATTEMPTS_CONFIG);
  }

  private static class PayloadConverterRecommender implements ConfigDef.Recommender {
    @Override
    public List<Object> validValues(final String name, final Map<String, Object> connectorConfigs) {
      return Arrays.asList(StringPayloadConverter.class, BytesPayloadConverter.class);
    }

    @Override
    public boolean visible(final String name, final Map<String, Object> connectorConfigs) {
      return true;
    }
  }

  private static class PayloadConverterValidator implements ConfigDef.Validator {
    @Override
    public void ensureValid(final String name, final Object provider) {
      if (provider instanceof Class
        && SinkRecordToPayloadConverter.class.isAssignableFrom((Class<?>) provider)) {
        return;
      }
      throw new ConfigException(name, provider, "Class must extend: "
        + SinkRecordToPayloadConverter.class);
    }

    @Override
    public String toString() {
      return "Any class implementing: " + SinkRecordToPayloadConverter.class;
    }
  }

  private static class PayloadConverterSchemaRecommender implements ConfigDef.Recommender {
    @Override
    public List<Object> validValues(String name, Map<String, Object> connectorConfigs) {
      return Arrays.asList(Boolean.TRUE.toString(), Boolean.FALSE.toString());
    }

    @Override
    public boolean visible(String name, Map<String, Object> connectorConfigs) {
      return true;
    }
  }

  private static class PayloadConverterSchemaValidator implements ConfigDef.Validator {
    @Override
    public void ensureValid(String name, Object provider) {
      if (provider instanceof Boolean) {
        Boolean value = (Boolean) provider;
        if (value.equals(true) || (value.equals(false))) {
          return;
        }
      }
      throw new ConfigException(name, provider, "Please provide 'true' or 'false'");
    }

    @Override
    public String toString() {
      return new PayloadConverterSchemaRecommender().validValues("", new HashMap<>()).toString();
    }
  }

  private static class MethodRecommender implements ConfigDef.Recommender {
    @Override
    public List<Object> validValues(final String name, final Map<String, Object> connectorConfigs) {
      return Arrays.asList("GET", "POST");
    }

    @Override
    public boolean visible(String name, Map<String, Object> connectorConfigs) {
      return true;
    }
  }

  private static class MethodValidator implements ConfigDef.Validator {
    @Override
    public void ensureValid(final String name, final Object provider) {
    }

    @Override
    public String toString() {
      return new MethodRecommender().validValues("", new HashMap<>()).toString();
    }
  }
}
