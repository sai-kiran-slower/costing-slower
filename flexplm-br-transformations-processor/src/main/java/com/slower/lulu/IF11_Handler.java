package com.slower.lulu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.swagger.model.*;
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

    class RpasRecord {
        int planTotal; // 8000
        String styleChannelCode; // 0001
        SellChannel sellChannelKey;

        public RpasRecord(int planTotal, String sellChannel, String planId, String season, String styleChannelCode, String itemNumber) {
            this.planTotal = planTotal;
            this.styleChannelCode = styleChannelCode;
            this.sellChannelKey = new SellChannel(sellChannel, planId, season, itemNumber);
        }

        public int getPlanTotal() {
            return planTotal;
        }

        public String getStyleChannelCode() {
            return styleChannelCode;
        }

        public SellChannel getSellChannelKey() {
            return sellChannelKey;
        }
    }

    class SellChannel {
        String season; // Spring 2017
        String itemNumber; // lw5ahos
        String sellChannel; // ASIA
        String planId; // 2017-01

        public SellChannel(String sellChannel, String planId, String season, String itemNumber) {
            this.sellChannel = sellChannel;
            this.planId = planId;
            this.season = season;
            this.itemNumber = itemNumber;
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

        public String getItemNumber() { return itemNumber; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SellChannel aggregate = (SellChannel) o;

            if (season != null ? !season.equals(aggregate.season) : aggregate.season != null) return false;
            if (itemNumber != null ? !itemNumber.equals(aggregate.itemNumber) : aggregate.itemNumber != null)
                return false;
            if (sellChannel != null ? !sellChannel.equals(aggregate.sellChannel) : aggregate.sellChannel != null)
                return false;
            return planId != null ? planId.equals(aggregate.planId) : aggregate.planId == null;
        }

        @Override
        public int hashCode() {
            int result = season != null ? season.hashCode() : 0;
            result = 31 * result + (itemNumber != null ? itemNumber.hashCode() : 0);
            result = 31 * result + (sellChannel != null ? sellChannel.hashCode() : 0);
            result = 31 * result + (planId != null ? planId.hashCode() : 0);
            return result;
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
        final List<RpasRecord> rpasRecords = parseRpasRecords(if11Records);

        // Next we need to aggregate the RPAS records by their SellChannel key (sell channel, item number, season, and plan_id)
        final Map<SellChannel, Long> sellChannelCounts = Maps.newHashMap();

        rpasRecords.forEach(record -> {
            final SellChannel key = record.getSellChannelKey();
            if (sellChannelCounts.containsKey(key)) {
                sellChannelCounts.put(key, sellChannelCounts.get(key) + record.getPlanTotal());
            } else {
                sellChannelCounts.put(key, (long) record.getPlanTotal());
            }
        });

        final Set<String> seasons = rpasRecords.stream().map(s -> s.getSellChannelKey().getSeason()).collect(Collectors.toSet());

        // We will have one quote per season and item number

        // TODO instead of filtering every time we can compose a three-layer deep map but may be unecessary optimization given data volumes
        for (final String season : seasons) {
            final List<RpasRecord> recordsPerSeason = rpasRecords
                    .stream()
                    .filter(s -> s.getSellChannelKey().getSeason().equals(season))
                    .collect(Collectors.toList());

            final Set<String> itemNumbers = recordsPerSeason
                    .stream()
                    .map(s -> s.getSellChannelKey().getItemNumber())
                    .collect(Collectors.toSet());

            for (String itemNumber : itemNumbers) {
                final List<RpasRecord> recordsPerSeasonAndItemNumber = recordsPerSeason
                        .stream()
                        .filter(s -> s.getSellChannelKey().getItemNumber().equals(itemNumber))
                        .collect(Collectors.toList());

                // We make one quote per season and item number
                final If11Quote if11Quote = new If11Quote();
                if11Quote.setItemNo(itemNumber.toUpperCase());
                if11Quote.setFowner("LULULEMON");
                if11Quote.setSeason(convertSeason(season));


                // Track which sell channels were processed since we will only add one record per sell channel per
                // season and item number

                final Set<SellChannel> processedSellChannels = Sets.newHashSet();
                for (final RpasRecord record: recordsPerSeasonAndItemNumber) {
                    if (processedSellChannels.contains(record.getSellChannelKey())) {
                        continue;
                    }

                    final String seasonCode = record.getSellChannelKey().getSeason(); //Fill me in
                    final String stycCode = record.getStyleChannelCode(); // 0001
                    final long planQuantity = sellChannelCounts.get(record.getSellChannelKey()); // TODO fill me in
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
                    String formattedQuantity = String.valueOf(planQuantity);
                    sellChannelFlow.setPlanQty(formattedQuantity);
                    sellChannelFlow.setSellChannelD(sellChannelD);
                    sellChannelFlow.addSellChannelDefnItem(sellChannelDefinition_1);
                    sellChannelFlow.addSellChannelDefnItem(sellChannelDefinition_2);

                    final If11SellChannel sellChannel = new If11SellChannel();
                    final String sellingChannel = record.getSellChannelKey().getSellChannel();
                    sellChannel.setSellingChannel(sellingChannel);
                    sellChannel.setPlanTotal(formattedQuantity);
                    sellChannel.setSellChannelFlow(sellChannelFlow);

                    processedSellChannels.add(record.getSellChannelKey());
                    if11Quote.addSellChannelItem(sellChannel);
                }

                if11Request.addRequestItem(if11Quote);
            }
        }

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

    private List<RpasRecord> parseRpasRecords(List<String> rawIf11Records) {
        return rawIf11Records.stream().map(line -> {
            String[] splitLine= line.split(",");

            // Hardcoded schema def for now, change later
            String week = splitLine[1];
            String styleChannel = splitLine[2];
            long sellingChannel = Long.parseLong(splitLine[3]);
            int planTotal = (int) Math.round(Double.parseDouble(splitLine[4]));

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
