package com.slower.lulu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.slower.lulu.config.MappingConfig;
import com.slower.lulu.model.ArtworkFlexPLMResponse;
import com.slower.lulu.model.ColorFlexPLMResponse;
import com.slower.lulu.model.StyleFlexPLMResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class PayloadProcessor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String processStyle(final String payload) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final StyleFlexPLMResponse styleFlexPLMResponse = objectMapper.readValue(payload, StyleFlexPLMResponse.class);
        return new StyleResponseHandler().handleStyle(styleFlexPLMResponse);
    }

    public String processColor(final String payload) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final ColorFlexPLMResponse colorFlexPLMResponse = objectMapper.readValue(payload, ColorFlexPLMResponse.class);
        return new ColorResponseHandler().handleColor(colorFlexPLMResponse);
    }

    public String processArtwork(final String payload) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final ArtworkFlexPLMResponse artworkFlexPLMResponse = objectMapper.readValue(payload, ArtworkFlexPLMResponse.class);
        return new ArtworkResponseHandler().handleArtwork(artworkFlexPLMResponse);
    }

}
