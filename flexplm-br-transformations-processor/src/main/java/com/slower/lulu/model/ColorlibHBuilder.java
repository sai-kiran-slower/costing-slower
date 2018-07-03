package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class ColorlibHBuilder {
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

    public ColorlibHBuilder setMemo3(final String memo3) {
        this.memo3 = Functions.charLimit(memo3, 10);
        return this;
    }

    public ColorlibHBuilder setColorName(final String colorName) {
        this.colorName = Functions.charLimit(colorName, 35);
        return this;
    }

    public ColorlibHBuilder setAltName1(final String altName1) {
        this.altName1 = Functions.charLimit(altName1, 35);
        return this;
    }

    public ColorlibHBuilder setMemo2(String memo2) {
        this.memo2 = Functions.charLimit(memo2, 35);
        return this;
    }

    public ColorlibHBuilder setStatus(final String status) {
        switch (status) {
            case "approved":
                this.status = "APPROVED";
                break;
            case "cfRejected":
                this.status = "CFREJECT";
                break;
            case "cancelled":
                this.status = "CCL";
                break;
            case "created":
                this.status = "CREATED";
                break;
            case "inProgress":
                this.status = "IP";
                break;
            case "limitedApproved":
                this.status = "LIMITAPP";
                break;
            case "requested":
                this.status = "REQUESTD";
                break;
            default:
                throw new IllegalArgumentException("Unsupported value for status: " + status);
        }

        this.status = Functions.charLimit(this.status, 8);
        return this;
    }

    public ColorlibHBuilder setRgbR(final String rgbR) {
        this.rgbR = Functions.charLimit(rgbR, 7);
        return this;
    }

    public ColorlibHBuilder setRgbG(final String rgbG) {
        this.rgbG = Functions.charLimit(rgbG, 7);
        return this;
    }

    public ColorlibHBuilder setRgbB(final String rgbB) {
        this.rgbB = Functions.charLimit(rgbB, 7);
        return this;
    }

    public ColorlibHBuilder setOwner(final String owner) {
        this.owner = owner;
        return this;
    }

    public ColorlibHBuilder setActiveInd(final String activeInd) {
        switch (activeInd) {
            case "CREATE":
                this.activeInd = "Y";
                break;
            case "UPDATE":
                this.activeInd = "Y";
                break;
            case "DELETE":
                this.activeInd = "N";
                break;
            default:
                throw new IllegalArgumentException("Unsupported active indicator: " + activeInd);
        }
        return this;
    }

    public ColorlibHBuilder setAttachment(final Attachment attachment) {
        this.attachment = attachment;
        return this;
    }

    public ColorlibH createColorlibH() {
        return new ColorlibH(memo3, colorName, altName1, memo2, status, rgbR, rgbG, rgbB, owner, activeInd, attachment);
    }
}