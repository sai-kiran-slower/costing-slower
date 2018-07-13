package com.slower.lulu.model;

import java.io.File;

public class AttachmentBuilder extends Attachment{
    public AttachmentBuilder(final String flexPlmFilePath) {
        if (flexPlmFilePath.isEmpty()) {
            setLocation("");
            setAttachmentNo("");
            setCustomLocation("");
            setIconLocation("");
            setLargeviewLocation("");
            setOverviewLocation("");
            setThumbnailLocation("");
        }
        else {
            final File file = new File(flexPlmFilePath);
            final String imgFileName = file.getName();
            setLocation(imgFileName);
            setAttachmentNo("IMAGE");
            setCustomLocation("custom/" + imgFileName);
            setIconLocation("icons/" + imgFileName);
            setLargeviewLocation("largeview/" + imgFileName);
            setOverviewLocation("overview/" + imgFileName);
            setThumbnailLocation("thumbnails/" + imgFileName);
        }
    }
}