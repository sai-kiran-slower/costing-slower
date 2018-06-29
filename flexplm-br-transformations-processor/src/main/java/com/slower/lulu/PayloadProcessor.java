package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;

import java.util.List;

public class PayloadProcessor {

    public String processStyle(String payload) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        StyleFlexPLMResponse styleFlexPLMResponse = objectMapper.readValue(payload, StyleFlexPLMResponse.class);
        return handleStyle(styleFlexPLMResponse);
    }

    private String handleStyle(StyleFlexPLMResponse styleFlexPLMResponse) throws Exception {

        StyleBambooRoseResponse styleBambooRoseResponse = new StyleBambooRoseResponse();
        StyleDocument styleDocument = new StyleDocument();
        Request request = new Request();

        QuoteBuilder quoteBuilder = new QuoteBuilder();
        SizeRangeBuilder sizeRangeBuilder = new SizeRangeBuilder();
        QuoteExtBuilder quoteExtBuilder = new QuoteExtBuilder();
        AttachmentBuilder attachmentBuilder = new AttachmentBuilder();

        List<Attribute> attributeList = styleFlexPLMResponse.getFlexInterface().getFlexPLMHeader().getAttributeList();

        quoteBuilder.setOwner("LULULEMON");
        quoteBuilder.setRequestType("FG");

        for (Attribute attribute : attributeList) {
            String field_name_key = attribute.getFIELDNAMEKEY();
            if (attribute.getFIELDNAMEKEY().equalsIgnoreCase("stylenum")) {
                quoteBuilder.setItemNo(attribute.getFIELDVALUEKEY());
            }
            else if (attribute.getFIELDNAMEKEY().equalsIgnoreCase("seasoncode")) {
                quoteBuilder.setSeason(attribute.getFIELDVALUEKEY());
            }
            else if (attribute.getCHANGEIND().equalsIgnoreCase("Y")) {
                switch (field_name_key.toLowerCase()) {
                    case "stylenum":
                        quoteBuilder.setItemNo(attribute.getFIELDVALUEKEY());
                        break;
                    case "productname":
                        quoteBuilder.setDescription(attribute.getFIELDVALUEKEY());
                        break;
                    case "nameline1":
                        quoteBuilder.setAltDesc1(attribute.getFIELDVALUEKEY());
                        break;
                    case "productline":
                        quoteBuilder.setCommodity(attribute.getFIELDVALUEKEY());
                        break;
                    case "seasonalstyle":
                        quoteBuilder.setStatus04(attribute.getFIELDVALUEKEY());
                        break;
                    case "seasoncode":
                        quoteBuilder.setSeason(attribute.getFIELDVALUEKEY());
                        break;
                    case "year":
                        quoteBuilder.setSeasonYear(attribute.getFIELDVALUEKEY());
                        break;
                    case "masterstyleidnew":
                        quoteBuilder.setBuyProgramNo(attribute.getFIELDVALUEKEY());
                        break;
                    case "brand":
                        quoteBuilder.setBrand(attribute.getFIELDVALUEKEY());
                        break;
                    case "class":
                        quoteBuilder.setPropertyClass(attribute.getFIELDVALUEKEY());
                        break;
                    case "subclass":
                        quoteBuilder.setSubclass(attribute.getFIELDVALUEKEY());
                        break;
                    case "division":
                        quoteBuilder.setDivision(attribute.getFIELDVALUEKEY());
                        break;
                    case "category":
                        quoteBuilder.setDept(attribute.getFIELDVALUEKEY());
                        break;
                    case "status":
                        quoteBuilder.setStatus(attribute.getFIELDVALUEKEY());
                        break;
                    case "sourcingmanager":
                        quoteExtBuilder.setPatternMaker(attribute.getFIELDVALUEKEY());
                        quoteBuilder.setQuoteExt(quoteExtBuilder.createQuoteExt());
                        break;
                    case "productdeveloper":
                        quoteExtBuilder.setProdmgr(attribute.getFIELDVALUEKEY());
                        quoteBuilder.setQuoteExt(quoteExtBuilder.createQuoteExt());
                        break;
                    case "designernew":
                        quoteExtBuilder.setDesigner(attribute.getFIELDVALUEKEY());
                        quoteBuilder.setQuoteExt(quoteExtBuilder.createQuoteExt());
                        break;
                    case "sizescale":
                        sizeRangeBuilder.setSizeRange(attribute.getFIELDVALUEKEY());
                        quoteBuilder.setSizeRanges(sizeRangeBuilder.createSizeRange());
                        break;
                    case "thumbnail":
                        String img_loc = attribute.getFIELDVALUEKEY();
                        String img_file_name = img_loc.substring(img_loc.lastIndexOf('/') + 1);
                        attachmentBuilder.setLocation(img_file_name);
                        attachmentBuilder.setAttachmentNo("IMAGE");
                        attachmentBuilder.setCustomLocation("custom/" + img_file_name);
                        attachmentBuilder.setIconLocation("icons/" + img_file_name);
                        attachmentBuilder.setLargeviewLocation("largeview/" + img_file_name);
                        attachmentBuilder.setOverviewLocation("overview/" + img_file_name);
                        attachmentBuilder.setThumbnailLocation("thumbnails/" + img_file_name);
                        quoteBuilder.setAttachment(attachmentBuilder.createAttachment());
                        break;
                    default:
                        System.out.println("ERROR: Mapping not found for Attribute Key: "
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

        request.setQuote(quoteBuilder.createQuote());
        styleDocument.setRequest(request);
        styleBambooRoseResponse.setDocument(styleDocument);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(styleBambooRoseResponse);
    }

    public String processColor(String payload) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ColorFlexPLMResponse colorFlexPLMResponse = objectMapper.readValue(payload, ColorFlexPLMResponse.class);
        return new ColorResponseHandler().handleColor(colorFlexPLMResponse);
    }
}
