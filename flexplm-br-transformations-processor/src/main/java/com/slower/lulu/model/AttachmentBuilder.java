package com.slower.lulu.model;

public class AttachmentBuilder extends Attachment{
    private String location;
    private String attachmentNo;
    private String customLocation;
    private String iconLocation;
    private String largeviewLocation;
    private String overviewLocation;
    private String thumbnailLocation;

    public AttachmentBuilder(String location) {
        String imgFileName = location.substring(location.lastIndexOf('/') + 1);
        setLocation(imgFileName);
        setAttachmentNo("IMAGE");
        setCustomLocation("custom/" + imgFileName);
        setIconLocation("icons/" + imgFileName);
        setLargeviewLocation("largeview/" + imgFileName);
        setOverviewLocation("overview/" + imgFileName);
        setThumbnailLocation("thumbnails/" + imgFileName);
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setAttachmentNo(String attachmentNo) {
        this.attachmentNo = attachmentNo;
    }

    @Override
    public void setCustomLocation(String customLocation) {

        this.customLocation = customLocation;
    }

    @Override
    public void setIconLocation(String iconLocation) {
        this.iconLocation = iconLocation;
    }

    @Override
    public void setLargeviewLocation(String largeviewLocation) {
        this.largeviewLocation = largeviewLocation;
    }

    @Override
    public void setOverviewLocation(String overviewLocation) {
        this.overviewLocation = overviewLocation;
    }

    @Override
    public void setThumbnailLocation(String thumbnailLocation) {
        this.thumbnailLocation = thumbnailLocation;
    }

    public Attachment createAttachment() {
        return new Attachment(location, attachmentNo, customLocation, iconLocation, largeviewLocation, overviewLocation, thumbnailLocation);
    }
}