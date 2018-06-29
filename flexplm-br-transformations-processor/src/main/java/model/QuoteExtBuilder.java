package model;

public class QuoteExtBuilder {
    private String patternMaker;
    private String prodmgr;
    private String designer;

    public QuoteExtBuilder setPatternMaker(String patternMaker) {
        this.patternMaker = patternMaker;
        return this;
    }

    public QuoteExtBuilder setProdmgr(String prodmgr) {
        this.prodmgr = prodmgr;
        return this;
    }

    public QuoteExtBuilder setDesigner(String designer) {
        this.designer = designer;
        return this;
    }

    public QuoteExt createQuoteExt() {
        return new QuoteExt(patternMaker, prodmgr, designer);
    }
}