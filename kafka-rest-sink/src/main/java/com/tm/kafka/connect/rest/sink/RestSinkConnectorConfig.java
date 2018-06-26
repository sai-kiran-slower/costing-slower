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
  private static final String SINK_METHOD_DOC = "The HTTP method for REST sink connector.";
  private static final String SINK_METHOD_DISPLAY = "Sink method";
  private static final String SINK_METHOD_DEFAULT = "POST";

  public static final String SINK_PROPERTIES_LIST_CONFIG = "rest.sink.properties";
  private static final String SINK_PROPERTIES_LIST_DOC =
    "The request properties (headers) for REST sink connector.";
  private static final String SINK_PROPERTIES_LIST_DISPLAY = "Sink properties";

  public static final String SINK_URL_CONFIG = "rest.sink.url";
  private static final String SINK_URL_DOC = "The URL for REST sink connector.";
  private static final String SINK_URL_DISPLAY = "URL for REST sink connector.";

  public static final String SINK_PAYLOAD_CONVERTER_CONFIG = "rest.sink.payload.converter.class";
  private static final Class PAYLOAD_CONVERTER_DEFAULT = StringPayloadConverter.class;
  private static final String SINK_PAYLOAD_CONVERTER_DOC =
    "Class to be used to convert messages from SinkRecords to Strings for REST calls";
  private static final String SINK_PAYLOAD_CONVERTER_DISPLAY = "Payload converter class";

  // TODO Is this sufficient for a retry timer?
  private static final String SINK_RETRY_BACKOFF_CONFIG = "rest.sink.retry.backoff.ms";
  private static final String SINK_RETRY_BACKOFF_DOC =
    "The retry backoff in milliseconds. This config is used to notify Kafka connect to retry "
      + "delivering a message batch or performing recovery in case of transient exceptions.";
  private static final long SINK_RETRY_BACKOFF_DEFAULT = 5000L;
  private static final String SINK_RETRY_BACKOFF_DISPLAY = "Retry Backoff (ms)";

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
        SINK_METHOD_DEFAULT,
        new MethodValidator(),
        Importance.HIGH,
        SINK_METHOD_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SINK_METHOD_DISPLAY,
        new MethodRecommender()
      )

      .define(
        SINK_PROPERTIES_LIST_CONFIG,
        Type.LIST,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        SINK_PROPERTIES_LIST_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SINK_PROPERTIES_LIST_DISPLAY
      )

      .define(
        SINK_URL_CONFIG,
        Type.STRING,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        SINK_URL_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SINK_URL_DISPLAY
      )

      .define(
        SINK_PAYLOAD_CONVERTER_CONFIG,
        Type.CLASS,
        PAYLOAD_CONVERTER_DEFAULT,
        new PayloadConverterValidator(),
        Importance.LOW,
        SINK_PAYLOAD_CONVERTER_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SINK_PAYLOAD_CONVERTER_DISPLAY,
        new PayloadConverterRecommender()
      )

      .define(
        SINK_RETRY_BACKOFF_CONFIG,
        Type.LONG,
        SINK_RETRY_BACKOFF_DEFAULT,
        Importance.LOW,
        SINK_RETRY_BACKOFF_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.NONE,
        SINK_RETRY_BACKOFF_DISPLAY
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

  SinkRecordToPayloadConverter getSinkRecordToPayloadConverter() {
    return sinkRecordToPayloadConverter;
  }

  Map<String, String> getHttpRequestProperties() {
    return httpRequestProperties;
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
