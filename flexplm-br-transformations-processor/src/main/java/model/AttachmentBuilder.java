package model;

public class AttachmentBuilder {
    private String location;
    private String attachmentNo;
    private String customLocation;
    private String iconLocation;
    private String largeviewLocation;
    private String overviewLocation;
    private String thumbnailLocation;

    public AttachmentBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    public AttachmentBuilder setAttachmentNo(String attachmentNo) {
        this.attachmentNo = attachmentNo;
        return this;
    }

    public AttachmentBuilder setCustomLocation(String customLocation) {
        this.customLocation = customLocation;
        return this;
    }

    public AttachmentBuilder setIconLocation(String iconLocation) {
        this.iconLocation = iconLocation;
        return this;
    }

    public AttachmentBuilder setLargeviewLocation(String largeviewLocation) {
        this.largeviewLocation = largeviewLocation;
        return this;
    }

    public AttachmentBuilder setOverviewLocation(String overviewLocation) {
        this.overviewLocation = overviewLocation;
        return this;
    }

    public AttachmentBuilder setThumbnailLocation(String thumbnailLocation) {
        this.thumbnailLocation = thumbnailLocation;
        return this;
    }

    public Attachment createAttachment() {
        return new Attachment(location, attachmentNo, customLocation, iconLocation, largeviewLocation, overviewLocation, thumbnailLocation);
    }
}