package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slower.lulu.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PayloadProcessor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String processStyle(String payload) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        StyleFlexPLMResponse styleFlexPLMResponse = objectMapper.readValue(payload, StyleFlexPLMResponse.class);
        return new StyleResponseHandler().handleStyle(styleFlexPLMResponse);
    }

    public String processColor(String payload) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ColorFlexPLMResponse colorFlexPLMResponse = objectMapper.readValue(payload, ColorFlexPLMResponse.class);
        return new ColorResponseHandler().handleColor(colorFlexPLMResponse);
    }
}
