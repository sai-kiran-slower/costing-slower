package com.slower.lulu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.slower.lulu.config.ColorMapping;
import com.slower.lulu.config.FlexBrMapping;
import com.slower.lulu.config.MappingConfig;
import com.slower.lulu.config.MappingRule;
import com.slower.lulu.model.Attribute;
import org.apache.commons.text.CaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Functions {
    private static final Logger logger = LoggerFactory.getLogger(Functions.class);

    public static String charLimit(final String attrValue, final int attrLen) {
        if (attrValue.length() > attrLen) {
            return attrValue.substring(0, attrLen);
        }
        return attrValue;
    }

    public static boolean isChanged(final Attribute attribute) {
        return attribute.getCHANGEIND().equals("Y");
    }

    private static MappingConfig getMappingConfigs() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            return objectMapper.readValue(new File("src/main/resources/config/flex_to_br_mapping.yaml"), MappingConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new MappingConfig();
        }
    }

    /**
     *
     * @param mappingDomain e.g. Color
     * @param fieldToMap E.g. colorType
     * @param flexValue Value from flex
     * @return
     */
    public static String getBRCodeReflected(String mappingDomain, String fieldToMap, String flexValue) {
        final MappingConfig mappingConfig = Functions.getMappingConfigs();

        final MappingRule mappingRules = mappingConfig.getMappingRules();
        final ColorMapping specificMapping;
        try {
            specificMapping = (ColorMapping) mappingRules.getClass().getMethod(getMappingCC(mappingDomain.toLowerCase())).invoke(mappingRules);

            final String lookup = fieldToMap.toLowerCase();
            final List<FlexBrMapping> mappings = (List<FlexBrMapping>) specificMapping.getClass().getMethod(getToCamelCase(lookup)).invoke(specificMapping);
            for (FlexBrMapping flexBrMapping : mappings) {
                if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexValue))
                    return flexBrMapping.getBrCode();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Add explanation that we passed an unsupported mapping domain or mapping type
            logger.error(String.format("Failed to find mapping for domain %s, field %s, and value %s. ",
                    mappingDomain, fieldToMap, flexValue));
        }

        throw new IllegalArgumentException(
                String.format("Failed to find mapping for flex code: %s with domain %s and type %s", flexValue, mappingDomain, fieldToMap)
        );
    }

    public static String getBRCode(String mappingDomain, String mappingType, String flexCode) {
        MappingConfig mappingConfig = Functions.getMappingConfigs();
        String brCode = null;
        if (mappingDomain.equalsIgnoreCase("quote")) {

            switch (mappingType.toLowerCase()) {
                case "seasonal_type":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSeasonalType()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "season_style_level_status":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSeasonStyleLevelStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "season_style_option_level_status":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSeasonStyleOptionLevelStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "category":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getCategory()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "design_line":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getDesignLine()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "calendar_track":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getCalendarTrack()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "proto_sample_status":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getProtoSampleStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "size_run_sample_status":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSizeRunSampleStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "design_pod":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getDesignPod()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported Flex Code: " + flexCode + "  for  Mapping Type: " + mappingType);
            }
        }
        else if (mappingDomain.equalsIgnoreCase("color")) {
            switch (mappingType.toLowerCase()) {
                case "status":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getColorMapping().getStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "category":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getColorMapping().getCategory()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported Flex Code: " + flexCode + "  for  Mapping Type: " + mappingType);
            }
        }
        else if (mappingDomain.equalsIgnoreCase("common")) {
            switch (mappingType.toLowerCase()) {
                case "active_ind":
                    for (FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getCommonMapping().getActiveInd()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported Flex Code: " + flexCode + "  for  Mapping Type: " + mappingType);
            }
        }
        return brCode;
    }

    public static String getToCamelCase(final String s) {
        return CaseUtils.toCamelCase("get_" + s, false, '_');
    }

    public static String getMappingCC(final String s) {
        return CaseUtils.toCamelCase("get_" + s + "_mapping", false, '_');
    }

    public static String setToCamelCase(final String s) {
        return CaseUtils.toCamelCase("set_" + s, false, '_');
    }
}
