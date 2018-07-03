package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slower.lulu.model.*;
import com.slower.lulu.utils.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ColorResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleColor(final ColorFlexPLMResponse colorFlexPLMResponse) throws Exception {
        final ColorBambooRoseResponse colorBambooRoseResponse = new ColorBambooRoseResponse();
        final ColorDocument colorDocument = new ColorDocument();
        final ColorLibrary colorLibrary = new ColorLibrary();

        final ColorlibHBuilder colorlibHBuilder = new ColorlibHBuilder();

        final FlexplmHeader flexplmHeader = colorFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        final List<Attribute> attributeList = flexplmHeader.getAttributeList();

        colorlibHBuilder.setOwner("LULULEMON");
        colorlibHBuilder.setActiveInd(flexplmHeader.getEVENT());

        for (final Attribute attribute : attributeList) {
            final String nameKey = attribute.getFIELDNAMEKEY();
            final String valueKey = attribute.getFIELDVALUEKEY();

            if (nameKey.equalsIgnoreCase("colourwaycode")) {
                if (valueKey != null && valueKey.trim().isEmpty())
                    colorlibHBuilder.setMemo3(attribute.getOBJECTID());
                else
                    colorlibHBuilder.setMemo3(valueKey);
            } else if (Functions.isChanged(attribute)) {
                switch (nameKey.toLowerCase()) {
                    case "shortdescription":
                    case "abbreviation":
                        colorlibHBuilder.setColorName(valueKey);
                        break;
                    case "longdescription":
                    case "colorname":
                        colorlibHBuilder.setAltName1(valueKey);
                        break;
                    case "colortype":
                        colorlibHBuilder.setMemo2(valueKey);
                        break;
                    case "status":
                        colorlibHBuilder.setStatus(valueKey);
                        break;
                    case "rgb_r":
                        colorlibHBuilder.setRgbR(valueKey);
                        break;
                    case "rgb_g":
                        colorlibHBuilder.setRgbG(valueKey);
                        break;
                    case "rgb_b":
                        colorlibHBuilder.setRgbB(valueKey);
                        break;
                    case "thumbnail":
                        AttachmentBuilder attachmentBuilder = new AttachmentBuilder(valueKey);
                        colorlibHBuilder.setAttachment(attachmentBuilder);
                        break;
                    default:
                        logger.warn("Mapping not found for Attribute Key: "
                                + nameKey
                                + ", Attribute Value: "
                                + valueKey
                        );
                }
            } else {
                logger.info("INFO: Change indicator is 'N' for Attribute Key: "
                        + nameKey
                        + ", Attribute Value: "
                        + valueKey
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
}
