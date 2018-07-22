package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

import java.util.List;

public class ArtworkLibBBuilder extends ArtworkLibB{
    private String comboId;
    private String memo1;
    private String comboName;
    private String comboAbrv;
    private String status;
    private List<ArtworkLibD> artworkLibD;
    private Attachment attachment;

    public void setComboId(String comboId) {
        this.comboId = Functions.charLimit(comboId, 10);
    }

    public void setMemo1(String memo1) {
        this.memo1 = Functions.charLimit(memo1, 10);
    }

    public void setComboName(String comboName) {
        this.comboName = Functions.charLimit(comboName, 35);
    }

    public void setComboAbrv(String comboAbrv) {
        this.comboAbrv = Functions.charLimit(comboAbrv, 35);
    }

    public void setStatus(String status) {
        this.status = Functions.charLimit(Functions.getBRCode("color", "status", status), 8);
    }

    public void setArtworkLibD(List<ArtworkLibD> artworkLibD) {
        this.artworkLibD = artworkLibD;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public ArtworkLibB createArtworkLibB() {
        return new ArtworkLibB(comboId, memo1, comboName, comboAbrv, status, artworkLibD, attachment);
    }
}