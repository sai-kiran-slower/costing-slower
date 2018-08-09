package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.slower.lulu.model.AttachmentBuilder;
import com.slower.lulu.model.DynamicTransform;
import com.slower.lulu.utils.Functions;
import io.swagger.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.slower.lulu.model.DynamicTransform.setValue;

public class ArtworkResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleArtwork(final ArtworkFlexPLMResponse artworkFlexPLMResponse) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, JsonProcessingException {

        final ArtworkBambooRoseResponse artworkBambooRoseResponse = new ArtworkBambooRoseResponse();

        final ArtworkLibH artworkLibH = new ArtworkLibH();
        final ArtworkLibB artworkLibB = new ArtworkLibB();
        List<ArtworkLibD> artworkLibDList = new ArrayList<ArtworkLibD>();

        final FlexplmHeader flexplmHeader = artworkFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        final List<Attribute> attributeList = flexplmHeader.getAttributeList();
        final Map transformations = DynamicTransform.getTransformations("config/if_3_artwork_transforms.yaml");
        final List<Map.Entry<String, String>> staticDefaults = DynamicTransform.getStaticDefaults(transformations);

        final Map<String, String> storedValues = Maps.newHashMap();
        final DynamicTransform indicatorTransform = DynamicTransform.getDynamicTransform(transformations, "event");
        setValue(artworkLibH, indicatorTransform.getOutputField(), indicatorTransform.resolveValue(null, flexplmHeader.getEVENT()));

        for (final Attribute attribute : attributeList) {
            final ArtworkLibD artworkLibD = new ArtworkLibD();

            // Combo ID is always set for libB and libD (but not libH)
            artworkLibB.setComboId(attribute.getOBJECTID());
            artworkLibD.setComboId(attribute.getOBJECTID());

            final String fieldName = attribute.getFIELDNAMEKEY();
            final String flexValue = attribute.getFIELDVALUEKEY();
            final DynamicTransform transform;
            try {
                 transform = DynamicTransform.getDynamicTransform(transformations, fieldName);
            } catch (IllegalArgumentException e) {
                // Failed to find transformation
                logger.warn(e.toString());
                continue;
            }

            final List<String> defaultBuilders = ImmutableList.of("lib_h", "lib_b", "lib_d");
            final List<String> builders = transform.getBuilderList()
                    .transform(s -> Lists.transform(Lists.newArrayList(s.split(",")), String::trim))
                    .or(defaultBuilders);

            if (transform.isAlwaysIncluded() || Functions.isChanged(attribute)) {
                if (transform.isAttachment()) { // Special handling for attachment type
                    AttachmentBuilder attachmentBuilder = new AttachmentBuilder(flexValue);
                    artworkLibB.setAttachment(attachmentBuilder);
                }
                else {
                    final String resolvedValue = transform.resolveValue(attribute);
                    final String key = transform.getOutputField();
                    storedValues.put(key, resolvedValue); // Track values over time so we can re-use, e.g. for memo1

                    for (String builder : builders) {
                        switch (builder) {
                            case "lib_h": setValue(artworkLibH, key, resolvedValue);
                                break;
                            case "lib_b": setValue(artworkLibB, key, resolvedValue);
                                break;
                            case "lib_d": setValue(artworkLibD, key, resolvedValue);
                                break;
                            default:
                                throw new IllegalArgumentException("Unsupported builder! Supported (lib_h, lib_b, lib_d");
                        }
                    }
                }

                // Color attributes (ground/color) require special one-off handling to store additional fields
                if(isColorAttribute(fieldName)) { // Special handling for artwork specific color attribute type
                    if (!storedValues.containsKey("memo1")) {
                        throw new IllegalArgumentException("Memo1 not set before attempting to process color fields. Ensure correct data is coming from Flex PLM");
                    }

                    final String memo1Value = storedValues.get("memo1");
                    artworkLibD.setMemo1(memo1Value);
                    String colorPos = fieldName.equals("ground") ? "0" : fieldName.substring(fieldName.length() - 1);
                    artworkLibD.setColorPos(colorPos);
                    artworkLibDList.add(artworkLibD);
                }
            }
        }

        // For default fields set them at the top level
        for (Map.Entry<String, String> keyValue : staticDefaults) {
            setValue(artworkLibH, keyValue.getKey(), keyValue.getValue());
        }

        artworkLibB.setArtworkLibD(artworkLibDList);
        artworkLibH.setArtworkLibB(artworkLibB);

        ArtworkDocument artworkDocument = new ArtworkDocument();
        ArtworkLib artworkLib = new ArtworkLib();

        artworkLib.setArtworkLibH(artworkLibH);
        artworkDocument.setArtworkLib(artworkLib);
        artworkBambooRoseResponse.setDocument(artworkDocument);

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(artworkBambooRoseResponse);
    }

    private boolean isColorAttribute(final String nameKey) {
         return nameKey.matches("(ground|color[1-9]*$)");
    }
}
