package com.slower.lulu.model;

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
        this.artworkName = artworkName;
    }

    public void setOwner(final String owner) {
        this.owner = owner;
    }

    public void setActiveInd(final String activeInd) {
        this.activeInd = activeInd;
    }

    public void setMemo1(final String memo1) {
        this.memo1 = memo1;
    }

    public void setArtworkType(final String artworkType) {
        this.artworkType = artworkType;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setArtworkLibB(final ArtworkLibB artworkLibB) {
        this.artworkLibB = artworkLibB;
    }

    public ArtworkLibH createArtworkLibH() {
        return new ArtworkLibH(artworkName, owner, activeInd, memo1, artworkType, status, artworkLibB);
    }
}