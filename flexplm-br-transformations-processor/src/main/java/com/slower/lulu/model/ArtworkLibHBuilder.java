package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class ArtworkLibHBuilder extends ArtworkLibH{
    private String artworkName;
    private String owner;
    private String activeInd;
    private String memo1;
    private String artworkType;
    private String status;
    private ArtworkLibB artworkLibB;

    public ArtworkLibHBuilder() {
        setOwner("LULULEMON");
    }

    public void setArtworkName(final String artworkName) {
        this.artworkName = Functions.charLimit(artworkName, 35);
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public void setActiveInd(final String activeInd) {
        this.activeInd = Functions.charLimit(Functions.getBRCode("common", "active_ind", activeInd), 1);
    }

    public void setMemo1(final String memo1) {
        this.memo1 = Functions.charLimit(memo1, 10);
    }

    public void setArtworkType(final String artworkType) {
        this.artworkType = Functions.charLimit(artworkType, 10);
    }

    public void setStatus(final String status) {
        this.status = Functions.charLimit(Functions.getBRCode("color", "status", status), 8);
    }

    public void setArtworkLibB(final ArtworkLibB artworkLibB) {
        this.artworkLibB = artworkLibB;
    }

    public ArtworkLibH createArtworkLibH() {
        return new ArtworkLibH(artworkName, owner, activeInd, memo1, artworkType, status, artworkLibB);
    }
}