package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class ColorlibHBuilder extends ColorlibH{
    private String memo3;
    private String colorName;
    private String altName1;
    private String memo2;
    private String status;
    private String rgbR;
    private String rgbG;
    private String rgbB;
    private String owner;
    private String activeInd;
    private Attachment attachment;

    public ColorlibHBuilder() {
        setOwner("LULULEMON");
    }

    public void setMemo3(final String memo3) {
        this.memo3 = Functions.charLimit(memo3, 10);
    }

    public void setColorName(final String colorName) {
        this.colorName = Functions.charLimit(colorName, 35);
    }

    public void setAltName1(final String altName1) {
        this.altName1 = Functions.charLimit(altName1, 35);
    }

    public void setMemo2(String memo2) {
        this.memo2 = Functions.charLimit(Functions.getBRCode("color", "category", memo2), 35);
    }

    public void setStatus(final String status) {
        this.status = Functions.charLimit(Functions.getBRCode("color", "status", status), 8);
    }

    public void setRgbR(final String rgbR) {
        this.rgbR = Functions.charLimit(rgbR, 7);
    }

    public void setRgbG(final String rgbG) {
        this.rgbG = Functions.charLimit(rgbG, 7);
    }

    public void setRgbB(final String rgbB) {
        this.rgbB = Functions.charLimit(rgbB, 7);
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public void setActiveInd(final String activeInd) {
        this.activeInd = Functions.charLimit(Functions.getBRCode("common", "active_ind", activeInd), 1);
    }

    public void setAttachment(final Attachment attachment) {
        this.attachment = attachment;
    }

    public ColorlibH createColorlibH() {
        return new ColorlibH(memo3, colorName, altName1, memo2, status, rgbR, rgbG, rgbB, owner, activeInd, attachment);
    }
}