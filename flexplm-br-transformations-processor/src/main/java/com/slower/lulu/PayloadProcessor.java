package com.slower.lulu;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.*;

import java.util.List;

public class PayloadProcessor {

    public String processStyle(String payload) throws Exception {
//        System.out.println("Payload: " + payload);
        ObjectMapper objectMapper = new ObjectMapper();
        StyleFlexPLMResponse styleFlexPLMResponse = objectMapper.readValue(payload, StyleFlexPLMResponse.class);
        return handleStyle(styleFlexPLMResponse);
    }

    private String handleStyle(StyleFlexPLMResponse styleFlexPLMResponse) throws Exception {

        StyleBambooRoseResponse styleBambooRoseResponse = new StyleBambooRoseResponse();
        Document document = new Document();
        Request request = new Request();
        Quote quote = new Quote();

        QuoteExt quoteExt = new QuoteExt();
        SizeRange sizeRange = new SizeRange();
        Attachment attachment = new Attachment();

        List<AttributeList> attributeLists = styleFlexPLMResponse.getFlexInterface().getFlexPLMHeader().getAttributeList();

        quote.setOwner("LULULEMON");

        for (AttributeList attributeObj : attributeLists) {
            String field_name_key = attributeObj.getFIELDNAMEKEY();
            switch (field_name_key.toLowerCase()) {
                case "stylenum":
                    quote.setItemNo(attributeObj.getFIELDVALUEKEY());
                    break;
                case "productname":
                    quote.setDescription(attributeObj.getFIELDVALUEKEY());
                    break;
                case "nameline1":
                    quote.setAltDesc1(attributeObj.getFIELDVALUEKEY());
                    break;
                case "productline":
                    quote.setCommodity(attributeObj.getFIELDVALUEKEY());
                    break;
                case "seasonalstyle":
                    quote.setStatus04(attributeObj.getFIELDVALUEKEY());
                    break;
                case "seasoncode":
                    quote.setSeason(attributeObj.getFIELDVALUEKEY());
                    break;
                case "year":
                    quote.setSeasonYear(attributeObj.getFIELDVALUEKEY());
                    break;
                case "masterstyleidnew":
                    quote.setBuyProgramNo(attributeObj.getFIELDVALUEKEY());
                    break;
                case "brand":
                    quote.setBrand(attributeObj.getFIELDVALUEKEY());
                    break;
                case "class":
                    quote.setPropertyClass(attributeObj.getFIELDVALUEKEY());
                    break;
                case "subclass":
                    quote.setSubclass(attributeObj.getFIELDVALUEKEY());
                    break;
                case "division":
                    quote.setDivision(attributeObj.getFIELDVALUEKEY());
                    break;
                case "category":
                    quote.setDept(attributeObj.getFIELDVALUEKEY());
                    break;
                case "status":
                    quote.setStatus(attributeObj.getFIELDVALUEKEY());
                    break;
                case "sourcingmanager":
                    quoteExt.setPatternMaker(attributeObj.getFIELDVALUEKEY());
                    quote.setQuoteExt(quoteExt);
                    break;
                case "productdeveloper":
                    quoteExt.setProdmgr(attributeObj.getFIELDVALUEKEY());
                    quote.setQuoteExt(quoteExt);
                    break;
                case "designernew":
                    quoteExt.setDesigner(attributeObj.getFIELDVALUEKEY());
                    quote.setQuoteExt(quoteExt);
                    break;
                case "sizescale":
                    sizeRange.setSizeRange(attributeObj.getFIELDVALUEKEY());
                    quote.setSizeRanges(sizeRange);
                    break;
                case "thumbnail":
                    String img_loc = attributeObj.getFIELDVALUEKEY();
                    String img_file_name = img_loc.substring(img_loc.lastIndexOf('/') + 1);
                    attachment.setLocation(img_file_name);
                    attachment.setAttachmentNo("IMAGE");
                    attachment.setCustomLocation("custom/" + img_file_name);
                    attachment.iconLocation("icons/" + img_file_name);
                    attachment.largeviewLocation("largeview/" + img_file_name);
                    attachment.overviewLocation("overview/" + img_file_name);
                    attachment.thumbnailLocation("thumbnails/" + img_file_name);
                    quote.setAttachment(attachment);
                    break;
                default:
                    System.out.println("ERROR: Mapping not found for Attribute Key: "
                            + attributeObj.getFIELDNAMEKEY()
                            + ", Attribute Value: "
                            + attributeObj.getFIELDVALUEKEY()
                    );

            }
        }

        request.setQuote(quote);
        document.setRequest(request);
        styleBambooRoseResponse.setDocument(document);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(styleBambooRoseResponse);
    }
}
