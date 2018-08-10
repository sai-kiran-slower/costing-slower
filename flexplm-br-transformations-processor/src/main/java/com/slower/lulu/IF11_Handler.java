package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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

/**
 * At a high level, if11 output generation involves a series of groupings
 *
 * For every Season and Item Number we generate a set of Quotes
 * Within each quote, we split by Sell Channel
 * Each Sell Channel has a Sell Channel Definition and 1 or more Sell Channel Flow definitions (1 for each color and planID)
 * A Sell Channel Definition
 */
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

        @Override
        public String toString() {
            return "Quote{" +
                    "season='" + season + '\'' +
                    ", itemNumber='" + itemNumber + '\'' +
                    '}';
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

        @Override
        public String toString() {
            return "SellChannel{" +
                    "quote=" + quote +
                    ", sellChannel='" + sellChannel + '\'' +
                    '}';
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

        @Override
        public String toString() {
            return "SellChannelFlow{" +
                    "sellChannel=" + sellChannel +
                    ", planId='" + planId + '\'' +
                    '}';
        }
    }

    class RpasRecord {
        int planTotal; // 8000
        String color; // 0001
        SellChannelFlow sellChannelFlow;

        public RpasRecord(int planTotal, String sellChannel, String planId, String season, String color, String itemNumber) {
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

        @Override
        public String toString() {
            return "RpasRecord{" +
                    "planTotal=" + planTotal +
                    ", color='" + color + '\'' +
                    ", sellChannelFlow=" + sellChannelFlow +
                    '}';
        }
    }

    /**
     * Compose a JSON response given an input set of IF11 records
     * @param if11Records A list of comma seperated values consumed from the queue (schema ssumed to be consistent with that provided on 8/1/2018
     */
    // Parse from fileName
    public String transform(final String payload) throws InvocationTargetException, NoSuchMethodException, JsonProcessingException, IllegalAccessException {
        final List<RpasRecord> rpasRecords = parseRpasRecordsFromPayload(payload);
        return transform(rpasRecords);
    }

    // TODO Add transform from Kafka stream

    private String transform(final List<RpasRecord> rpasRecords) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
        final If11BambooRoseResponse if11Response = new If11BambooRoseResponse();
        final If11Document if11Document = new If11Document();
        final If11Request if11Request = new If11Request();


        final Map<Quote, Set<SellChannel>> sellChannelMap = Maps.newHashMap();
        final Map<SellChannel, Set<SellChannelFlow>> sellChannelFlowMap = Maps.newHashMap();

        // We need counts both per sell channel and per sell channel flow
        final Map<SellChannel, MutableLong> sellChannelCounts = Maps.newHashMap();
        final Map<SellChannelFlow, MutableLong> sellChannelFlowCounts = Maps.newHashMap();

        // Track colors per sell channel
        final Map<SellChannel, Set<String>> sellChannelColors = Maps.newHashMap();

        // Do 1 pass over all the records to populate our maps so we can avoid doing a rough nested tree traversal
        rpasRecords.forEach(record -> {
            final SellChannelFlow sellChannelFlow = record.getSellChannelFlow();
            final SellChannel sellChannel = sellChannelFlow.getSellChannel();
            final Quote quote = sellChannel.getQuote();

            sellChannelMap.putIfAbsent(quote, Sets.newHashSet());
            sellChannelMap.get(quote).add(sellChannel);

            sellChannelFlowMap.putIfAbsent(sellChannel, Sets.newHashSet());
            sellChannelFlowMap.get(sellChannel).add(sellChannelFlow);

            sellChannelCounts.putIfAbsent(sellChannel, new MutableLong(0));
            sellChannelCounts.get(sellChannel).add(record.getPlanTotal());

            sellChannelFlowCounts.putIfAbsent(sellChannelFlow, new MutableLong(0));
            sellChannelFlowCounts.get(sellChannelFlow).add(record.getPlanTotal());

            sellChannelColors.putIfAbsent(sellChannel, Sets.newHashSet());
            sellChannelColors.get(sellChannel).add(record.getColor());
        });

        sellChannelMap.forEach((quote, sellChannels) -> {
            // We make one quote per season and item number
            final If11Quote if11Quote = new If11Quote();
            if11Quote.setFowner("LULULEMON");
            if11Quote.setSeason(convertSeason(quote.getSeason()));
            if11Quote.setItemNo(quote.getItemNumber().toUpperCase());

            sellChannels.forEach(sellChannel -> {
                final If11SellChannel if11SellChannel = new If11SellChannel();
                final long sellChannelCount = sellChannelCounts.get(sellChannel).getValue();
                if11SellChannel.setSellingChannel(sellChannel.getSellChannel());
                if11SellChannel.setPlanTotal(formatCount(sellChannelCount));

                final Set<String> colors = sellChannelColors.get(sellChannel);

                final List<If11SellChannelFlow> sellChannelFlows = computeSellChannelFlows(sellChannelFlowMap, sellChannelFlowCounts, quote.getSeason(), sellChannel, colors);
                final ImmutableList<If11SellChannelDefinition> sellChannelDefinitions = computeSellChannelDefinitions(colors);

                sellChannelFlows.forEach(if11SellChannel::addSellChannelFlowItem);
                sellChannelDefinitions.forEach(if11SellChannel::addSellChannelDefnItem);

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

    private List<If11SellChannelFlow> computeSellChannelFlows(
            final Map<SellChannel, Set<SellChannelFlow>> sellChannelFlowMap,
            final Map<SellChannelFlow, MutableLong> sellChannelFlowCounts,
            final String season,
            final SellChannel sellChannel,
            final Set<String> colors) {
        return ImmutableList.copyOf(sellChannelFlowMap.get(sellChannel).stream().flatMap(sellChannelFlow -> {
                        final long planQuantity = sellChannelFlowCounts.get(sellChannelFlow).getValue();
                        final String formattedQuantity = formatCount(planQuantity);

                        return colors.stream().map(color -> {
                            final If11SellChannelFlow if11SellChannelFlow = new If11SellChannelFlow();
                            if11SellChannelFlow.setPlanId(sellChannelFlow.getPlanId());
                            if11SellChannelFlow.setPlanQty(formattedQuantity);

                            final If11SellChannelD sellChannelD = new If11SellChannelD();
                            sellChannelD.allocBy1("STORE");
                            sellChannelD.allocBy2(season);
                            sellChannelD.allocBy3(color);

                            if11SellChannelFlow.setSellChannelD(sellChannelD);
                            return if11SellChannelFlow;
                        });
                    }).collect(Collectors.toList()));
    }

    private ImmutableList<If11SellChannelDefinition> computeSellChannelDefinitions(Set<String> colors) {
        List<If11SellChannelDefinition> sellChannelDefinitions = Lists.newArrayList();
        for (String color : colors) {
            final If11SellChannelDefinition if11SellChannelDefinition = new If11SellChannelDefinition();
            if11SellChannelDefinition.setAttribValue(color);
            if11SellChannelDefinition.setAttribName("COLOR");

            sellChannelDefinitions.add(if11SellChannelDefinition);
        }

        // Add a final static definition for store
        final If11SellChannelDefinition storeSellChannelDefinition = new If11SellChannelDefinition();
        storeSellChannelDefinition.setAttribValue("STORE");
        storeSellChannelDefinition.setAttribName("STORE");
        sellChannelDefinitions.add(storeSellChannelDefinition);

        return ImmutableList.copyOf(sellChannelDefinitions);
    }

    private String formatCount(long planQuantity) {
        return String.valueOf(planQuantity);
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

    public List<RpasRecord> parseRpasRecordsFromPayload(final String payload) {
        if (payload.isEmpty()) {
            return ImmutableList.of();
        }

        // Split lines by newline separator
        // TODO Validate this is valid
        String[] contents = payload.split("\n");
        Stream<String> lines = Stream.of(contents);

        final String schema = contents[0];
        final String[] splitSchema = schema.split(",");
        final Map<String, Integer> schemaMap = Maps.newHashMap();

        // We know that this data won't contain commas, this format may hange when consuing from RPAS directly
        for (int i = 0; i < splitSchema.length; i++) {
            schemaMap.put(splitSchema[i].replace("\"", "").trim(), i);
        }

        final List<String> rpasLines = lines.skip(1).map(line -> line.replace("\"", "")).collect(Collectors.toList());

        return parseRpasRecords(schemaMap, rpasLines);
    }

    private List<RpasRecord> parseRpasRecords(final Map<String, Integer> schema,
                                              final List<String> rawIf11Records) {
        return rawIf11Records.stream().map(line -> {
            String[] splitLine = line.split(",");

            // Hardcoded schema def for now, change later
            String week = splitLine[schema.get("WEEK")].trim();
            String styleChannel = splitLine[schema.get("STYC")].trim();
            long sellingChannel = Long.parseLong(splitLine[schema.get("STRE")]);
            int planTotal = (int) Math.round(Double.parseDouble(splitLine[schema.get("LCP_REC_U")]));

            return new RpasRecord(
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
