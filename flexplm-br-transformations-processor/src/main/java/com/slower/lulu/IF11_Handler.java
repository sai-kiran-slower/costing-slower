package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.slower.lulu.model.*;
import com.slower.lulu.utils.Functions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IF11_Handler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static Map<Long, String> sellChannelLookupMap = getSellChannelLookupMap();

    private static Map<Long, String> getSellChannelLookupMap() {
        final Map<Long, String> lookupMap = Maps.newHashMap();
        // For now, just load the static resource

        BufferedReader br = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/if_11_storeId_sellChannel.txt")));

        Stream<String> lines = br.lines();
        lines.forEach(line -> {
                    String[] splitLines = line.split(",");
                    lookupMap.put(Long.parseLong(splitLines[0]), splitLines[1]);
                }
        );

        return lookupMap;
    }


    private List<RpasRecord> parseRpasRecords(List<String> rawIf11Records) {

        rawIf11Records.forEach(line -> {
            String[] splitLine= line.split(",");

            // Hardcoded schema def for now, change later
            String week = splitLine[1];
            String styleChannel = splitLine[2];
            long sellingChannel = Long.parseLong(splitLine[3]);
            int planTotal = (int) Math.round(Double.parseDouble(splitLine[4]));

            new RpasRecord(
                    planTotal,
                    sellChannelLookupMap.get(sellingChannel),
                    )


        });
    }

    /**
     * Return a string formatted as 2017-12 from a planId passed in as w12_2017
     */
    private String parsePlanId(final String week) {

    }

    /**
     * Return a string formatted as Spring 2017 from a planId passed in as w12_2017
     */
    private String parsePlanId(final String week) {

    }

    /**
     * @param iff11Records A list of comma separated strings representing the 15+ fields (we need only 5 of these)
     *                    coming from RPAS
     *
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws JsonProcessingException
     */
    public String transform(final List<String> if11Records) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
        final If11BambooRoseResponse if11Response = new If11BambooRoseResponse();
        final If11Document if11Document = new If11Document();
        final If11Quote if11Quote = new If11Quote();

        if11Records
        final List<String> sellChannels = ImmutableList.of();

        // TODO MAKE A QUOTE OBJECT FOR each saeson
        // TODO there are multiple sell channels per season
        for (String sellChannel: sellChannels) {
            final String seasonCode = ; //Fill me in
            final String stycCode = ; // TOOD Fill me in
            final String planQuantity = ; // TODO fill me in
            final If11SellChannelFlow sellChannelFlow = new If11SellChannelFlow();

            final If11SellChannelD sellChannelD = new If11SellChannelD();
            sellChannelD.allocBy1("STORE");
            sellChannelD.allocBy2(seasonCode);
            sellChannelD.allocBy3(stycCode);

            // Fill in sell channel defs
            final If11SellChannelDefinition sellChannelDefinition_1 = new If11SellChannelDefinition();
            final If11SellChannelDefinition sellChannelDefinition_2 = new If11SellChannelDefinition();

            sellChannelDefinition_1.setAttribValue(stycCode);
            sellChannelDefinition_1.setAttribName("COLOR");

            sellChannelDefinition_2.setAttribName("STORE");
            sellChannelDefinition_2.setAttribValue("STORE");

            sellChannelFlow.setPlanId(seasonCode);
            sellChannelFlow.setPlanQty(planQuantity);
            sellChannelFlow.setSellChannelD(sellChannelD);
            sellChannelFlow.addSellChannelDefnItem(sellChannelDefinition_1);
            sellChannelFlow.addSellChannelDefnItem(sellChannelDefinition_2);

            final If11SellChannel sellChannel = new If11SellChannel();
            final String sellingChannel = ; // Look me up
            sellChannel.setSellingChannel(sellingChannel);
            sellChannel.setPlanTotal(planQuantity);
            sellChannel.setSellChannelFlow(sellChannelFlow);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(colorBambooRoseResponse);
    }


    class RpasRecord {
        int planTotal;
        String sellChannel;
        String planId; // Derived
        String season; // Derived
        String styleChannelCode;

        public RpasRecord(int planTotal, String sellChannel, String planId, String season, String styleChannelCode) {
            this.planTotal = planTotal;
            this.sellChannel = sellChannel;
            this.planId = planId;
            this.season = season;
            this.styleChannelCode = styleChannelCode;
        }

        public int getPlanTotal() {
            return planTotal;
        }

        public String getSellChannel() {
            return sellChannel;
        }

        public String getPlanId() {
            return planId;
        }

        public String getSeason() {
            return season;
        }

        public String getStyleChannelCode() {
            return styleChannelCode;
        }
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
