package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class QuoteExtBuilder extends QuoteExt{
    private String patternMaker;
    private String prodmgr;
    private String designer;

    public void setPatternMaker(String patternMaker) {
        this.patternMaker = Functions.charLimit(patternMaker, 18);
    }

    public void setProdmgr(String prodmgr) {
        this.prodmgr = Functions.charLimit(prodmgr, 18);
    }

    public void setDesigner(String designer) {
        this.designer = Functions.charLimit(designer, 18);
    }

    public QuoteExt createQuoteExt() {
        return new QuoteExt(patternMaker, prodmgr, designer);
    }
}