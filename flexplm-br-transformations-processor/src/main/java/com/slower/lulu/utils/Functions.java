package com.slower.lulu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.slower.lulu.config.FlexBrMapping;
import com.slower.lulu.config.MappingConfig;
import com.slower.lulu.model.Attribute;

import java.io.File;
import java.io.IOException;

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
}
