package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slower.lulu.model.*;
import com.slower.lulu.utils.Functions;
import io.swagger.client.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ColorResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleColorDynamic(final ColorFlexPLMResponse colorFlexPLMResponse) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
        final ColorBambooRoseResponse colorBambooRoseResponse = new ColorBambooRoseResponse();
        final ColorDocument colorDocument = new ColorDocument();
        final ColorLibrary colorLibrary = new ColorLibrary();

        final ColorlibH colorlibHBuilder = new ColorlibH();

        final FlexplmHeader flexplmHeader = colorFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        final List<Attribute> attributeList = flexplmHeader.getAttributeList();

        final Map transformations = DynamicTransform.getTransformations("config/if_2_color_transforms.yaml");
        final DynamicTransform indicatorTransform = DynamicTransform.getDynamicTransform(transformations, "event");
        setValue(colorlibHBuilder, indicatorTransform.getOutputField(), flexplmHeader.getEVENT());

        final List<Map.Entry<String, String>> staticDefaults = DynamicTransform.getStaticDefaults(transformations);

        // Dynamically lookup field values / transformations and apply them
        // Note there are some exclusions, e.g. Attachment is not handled dynamically
        for (final Attribute attribute : attributeList) {
            final String fieldName = attribute.getFIELDNAMEKEY();
            final String flexValue = attribute.getFIELDVALUEKEY();

            final DynamicTransform transform;

            try {
                transform = DynamicTransform.getDynamicTransform(transformations, fieldName);
            } catch (IllegalArgumentException e) {
                // Failed to find transform.
                logger.warn(e.toString());
                continue;
            }

            if (transform.isAlwaysIncluded() || Functions.isChanged(attribute)) {
                if (transform.isAttachment()) {
                    AttachmentBuilder attachmentBuilder = new AttachmentBuilder(flexValue);
                    colorlibHBuilder.setAttachment(attachmentBuilder);
                } else {
                    final String resolvedValue = transform.resolveValue(attribute);
                    setValue(colorlibHBuilder, transform.getOutputField(), resolvedValue);
                }
            }
        }

        for (Map.Entry<String, String> keyValue : staticDefaults) {
            setValue(colorlibHBuilder, keyValue.getKey(), keyValue.getValue());
        }

        colorLibrary.setColorlibH(colorlibHBuilder);
        colorDocument.setXmlnsxsi("http://www.w3.org/2001/XMLSchema-instance");
        colorDocument.setColorLibrary(colorLibrary);
        colorBambooRoseResponse.setDocument(colorDocument);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(colorBambooRoseResponse);
    }

    private void setValue(final ColorlibH builder,
                          final String fieldName,
                          final String value) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final Method setMethod;
        final String setMethodName = Functions.setToCamelCase(fieldName);
        try {
            setMethod = builder.getClass().getMethod(setMethodName, String.class);
            setMethod.invoke(builder, value);
        } catch (NoSuchMethodException e) {
            logger.error("Failed to find method with name: " + setMethodName + ". Check output field name and/or static field name in dynamic mapping configuration file.");
            throw e;
        }
    }
}
