package model;

public class QuoteBuilder {
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

    public QuoteBuilder setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public QuoteBuilder setItemNo(String itemNo) {
        this.itemNo = itemNo;
        return this;
    }

    public QuoteBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public QuoteBuilder setSeason(String season) {
        this.season = season;
        return this;
    }

    public QuoteBuilder setSeasonYear(String seasonYear) {
        this.seasonYear = seasonYear;
        return this;
    }

    public QuoteBuilder setAltDesc1(String altDesc1) {
        this.altDesc1 = altDesc1;
        return this;
    }

    public QuoteBuilder setStatus04(String status04) {
        switch (status04.toLowerCase()) {
            case "new":
                this.status04 = "N";
                break;
            case "carryover":
                this.status04 = "C";
                break;
            default:
                this.status04 = "INVALID";
        }
        return this;
    }

    public QuoteBuilder setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public QuoteBuilder setStatus(String status) {
        switch (status.toLowerCase()) {
            case "active":
                this.status = "ACTIVE";
                break;
            case "drop":
                this.status = "DROP";
                break;
            default:
                this.status = "INVALID";
        }
        return this;
    }

    public QuoteBuilder setBuyProgramNo(String buyProgramNo) {
        this.buyProgramNo = buyProgramNo;
        return this;
    }

    public QuoteBuilder setCommodity(String commodity) {
        this.commodity = commodity;
        return this;
    }

    public QuoteBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public QuoteBuilder setPropertyClass(String propertyClass) {
        this.propertyClass = propertyClass;
        return this;
    }

    public QuoteBuilder setSubclass(String subclass) {
        this.subclass = subclass;
        return this;
    }

    public QuoteBuilder setDept(String dept) {
        this.dept = dept;
        return this;
    }

    public QuoteBuilder setDivision(String division) {
        this.division = division;
        return this;
    }

    public QuoteBuilder setSizeRanges(SizeRange sizeRanges) {
        this.sizeRanges = sizeRanges;
        return this;
    }

    public QuoteBuilder setQuoteExt(QuoteExt quoteExt) {
        this.quoteExt = quoteExt;
        return this;
    }

    public QuoteBuilder setAttachment(Attachment attachment) {
        this.attachment = attachment;
        return this;
    }

    public Quote createQuote() {
        return new Quote(owner, itemNo, description, season, seasonYear, altDesc1, status04, requestType, status, buyProgramNo, commodity, brand, propertyClass, subclass, dept, division, sizeRanges, quoteExt, attachment);
    }
}