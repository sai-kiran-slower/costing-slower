package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class QuoteExtBuilder extends QuoteExt{
    private String patternMaker;
    private String prodmgr;
    private String designer;

    public void setPatternMaker(final String patternMaker) {
        this.patternMaker = Functions.charLimit(patternMaker, 18);
    }

    public void setProdmgr(final String prodmgr) {
        this.prodmgr = Functions.charLimit(prodmgr, 18);
    }

    public void setDesigner(final String designer) {
        this.designer = Functions.charLimit(designer, 18);
    }

    public QuoteExt createQuoteExt() {
        return new QuoteExt()
                .patternMaker(patternMaker)
                .prodmgr(prodmgr)
                .designer(designer);
    }
}