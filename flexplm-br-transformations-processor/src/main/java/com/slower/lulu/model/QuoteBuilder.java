package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class QuoteBuilder extends Quote{
    private String owner;
    private String itemNo;
    private String description;
    private String season;
    private String seasonYear;
    private String altDesc1;
    private String status04;
    private String requestType;
    private String status06;
    private String buyProgramNo;
    private String memo1;
    private String brand;
    private String propertyClass;
    private String subclass;
    private String dept;
    private String division;
    private String refNo;
    private String subdept;
    private String memo2;
    private String status01;
    private String status03;
    private String status05;
    private Note notes;
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
        this.status04 = Functions.charLimit(Functions.getBRCode("quote", "seasonal_type", status04), 8);
    }

    @Override
    public void setRequestType(final String requestType) {
        this.requestType = Functions.charLimit(requestType, 6);
    }

    @Override
    public void setStatus06(final String status) {
        this.status06 = Functions.charLimit(Functions.getBRCode("quote", "season_style_level_status", status), 8);
    }

    @Override
    public void setBuyProgramNo(final String buyProgramNo) {
        this.buyProgramNo = Functions.charLimit(buyProgramNo, 35);
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

    @Override
    public void setMemo1(final String memo1) {
        this.memo1 = Functions.charLimit(Functions.getBRCode("quote", "design_pod", memo1), 30);
    }

    @Override
    public void setRefNo(final String refNo) {
        this.refNo = Functions.charLimit(refNo, 35);
    }

    @Override
    public void setSubdept(final String subdept) {
        this.subdept = Functions.charLimit(Functions.getBRCode("quote", "category", subdept), 17);
    }

    @Override
    public void setMemo2(final String memo2) {
        this.memo2 = Functions.charLimit(Functions.getBRCode("quote", "design_line", memo2), 35);
    }

    @Override
    public void setStatus01(final String status01) {
        this.status01 = Functions.charLimit(Functions.getBRCode("quote", "size_run_sample_status", status01), 8);
    }

    @Override
    public void setStatus03(final String status03) {
        this.status03 = Functions.charLimit(Functions.getBRCode("quote", "proto_sample_status", status03), 8);
    }

    @Override
    public void setStatus05(final String status05) {
        this.status05 = Functions.charLimit(Functions.getBRCode("quote", "calendar_track", status05), 8);
    }

    @Override
    public void setNotes(final Note notes) {
        this.notes = notes;
    }

    public Quote createQuote() {
        return new Quote(owner, itemNo, description, season, seasonYear, altDesc1, status04, requestType, status06, buyProgramNo, memo1, brand, propertyClass, subclass, dept, division, refNo, subdept, memo2, status01, status03, status05, notes, sizeRanges, quoteExt, attachment);
    }
}