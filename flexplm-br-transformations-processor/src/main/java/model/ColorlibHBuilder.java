package model;

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

    public ColorlibHBuilder setMemo3(String memo3) {
        this.memo3 = memo3;
        return this;
    }

    public ColorlibHBuilder setColorName(String colorName) {
        this.colorName = colorName;
        return this;
    }

    public ColorlibHBuilder setAltName1(String altName1) {
        this.altName1 = altName1;
        return this;
    }

    public ColorlibHBuilder setMemo2(String memo2) {
        this.memo2 = memo2;
        return this;
    }

    public ColorlibHBuilder setStatus(String status) {
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
                this.status = "INVALID";
        }
        return this;
    }

    public ColorlibHBuilder setRgbR(String rgbR) {
        this.rgbR = rgbR;
        return this;
    }

    public ColorlibHBuilder setRgbG(String rgbG) {
        this.rgbG = rgbG;
        return this;
    }

    public ColorlibHBuilder setRgbB(String rgbB) {
        this.rgbB = rgbB;
        return this;
    }

    public ColorlibHBuilder setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public ColorlibHBuilder setActiveInd(String activeInd) {
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
                this.activeInd = "INVALID";
        }
        return this;
    }

    public ColorlibHBuilder setAttachment(Attachment attachment) {
        this.attachment = attachment;
        return this;
    }

    public ColorlibH createColorlibH() {
        return new ColorlibH(memo3, colorName, altName1, memo2, status, rgbR, rgbG, rgbB, owner, activeInd, attachment);
    }
}