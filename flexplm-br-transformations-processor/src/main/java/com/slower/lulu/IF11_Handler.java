package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.swagger.model.*;
import org.apache.commons.lang3.mutable.MutableLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IF11_Handler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static Map<Long, String> sellChannelLookupMap = getSellChannelLookupMap();

    class Quote {
        String season; // Spring 2017
        String itemNumber; // lw5ahos

        public Quote(String season, String itemNumber) {
            this.season = season;
            this.itemNumber = itemNumber;
        }

        public String getSeason() {
            return season;
        }

        public String getItemNumber() { return itemNumber; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Quote quote = (Quote) o;

            if (season != null ? !season.equals(quote.season) : quote.season != null) return false;
            return itemNumber != null ? itemNumber.equals(quote.itemNumber) : quote.itemNumber == null;
        }

        @Override
        public int hashCode() {
            int result = season != null ? season.hashCode() : 0;
            result = 31 * result + (itemNumber != null ? itemNumber.hashCode() : 0);
            return result;
        }
    }

    class SellChannel {
        Quote quote;
        String sellChannel; // ASIA

        public SellChannel(Quote quote, String sellChannel) {
            this.quote = quote;
            this.sellChannel = sellChannel;
        }

        public Quote getQuote() {
            return quote;
        }

        public String getSellChannel() {
            return sellChannel;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SellChannel that = (SellChannel) o;

            if (quote != null ? !quote.equals(that.quote) : that.quote != null) return false;
            return sellChannel != null ? sellChannel.equals(that.sellChannel) : that.sellChannel == null;
        }

        @Override
        public int hashCode() {
            int result = quote != null ? quote.hashCode() : 0;
            result = 31 * result + (sellChannel != null ? sellChannel.hashCode() : 0);
            return result;
        }
    }

    class SellChannelFlow {
        SellChannel sellChannel;
        String planId; // 2017-01

        public SellChannelFlow(SellChannel sellChannel, String planId) {
            this.sellChannel = sellChannel;
            this.planId = planId;
        }

        public SellChannel getSellChannel() {
            return sellChannel;
        }

        public String getPlanId() {
            return planId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SellChannelFlow that = (SellChannelFlow) o;

            if (sellChannel != null ? !sellChannel.equals(that.sellChannel) : that.sellChannel != null) return false;
            return planId != null ? planId.equals(that.planId) : that.planId == null;
        }

        @Override
        public int hashCode() {
            int result = sellChannel != null ? sellChannel.hashCode() : 0;
            result = 31 * result + (planId != null ? planId.hashCode() : 0);
            return result;
        }
    }

    class ColorSellChannel {
        int planTotal; // 8000
        String color; // 0001
        SellChannelFlow sellChannelFlow;

        public ColorSellChannel(int planTotal, String sellChannel, String planId, String season, String color, String itemNumber) {
            this.planTotal = planTotal;
            this.color = color;
            this.sellChannelFlow = new SellChannelFlow(new SellChannel(new Quote(season, itemNumber), sellChannel), planId);
        }

        public int getPlanTotal() {
            return planTotal;
        }

        public String getColor() {
            return color;
        }

        public SellChannelFlow getSellChannelFlow() {
            return sellChannelFlow;
        }
    }

    /**
     * Compose a JSON response given an input set of IF11 records
     * @param if11Records A set of comma seperated values consumed from the queue (schema ssumed to be consistent with that provided on 8/1/2018
     */
    public String transform(final List<String> if11Records) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
        final If11BambooRoseResponse if11Response = new If11BambooRoseResponse();
        final If11Document if11Document = new If11Document();
        final If11Request if11Request = new If11Request();
        final List<ColorSellChannel> rpasRecords = parseRpasRecords(if11Records);

        final Map<Quote, List<SellChannel>> sellChannelMap = Maps.newHashMap();
        final Map<SellChannel, List<SellChannelFlow>> sellChannelFlowMap = Maps.newHashMap();

        // Next we need to aggregate the RPAS records by their SellChannelFlow key (sell channel, item number, season, and plan_id)
        final Map<SellChannelFlow, MutableLong> sellChannelCounts = Maps.newHashMap();

        // Track colors per sell channel
        final Map<SellChannelFlow, List<String>> sellChannelColors = Maps.newHashMap();

        // Do 1 pass over all the records to populate our maps so we can avoid doing a rough nested tree traversal
        rpasRecords.forEach(record -> {
            final SellChannelFlow sellChannelFlow = record.getSellChannelFlow();
            final SellChannel sellChannel = sellChannelFlow.getSellChannel();
            final Quote quote = sellChannel.getQuote();

            sellChannelMap.putIfAbsent(quote, Lists.newArrayList());
            sellChannelMap.get(quote).add(sellChannel);

            sellChannelFlowMap.putIfAbsent(sellChannel, Lists.newArrayList());
            sellChannelFlowMap.get(sellChannel).add(sellChannelFlow);

            sellChannelCounts.putIfAbsent(sellChannelFlow, new MutableLong(0));
            sellChannelCounts.get(sellChannelFlow).add(record.getPlanTotal());

            sellChannelColors.putIfAbsent(sellChannelFlow, Lists.newArrayList());
            sellChannelColors.get(sellChannelFlow).add(record.getColor());
        });

        sellChannelMap.forEach((quote, sellChannels) -> {
            // We make one quote per season and item number
            final If11Quote if11Quote = new If11Quote();
            if11Quote.setFowner("LULULEMON");
            if11Quote.setSeason(convertSeason(quote.getSeason()));
            if11Quote.setItemNo(quote.getItemNumber().toUpperCase());

            sellChannels.forEach(sellChannel -> {
                final If11SellChannel if11SellChannel = new If11SellChannel();

                sellChannelFlowMap.get(sellChannel).forEach(sellChannelFlow -> {
                    final If11SellChannelFlow if11SellChannelFlow = new If11SellChannelFlow();
                    final long planQuantity = sellChannelCounts.get(sellChannelFlow).getValue();
                    final String formattedQuantity = String.valueOf(planQuantity);

                    if11SellChannelFlow.setPlanId(sellChannelFlow.getPlanId());
                    if11SellChannelFlow.setPlanQty(formattedQuantity);

                    final List<String> colors = sellChannelColors.get(sellChannelFlow);
                    for (String color : colors) {
                        final If11SellChannelD sellChannelD = new If11SellChannelD();
                        sellChannelD.allocBy1("STORE");
                        sellChannelD.allocBy2(quote.getSeason());
                        sellChannelD.allocBy3(color);

                        // Fill in sell channel defs
                        final If11SellChannelDefinition sellChannelDefinition_1 = new If11SellChannelDefinition();
                        final If11SellChannelDefinition sellChannelDefinition_2 = new If11SellChannelDefinition();

                        sellChannelDefinition_1.setAttribValue(color);
                        sellChannelDefinition_1.setAttribName("COLOR");

                        sellChannelDefinition_2.setAttribName("STORE");
                        sellChannelDefinition_2.setAttribValue("STORE");

                        // TODO This doesn't make sense, do we do this for every color??
                        if11SellChannelFlow.setSellChannelD(sellChannelD);
                        if11SellChannelFlow.addSellChannelDefnItem(sellChannelDefinition_1);
                        if11SellChannelFlow.addSellChannelDefnItem(sellChannelDefinition_2);
                    }

                    // TODO This doesnt make sense, this should be an add
                    if11SellChannel.setSellChannelFlow(if11SellChannelFlow);
                });

                if11SellChannel.setSellingChannel(sellChannel.getSellChannel());

                // TODO This isn't right, should be aggregated across sell channel flows
                if11SellChannel.setPlanTotal(formattedQuantity);

                if11Quote.addSellChannelItem(if11SellChannel);
            });

            if11Request.addQuoteItem(if11Quote);
        });

        if11Document.setRequest(if11Request);
        if11Response.setDocument(if11Document);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(if11Response);
    }

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

    private List<ColorSellChannel> parseRpasRecords(List<String> rawIf11Records) {
        return rawIf11Records.stream().map(line -> {
            String[] splitLine= line.split(",");

            // Hardcoded schema def for now, change later
            String week = splitLine[1];
            String styleChannel = splitLine[2];
            long sellingChannel = Long.parseLong(splitLine[3]);
            int planTotal = (int) Math.round(Double.parseDouble(splitLine[4]));

            return new ColorSellChannel(
                    planTotal,
                    sellChannelLookupMap.get(sellingChannel),
                    parsePlanId(week),
                    parseSeason(week),
                    parseStyleChannelCode(styleChannel),
                    parseItemNumber(styleChannel)
            );
        }).collect(Collectors.toList());
    }

    /**
     * Return a string formatted as 2017-12 from a planId passed in as w12_2017
     */
    private String parsePlanId(final String week) {
        String weekNum = week.substring(1, 3);
        String yearNum = week.split("_")[1];

        return yearNum + "-" + weekNum;
    }

    /**
     * Return a string formatted as Spring 2017 from a planId passed in as w12_2017
     */
    private String parseSeason(final String week) {
        int weekNum = Integer.parseInt(week.substring(1, 3));
        String yearNum = week.split("_")[1];

        if (weekNum <= 13) {
            return "Spring " + yearNum;
        } else if (weekNum <= 26) {
            return "Summer " + yearNum;
        } else if (weekNum <= 39) {
            return "Fall " + yearNum;
        } else if (weekNum <= 52){
            return "Winter " + yearNum;
        } else {
            throw new IllegalArgumentException("Week must be between 01 and 52");
        }
    }

    /**
     * Return a string formatted as 0001 from a style channel code passed in as lw5ahos-0001
     */
    private String parseStyleChannelCode(final String styleChannel) {
        return styleChannel.split("-")[1];
    }

    /**
     * Return a string formatted as lw5ahos from a style channel code passed in as lw5ahos-0001
     */
    private String parseItemNumber(final String styleChannel) {
        return styleChannel.split("-")[0];
    }

    /**
     * Converts the Season representation from Spring 2017 to 17-1SP
     */
    private String convertSeason(final String season) {
        final String[] splitString = season.split(" ");

        String yearCode = splitString[1].substring(2, 4);
        switch (splitString[0]) {
            case "Spring" :
                return yearCode + "-1SP";
            case "Summer" :
                return yearCode + "-2SU";
            case "Fall" :
                return yearCode + "-3FA";
            case "Winter" :
                return yearCode + "-4WI";
            default:
                throw new IllegalArgumentException("Season must be formatted as Spring/Winter/Fall/Summer YYYY");
        }
    }
}
