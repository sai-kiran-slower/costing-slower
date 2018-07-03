package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slower.lulu.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by saiki on 6/29/2018.
 */
public class ColorResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleColor(ColorFlexPLMResponse colorFlexPLMResponse) throws Exception {
        ColorBambooRoseResponse colorBambooRoseResponse = new ColorBambooRoseResponse();
        ColorDocument colorDocument = new ColorDocument();
        ColorLibrary colorLibrary = new ColorLibrary();

        ColorlibHBuilder colorlibHBuilder = new ColorlibHBuilder();

        FlexplmHeader flexplmHeader = colorFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        List<Attribute> attributeList = flexplmHeader.getAttributeList();

//        colorlibHBuilder.setOwner("LULULEMON");
        colorlibHBuilder.setActiveInd(flexplmHeader.getEVENT());

        for (Attribute attribute: attributeList) {
            String field_name_key = attribute.getFIELDNAMEKEY();
            if (attribute.getFIELDNAMEKEY().equalsIgnoreCase("colourwaycode")) {
                if (attribute.getFIELDVALUEKEY() != null && attribute.getFIELDVALUEKEY().trim().isEmpty())
                    colorlibHBuilder.setMemo3(attribute.getOBJECTID());
                else
                    colorlibHBuilder.setMemo3(attribute.getFIELDVALUEKEY());
            }
            else if (attribute.getCHANGEIND().equalsIgnoreCase("Y")) {
                switch (field_name_key.toLowerCase()) {
                    case "shortdescription":
                    case "abbreviation":
                        colorlibHBuilder.setColorName(attribute.getFIELDVALUEKEY());
                        break;
                    case "longdescription":
                    case "colorname":
                        colorlibHBuilder.setAltName1(attribute.getFIELDVALUEKEY());
                        break;
                    case "colortype":
                        colorlibHBuilder.setMemo2(attribute.getFIELDVALUEKEY());
                        break;
                    case "status":
                        colorlibHBuilder.setStatus(attribute.getFIELDVALUEKEY());
                        break;
                    case "rgb_r":
                        colorlibHBuilder.setRgbR(attribute.getFIELDVALUEKEY());
                        break;
                    case "rgb_g":
                        colorlibHBuilder.setRgbG(attribute.getFIELDVALUEKEY());
                        break;
                    case "rgb_b":
                        colorlibHBuilder.setRgbB(attribute.getFIELDVALUEKEY());
                        break;
                    case "thumbnail":
                        AttachmentBuilder attachmentBuilder = new AttachmentBuilder(attribute.getFIELDVALUEKEY());
                        colorlibHBuilder.setAttachment(attachmentBuilder.createAttachment());
                        break;
                    default:
                        logger.warn("Mapping not found for Attribute Key: "
                                + attribute.getFIELDNAMEKEY()
                                + ", Attribute Value: "
                                + attribute.getFIELDVALUEKEY()
                        );
                }
            }
            else {
                System.out.println("INFO: Change indicator is 'N' for Attribute Key: "
                        + attribute.getFIELDNAMEKEY()
                        + ", Attribute Value: "
                        + attribute.getFIELDVALUEKEY()
                );
            }
        }

        colorLibrary.setColorlibH(colorlibHBuilder.createColorlibH());
        colorDocument.setXmlnsxsi("http://www.w3.org/2001/XMLSchema-instance");
        colorDocument.setColorLibrary(colorLibrary);
        colorBambooRoseResponse.setDocument(colorDocument);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(colorBambooRoseResponse);
    }
}
