package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slower.lulu.model.*;
import com.slower.lulu.utils.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by saiki on 7/8/2018.
 */
public class ArtworkResponseHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String handleArtwork(final ArtworkFlexPLMResponse artworkFlexPLMResponse) throws Exception {

        final ArtworkBambooRoseResponse artworkBambooRoseResponse = new ArtworkBambooRoseResponse();

        final ArtworkLibHBuilder artworkLibHBuilder = new ArtworkLibHBuilder();
        final ArtworkLibBBuilder artworkLibBBuilder = new ArtworkLibBBuilder();
        List<ArtworkLibD> artworkLibDList = new ArrayList<ArtworkLibD>();

        final FlexplmHeader flexplmHeader = artworkFlexPLMResponse.getFlexInterface().getFlexPLMHeader();
        final List<Attribute> attributeList = flexplmHeader.getAttributeList();

        artworkLibHBuilder.setActiveInd(flexplmHeader.getEVENT());

        String memo1Value = null;

        for (final Attribute attribute : attributeList) {
            final ArtworkLibDBuilder artworkLibDBuilder = new ArtworkLibDBuilder();

            final String nameKey = attribute.getFIELDNAMEKEY().trim();
            final String valueKey = attribute.getFIELDVALUEKEY().trim();

            if (nameKey.equalsIgnoreCase("artwork")) {
                memo1Value = valueKey;
                artworkLibHBuilder.setMemo1(valueKey);

                artworkLibBBuilder.setMemo1(valueKey);
                artworkLibBBuilder.setComboId(attribute.getOBJECTID());

                artworkLibDBuilder.setMemo1(valueKey);
                artworkLibDBuilder.setComboId(attribute.getOBJECTID());
            }
            else if (Functions.isChanged(attribute)) {
                switch (nameKey.toLowerCase()) {
                    case "artname":
                        artworkLibHBuilder.setArtworkName(valueKey);
                        break;
                    case "colortype":
                        artworkLibHBuilder.setArtworkType(valueKey);
                        break;
                    case "status":
                        artworkLibHBuilder.setStatus(valueKey);
                        artworkLibBBuilder.setStatus(valueKey);
                        break;
                    case "colorname":
                        artworkLibBBuilder.setComboName(valueKey);
                        break;
                    case "abbreviation":
                        artworkLibBBuilder.setComboAbrv(valueKey);
                        break;
                    case "thumbnail":
                        final AttachmentBuilder attachmentBuilder = new AttachmentBuilder(valueKey);
                        artworkLibBBuilder.setAttachment(attachmentBuilder);
                        break;
                    default:
                        if (isColorAttribute(nameKey)) {
                            artworkLibDBuilder.setMemo1(memo1Value);
                            artworkLibDBuilder.setComboId(attribute.getOBJECTID());
                            artworkLibDBuilder.setMemo3(valueKey);
                            artworkLibDBuilder.setColorPos(nameKey);
                            artworkLibDList.add(artworkLibDBuilder.createArtworkLibD());
                        }
                        else {
                            logger.error("ERROR: Mapping not found for Attribute Key: "
                                    + nameKey
                                    + ", Attribute Value: "
                                    + valueKey
                            );
                        }
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
        artworkLibBBuilder.setArtworkLibD(artworkLibDList);
        artworkLibHBuilder.setArtworkLibB(artworkLibBBuilder.createArtworkLibB());

        ArtworkDocument artworkDocument = new ArtworkDocument();
        ArtworkLib artworkLib = new ArtworkLib();

        artworkLib.setArtworkLibH(artworkLibHBuilder.createArtworkLibH());
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
