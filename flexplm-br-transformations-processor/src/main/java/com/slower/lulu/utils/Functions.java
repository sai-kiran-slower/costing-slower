package com.slower.lulu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.slower.lulu.config.ColorMapping;
import com.slower.lulu.config.FlexBrMapping;
import com.slower.lulu.config.MappingConfig;
import com.slower.lulu.config.MappingRule;
import com.slower.lulu.model.Attribute;
import org.apache.commons.text.CaseUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Functions {

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

    public static String getBRCodeReflected(String mappingDomain, String mappingType, String flexCode) {
        final MappingConfig mappingConfig = Functions.getMappingConfigs();
        final String brCode = null;

        final MappingRule mappingRules = mappingConfig.getMappingRules();
        final ColorMapping specificMapping;
        try {
            specificMapping = (ColorMapping) mappingRules.getClass().getMethod(getMappingCC(mappingDomain.toLowerCase())).invoke(mappingRules);

            final String lookup = mappingType.toLowerCase();
            final List<FlexBrMapping> mappings = (List<FlexBrMapping>) specificMapping.getClass().getMethod(getCC(lookup)).invoke(specificMapping);
            for (FlexBrMapping flexBrMapping : mappings) {
                if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                    return flexBrMapping.getBrCode();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Add explanation that we passed an unsupported mapping domain or mapping type
            e.printStackTrace();
        }

        throw new IllegalArgumentException(
                String.format("Failed to find mapping for flex code: %s with domain %s and type %s", flexCode, mappingDomain, mappingType)
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

    public static String getCC(final String s) {
        return CaseUtils.toCamelCase("get_" + s, false, '_');
    }

    public static String getMappingCC(final String s) {
        return CaseUtils.toCamelCase("get_" + s + "_mapping", false, '_');
    }

    public static String setCC(final String s) {
        return CaseUtils.toCamelCase("set_" + s, false, '_');
    }
}
