package com.tm.kafka.connect.rest.source;

import com.tm.kafka.connect.rest.VersionUtil;
import com.tm.kafka.connect.rest.config.MethodRecommender;
import com.tm.kafka.connect.rest.config.MethodValidator;
import com.tm.kafka.connect.rest.config.PayloadToSourceRecordConverterRecommender;
import com.tm.kafka.connect.rest.config.PayloadToSourceRecordConverterValidator;
import com.tm.kafka.connect.rest.config.TopicSelectorRecommender;
import com.tm.kafka.connect.rest.config.TopicSelectorValidator;
import com.tm.kafka.connect.rest.converter.PayloadToSourceRecordConverter;
import com.tm.kafka.connect.rest.converter.StringPayloadConverter;
import com.tm.kafka.connect.rest.selector.SimpleTopicSelector;
import com.tm.kafka.connect.rest.selector.TopicSelector;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.connect.errors.ConnectException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.kafka.common.config.ConfigDef.NO_DEFAULT_VALUE;

public class RestSourceConnectorConfig extends AbstractConfig
{
  public static final String SOURCE_POLL_INTERVAL_CONFIG = "rest.source.poll.interval.ms";
  public static final String SOURCE_POLL_INTERVAL_DOC = "How often to poll the source URL.";
  public static final String SOURCE_POLL_INTERVAL_DISPLAY = "Polling interval";
  public static final Long SOURCE_POLL_INTERVAL_DEFAULT = 60000L;

  public static final String SOURCE_METHOD_CONFIG = "rest.source.method";
  private static final String SOURCE_METHOD_DOC = "The HTTP method for REST source connector.";
  private static final String SOURCE_METHOD_DISPLAY = "Source method";
  private static final String SOURCE_METHOD_DEFAULT = "POST";

  public static final String SOURCE_PROPERTIES_LIST_CONFIG = "rest.source.properties";
  private static final String SOURCE_PROPERTIES_LIST_DOC =
    "The request properties (headers) for REST source connector.";
  private static final String SOURCE_PROPERTIES_LIST_DISPLAY = "Source properties";

  public static final String SOURCE_URL_CONFIG = "rest.source.url";
  private static final String SOURCE_URL_DOC = "The URL for REST source connector.";
  private static final String SOURCE_URL_DISPLAY = "URL for REST source connector.";

  public static final String SOURCE_DATA_CONFIG = "rest.source.data";
  private static final String SOURCE_DATA_DOC = "The data for REST source connector.";
  private static final String SOURCE_DATA_DISPLAY = "Data for REST source connector.";
  private static final String SOURCE_DATA_DEFAULT = null;

  public static final String SOURCE_TOPIC_SELECTOR_CONFIG = "rest.source.topic.selector";
  private static final String SOURCE_TOPIC_SELECTOR_DOC =
    "The topic selector class for REST source connector.";
  private static final String SOURCE_TOPIC_SELECTOR_DISPLAY =
    "Topic selector class for REST source connector.";
  private static final Class<? extends TopicSelector> SOURCE_TOPIC_SELECTOR_DEFAULT =
    SimpleTopicSelector.class;

  public static final String SOURCE_TOPIC_LIST_CONFIG = "rest.source.destination.topics";
  private static final String SOURCE_TOPIC_LIST_DOC =
    "The list of destination topics for the REST source connector.";
  private static final String SOURCE_TOPIC_LIST_DISPLAY = "Source destination topics";

  public static final String SOURCE_PAYLOAD_CONVERTER_CONFIG = "rest.source.payload.converter.class";
  private static final Class<? extends PayloadToSourceRecordConverter> PAYLOAD_CONVERTER_DEFAULT =
    StringPayloadConverter.class;
  private static final String SOURCE_PAYLOAD_CONVERTER_DOC_CONFIG =
    "Class to be used to convert messages from REST calls to SourceRecords";
  private static final String SOURCE_PAYLOAD_CONVERTER_DISPLAY_CONFIG = "Payload converter class";
  private final TopicSelector topicSelector;
  private final PayloadToSourceRecordConverter payloadToSourceRecordConverter;
  private final Map<String, String> requestProperties;

