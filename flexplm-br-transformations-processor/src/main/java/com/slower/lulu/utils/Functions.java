package com.slower.lulu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.slower.lulu.config.MappingConfig;
import com.slower.lulu.config.MappingRule;
import com.slower.lulu.model.Attribute;
import io.swagger.model.FlexBrMapping;

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

    public static MappingConfig getMappingConfigs() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            MappingConfig mappingConfig = objectMapper.readValue(new File("src/main/resources/config/flex_to_br_mapping.yaml"), MappingConfig.class);
            return mappingConfig;
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
                    for (com.slower.lulu.config.FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSeasonalType()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "season_style_level_status":
                    for (com.slower.lulu.config.FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSeasonStyleLevelStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
                case "season_style_option_level_status":
                    for (com.slower.lulu.config.FlexBrMapping flexBrMapping : mappingConfig.getMappingRules().getQuoteMapping().getSeasonStyleOptionLevelStatus()) {
                        if (flexBrMapping.getFlexCode().equalsIgnoreCase(flexCode))
                            brCode = flexBrMapping.getBrCode();
                    }
                    break;
            }
        }
        return brCode;
    }
}
