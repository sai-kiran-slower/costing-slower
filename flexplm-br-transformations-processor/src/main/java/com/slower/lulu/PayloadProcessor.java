package com.slower.lulu;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.ArtworkFlexPLMResponse;
import io.swagger.model.ColorFlexPLMResponse;
import io.swagger.model.If11BambooRoseResponse;
import io.swagger.model.StyleFlexPLMResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        return new ColorResponseHandler().handleColorDynamic(colorFlexPLMResponse);
    }

    public String processArtwork(final String payload) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final ArtworkFlexPLMResponse artworkFlexPLMResponse = objectMapper.readValue(payload, ArtworkFlexPLMResponse.class);
        return new ArtworkResponseHandler().handleArtwork(artworkFlexPLMResponse);
    }

    // TODO Update If11 to read from stream
    public String processIf11(final String fileName) throws Exception {
        return new IF11_Handler().transform(fileName);
    }
}
