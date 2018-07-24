package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.slower.lulu.model.*;
import com.slower.lulu.utils.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColorResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleColor(final ColorFlexPLMResponse colorFlexPLMResponse) throws Exception {
        final ColorBambooRoseResponse colorBambooRoseResponse = new ColorBambooRoseResponse();
        final ColorDocument colorDocument = new ColorDocument();
        final ColorLibrary colorLibrary = new ColorLibrary();

        final ColorlibHBuilder colorlibHBuilder = new ColorlibHBuilder();

        final FlexplmHeader flexplmHeader = colorFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        final List<Attribute> attributeList = flexplmHeader.getAttributeList();

        // This stays as is
        colorlibHBuilder.setActiveInd(flexplmHeader.getEVENT());

        // TODO Replace with dynamic lookup
        // TODO Add "Field if NUll Handler"
        // TODO Add "length handler"
        // TODO Add "lookup handler"
        // TODO Add "is attachment handler"
        // TODO Add "static defaults "
        for (final Attribute attribute : attributeList) {
            final String fieldName = attribute.getFIELDNAMEKEY();
            final String flexValue = attribute.getFIELDVALUEKEY();

            if (fieldName.equalsIgnoreCase("colourwaycode")) {
                if (flexValue != null && flexValue.trim().isEmpty())
                    colorlibHBuilder.setMemo3(attribute.getOBJECTID());
                else
                    colorlibHBuilder.setMemo3(flexValue);
            } else if (Functions.isChanged(attribute)) {
                switch (fieldName.toLowerCase()) {
                    case "shortdescription":
                    case "abbreviation":
                        colorlibHBuilder.setColorName(flexValue);
                        break;
                    case "longdescription":
                    case "colorname":
                        colorlibHBuilder.setAltName1(flexValue);
                        break;
                    case "colortype":
                        colorlibHBuilder.setMemo2(flexValue);
                        break;
                    case "status":
                        colorlibHBuilder.setStatus(flexValue);
                        break;
                    case "rgb_r":
                        colorlibHBuilder.setRgbR(flexValue);
                        break;
                    case "rgb_g":
                        colorlibHBuilder.setRgbG(flexValue);
                        break;
                    case "rgb_b":
                        colorlibHBuilder.setRgbB(flexValue);
                        break;
                    case "thumbnail":
                        AttachmentBuilder attachmentBuilder = new AttachmentBuilder(flexValue);
                        colorlibHBuilder.setAttachment(attachmentBuilder);
                        break;
                    default:
                        logger.warn("Mapping not found for Attribute Key: "
                                + fieldName
                                + ", Attribute Value: "
                                + flexValue
                        );
                }
            } else {
                logger.info("INFO: Change indicator is 'N' for Attribute Key: "
                        + fieldName
                        + ", Attribute Value: "
                        + flexValue
                );
            }
        }

        colorLibrary.setColorlibH(colorlibHBuilder.createColorlibH());
        colorDocument.setXmlnsxsi("http://www.w3.org/2001/XMLSchema-instance");
        colorDocument.setColorLibrary(colorLibrary);
        colorBambooRoseResponse.setDocument(colorDocument);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(colorBambooRoseResponse);
    }

    public String handleColorDynamic(final ColorFlexPLMResponse colorFlexPLMResponse) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
        final ColorBambooRoseResponse colorBambooRoseResponse = new ColorBambooRoseResponse();
        final ColorDocument colorDocument = new ColorDocument();
        final ColorLibrary colorLibrary = new ColorLibrary();

        final ColorlibHBuilder colorlibHBuilder = new ColorlibHBuilder();

        final FlexplmHeader flexplmHeader = colorFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        final List<Attribute> attributeList = flexplmHeader.getAttributeList();

        // This stays as is
        colorlibHBuilder.setActiveInd(flexplmHeader.getEVENT());

        final Map transformations = DynamicTransform.getTransformations("config/if_2_color_transforms.yaml");

        final List<Map.Entry<String, String>> staticDefaults = DynamicTransform.getStaticDefaults(transformations);

        for (final Attribute attribute : attributeList) {
            final String fieldName = attribute.getFIELDNAMEKEY();
            final String flexValue = attribute.getFIELDVALUEKEY();

            final DynamicTransform transform = DynamicTransform.getDynamicTransform(transformations, fieldName);

            if (transform.isAlwaysIncluded() || Functions.isChanged(attribute)) {
                if (transform.isAttachment()) {
                    AttachmentBuilder attachmentBuilder = new AttachmentBuilder(flexValue);
                    colorlibHBuilder.setAttachment(attachmentBuilder);
                } else {
                    final String resolvedValue = transform.resolveValue("color", attribute);
                    setValue(colorlibHBuilder, transform.getOutputField(), resolvedValue);
                }
            }
        }

        for (Map.Entry<String, String> keyValue : staticDefaults) {
            setValue(colorlibHBuilder, keyValue.getKey(), keyValue.getValue());
        }

        colorLibrary.setColorlibH(colorlibHBuilder.createColorlibH());
        colorDocument.setXmlnsxsi("http://www.w3.org/2001/XMLSchema-instance");
        colorDocument.setColorLibrary(colorLibrary);
        colorBambooRoseResponse.setDocument(colorDocument);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(colorBambooRoseResponse);
    }

    private void setValue(final ColorlibHBuilder builder,
                          final String fieldName,
                          final String value) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final Method setMethod;
        final String setMethodName = Functions.setToCamelCase(fieldName);
        try {
            setMethod = builder.getClass().getMethod(setMethodName);
            setMethod.invoke(builder, value);
        } catch (NoSuchMethodException e) {
            logger.error("Failed to find method with name: " + setMethodName + ". Check output field name and/or static field name in dynamic mapping configuration file.");
            throw e;
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
