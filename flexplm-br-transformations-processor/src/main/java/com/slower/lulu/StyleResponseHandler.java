package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slower.lulu.model.*;
import com.slower.lulu.utils.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StyleResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleStyle(final StyleFlexPLMResponse styleFlexPLMResponse) throws Exception {
        final StyleBambooRoseResponse styleBambooRoseResponse = new StyleBambooRoseResponse();
        final StyleDocument styleDocument = new StyleDocument();
        final Request request = new Request();

        final QuoteBuilder quoteBuilder = new QuoteBuilder();
        final SizeRangeBuilder sizeRangeBuilder = new SizeRangeBuilder();
        final QuoteExtBuilder quoteExtBuilder = new QuoteExtBuilder();

        final List<Attribute> attributeList = styleFlexPLMResponse.getFlexInterface().getFlexPLMHeader().getAttributeList();

        for (final Attribute attribute : attributeList) {
            final String nameKey = attribute.getFIELDNAMEKEY().trim();
            final String valueKey = attribute.getFIELDVALUEKEY().trim();

            // TODO These logical keys appear to always be present in the flex PLM data (even if change ind = N),
            // Can we consume these from there or should these exclusively come from a static configuration file?
            if (nameKey.equalsIgnoreCase("stylenum")) {
                quoteBuilder.setItemNo(valueKey);
            }
            else if (nameKey.equalsIgnoreCase("seasoncode")) {
                quoteBuilder.setSeason(valueKey);
                if (Functions.isChanged(attribute)) {
                    quoteBuilder.setRefNo(valueKey);
                }
            }
            else if (Functions.isChanged(attribute)) {
                switch (nameKey.toLowerCase()) {
                    case "stylenum":
                        quoteBuilder.setItemNo(valueKey);
                        break;
                    case "productname":
                        quoteBuilder.setDescription(valueKey);
                        break;
                    case "lineoneGuestFacingName":
                        quoteBuilder.setAltDesc1(valueKey);
                        break;
                    case "productline":
                        quoteBuilder.setMemo1(valueKey);
                        break;
                    case "seasonalStyleType":
                        quoteBuilder.setStatus04(valueKey);
                        break;
                    case "seasoncode":
                        quoteBuilder.setSeason(valueKey);
                        quoteBuilder.setRefNo(valueKey);
                        break;
                    case "year":
                        quoteBuilder.setSeasonYear(valueKey);
                        break;
                    case "masterstyle":
                        quoteBuilder.setBuyProgramNo(valueKey);
                        break;
                    case "brand":
                        quoteBuilder.setBrand(valueKey);
                        break;
                    case "class":
                        quoteBuilder.setPropertyClass(valueKey);
                        break;
                    case "subclass":
                        quoteBuilder.setSubclass(valueKey);
                        break;
                    case "division":
                        quoteBuilder.setDivision(valueKey);
                        break;
                    case "department":
                        quoteBuilder.setDept(valueKey);
                        break;
                    case "styleStatus":
                        quoteBuilder.setStatus06(valueKey);
                        break;
                    case "sourcingmanager":
                        quoteExtBuilder.setPatternMaker(valueKey);
                        quoteBuilder.setQuoteExt(quoteExtBuilder.createQuoteExt());
                        break;
                    case "productdeveloper":
                        quoteExtBuilder.setProdmgr(valueKey);
                        quoteBuilder.setQuoteExt(quoteExtBuilder.createQuoteExt());
                        break;
                    case "designernew":
                        quoteExtBuilder.setDesigner(valueKey);
                        quoteBuilder.setQuoteExt(quoteExtBuilder.createQuoteExt());
                        break;
                    case "sizescale":
                        sizeRangeBuilder.setSizeRange(valueKey);
                        quoteBuilder.setSizeRanges(sizeRangeBuilder.createSizeRange());
                        break;
                    case "thumbnail":
                        final AttachmentBuilder attachmentBuilder = new AttachmentBuilder(valueKey);
                        quoteBuilder.setAttachment(attachmentBuilder);
                        break;
                    case "category":
                        quoteBuilder.setSubdept(valueKey);
                        break;
                    case "designline":
                        quoteBuilder.setMemo2(valueKey);
                        break;
                    case "initialprotoreviewmtgnotes":
                        quoteBuilder.setNotes(new NoteBuilder(valueKey));
                        break;
                    case "calendartrack":
                        quoteBuilder.setStatus05(valueKey);
                        break;
                    case "protosamplestatus":
                        quoteBuilder.setStatus03(valueKey);
                        break;
                    case "sizerunsamplestatus":
                        quoteBuilder.setStatus01(valueKey);
                        break;
                    default:
                        logger.error("ERROR: Mapping not found for Attribute Key: "
                                + nameKey
                                + ", Attribute Value: "
                                + valueKey
                        );
                }
            }
            else {
                logger.info("Change indicator is 'N' for Attribute Key: "
                        + nameKey
                        + ", Attribute Value: "
                        + valueKey
                );
            }
        }

        request.setQuote(quoteBuilder.createQuote());
        styleDocument.setRequest(request);
        styleBambooRoseResponse.setDocument(styleDocument);

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(styleBambooRoseResponse);
    }
}
