package com.slower.lulu.model;

import com.slower.lulu.config.MappingConfig;
import com.slower.lulu.utils.Functions;
import com.slower.lulu.config.FlexBrMapping;

public class QuoteBuilder extends Quote{
    private String owner;
    private String itemNo;
    private String description;
    private String season;
    private String seasonYear;
    private String altDesc1;
    private String status04;
    private String requestType;
    private String status;
    private String buyProgramNo;
    private String commodity;
    private String brand;
    private String propertyClass;
    private String subclass;
    private String dept;
    private String division;
    private SizeRange sizeRanges;
    private QuoteExt quoteExt;
    private Attachment attachment;

    public QuoteBuilder() {
        setOwner("LULULEMON");
        setRequestType("FG");
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    @Override
    public void setItemNo(final String itemNo) {
        this.itemNo = Functions.charLimit(itemNo, 35);
    }

    @Override
    public void setDescription(final String description) {
        this.description = Functions.charLimit(description, 80);
    }

    @Override
    public void setSeason(final String season) {
        this.season = Functions.charLimit(season, 35);
    }

    @Override
    public void setSeasonYear(final String seasonYear) {
        this.seasonYear = Functions.charLimit(seasonYear, 35);
    }

    @Override
    public void setAltDesc1(final String altDesc1) {
        this.altDesc1 = Functions.charLimit(altDesc1, 80);
    }

    @Override
    public void setStatus04(final String status04) {
        this.status04 = Functions.getBRCode("quote", "seasonal_type", status04);
//        switch (status04.toLowerCase()) {
//            case "new":
//                this.status04 = "N";
//                break;
//            case "carryover":
//                this.status04 = "C";
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported value for status04: " + status04);
//        }
    }

    @Override
    public void setRequestType(final String requestType) {
        this.requestType = Functions.charLimit(requestType, 6);
    }

    @Override
    public void setStatus(final String status) {
        this.status = Functions.getBRCode("quote", "season_style_level_status", status);
//        switch (status.toLowerCase()) {
//            case "active":
//                this.status = "ACTIVE";
//                break;
//            case "drop":
//                this.status = "DROP";
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported value for status: " + status);
//        }
    }

    @Override
    public void setBuyProgramNo(final String buyProgramNo) {
        this.buyProgramNo = Functions.charLimit(buyProgramNo, 35);
    }

    @Override
    public void setCommodity(final String commodity) {
        this.commodity = Functions.charLimit(commodity, 30);
    }

    @Override
    public void setBrand(final String brand) {
        this.brand = Functions.charLimit(brand, 17);
    }

    @Override
    public void setPropertyClass(final String propertyClass) {
        this.propertyClass = Functions.charLimit(propertyClass, 17);
    }

    @Override
    public void setSubclass(final String subclass) {
        this.subclass = Functions.charLimit(subclass, 17);
    }

    @Override
    public void setDept(final String dept) {
        this.dept = Functions.charLimit(dept, 17);
    }

    @Override
    public void setDivision(final String division) {
        this.division = Functions.charLimit(division, 17);
    }

    @Override
    public void setSizeRanges(final SizeRange sizeRanges) {
        this.sizeRanges = sizeRanges;
    }

    @Override
    public void setQuoteExt(final QuoteExt quoteExt) {
        this.quoteExt = quoteExt;
    }

    @Override
    public void setAttachment(final Attachment attachment) {
        this.attachment = attachment;
    }

    public Quote createQuote() {
        return new Quote(owner, itemNo, description, season, seasonYear, altDesc1, status04, requestType, status, buyProgramNo, commodity, brand, propertyClass, subclass, dept, division, sizeRanges, quoteExt, attachment);
    }
}