  @SuppressWarnings("unchecked")
  private RestSourceConnectorConfig(ConfigDef config, Map<String, String> parsedConfig)
  {
    super(config, parsedConfig);
    try {
      topicSelector = ((Class<? extends TopicSelector>)
        getClass(SOURCE_TOPIC_SELECTOR_CONFIG)).getDeclaredConstructor().newInstance();
      payloadToSourceRecordConverter = ((Class<? extends PayloadToSourceRecordConverter>)
        getClass(SOURCE_PAYLOAD_CONVERTER_CONFIG)).getDeclaredConstructor().newInstance();
    } catch (IllegalAccessException | InstantiationException
      | InvocationTargetException | NoSuchMethodException e) {
      throw new ConnectException("Invalid class for: " + SOURCE_PAYLOAD_CONVERTER_CONFIG, e);
    }
    requestProperties = getPropertiesList().stream()
      .map(a -> a.split(":"))
      .collect(Collectors.toMap(a -> a[0], a -> a[1]));

  }

  public RestSourceConnectorConfig(Map<String, String> parsedConfig)
  {
    this(generateConfig(), parsedConfig);
  }

  public static ConfigDef generateConfig()
  {
    String group = "REST";
    int orderInGroup = 0;
    return new ConfigDef()
      .define(
        SOURCE_POLL_INTERVAL_CONFIG,
        Type.LONG,
        SOURCE_POLL_INTERVAL_DEFAULT,
        Importance.LOW,
        SOURCE_POLL_INTERVAL_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_POLL_INTERVAL_DISPLAY
      )

      .define(
        SOURCE_METHOD_CONFIG,
        Type.STRING,
        SOURCE_METHOD_DEFAULT,
        new MethodValidator(),
        Importance.HIGH,
        SOURCE_METHOD_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_METHOD_DISPLAY,
        new MethodRecommender()
      )

      .define(
        SOURCE_PROPERTIES_LIST_CONFIG,
        Type.LIST,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        SOURCE_PROPERTIES_LIST_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_PROPERTIES_LIST_DISPLAY
      )

      .define(
        SOURCE_URL_CONFIG,
        Type.STRING,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        SOURCE_URL_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_URL_DISPLAY
      )

      .define(
        SOURCE_DATA_CONFIG,
        Type.STRING,
        SOURCE_DATA_DEFAULT,
        Importance.LOW,
        SOURCE_DATA_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_DATA_DISPLAY
      )

      .define(
        SOURCE_TOPIC_LIST_CONFIG,
        Type.LIST,
        NO_DEFAULT_VALUE,
        Importance.HIGH,
        SOURCE_TOPIC_LIST_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_TOPIC_LIST_DISPLAY
      )

      .define(
        SOURCE_TOPIC_SELECTOR_CONFIG,
        Type.CLASS,
        SOURCE_TOPIC_SELECTOR_DEFAULT,
        new TopicSelectorValidator(),
        Importance.HIGH,
        SOURCE_TOPIC_SELECTOR_DOC,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_TOPIC_SELECTOR_DISPLAY,
        new TopicSelectorRecommender()
      )

      .define(
        SOURCE_PAYLOAD_CONVERTER_CONFIG,
        Type.CLASS,
        PAYLOAD_CONVERTER_DEFAULT,
        new PayloadToSourceRecordConverterValidator(),
        Importance.LOW,
        SOURCE_PAYLOAD_CONVERTER_DOC_CONFIG,
        group,
        ++orderInGroup,
        ConfigDef.Width.SHORT,
        SOURCE_PAYLOAD_CONVERTER_DISPLAY_CONFIG,
        new PayloadToSourceRecordConverterRecommender()
      )
      ;
  }

  Long getPollInterval()
  {
    return this.getLong(SOURCE_POLL_INTERVAL_CONFIG);
  }

  String getMethod()
  {
    return this.getString(SOURCE_METHOD_CONFIG);
  }

  private List<String> getPropertiesList()
  {
    return this.getList(SOURCE_PROPERTIES_LIST_CONFIG);
  }

  public String getUrl()
  {
    return this.getString(SOURCE_URL_CONFIG);
  }

  public List<String> getTopics()
  {
    return this.getList(SOURCE_TOPIC_LIST_CONFIG);
  }

  public TopicSelector getTopicSelector()
  {
    return topicSelector;
  }

  public String getData()
  {
    return this.getString(SOURCE_DATA_CONFIG);
  }

  PayloadToSourceRecordConverter getPayloadToSourceRecordConverter()
  {
    return payloadToSourceRecordConverter;
  }

  Map<String, String> getRequestProperties()
  {
    return requestProperties;
  }

  private static ConfigDef getConfig()
  {
    Map<String, ConfigDef.ConfigKey> everything = new HashMap<>(generateConfig().configKeys());
    ConfigDef visible = new ConfigDef();
    for (ConfigDef.ConfigKey key : everything.values()) {
      visible.define(key);
    }
    return visible;
  }

  public static void main(String[] args)
  {
    System.out.println(VersionUtil.getVersion());
    System.out.println(getConfig().toEnrichedRst());
  }
}
