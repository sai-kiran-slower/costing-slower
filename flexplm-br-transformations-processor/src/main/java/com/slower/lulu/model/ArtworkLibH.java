package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ArtworkLibH
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-08T20:42:10.136-07:00")

public class ArtworkLibH   {
  @JsonProperty("@artwork_name")
  private String artworkName = null;

  @JsonProperty("@owner")
  private String owner = null;

  @JsonProperty("@active_ind")
  private String activeInd = null;

  @JsonProperty("@memo1")
  private String memo1 = null;

  @JsonProperty("@artwork_type")
  private String artworkType = null;

  @JsonProperty("@status")
  private String status = null;

  @JsonProperty("artwork_lib_b")
  private ArtworkLibB artworkLibB = null;

  public ArtworkLibH() {
  }

  public ArtworkLibH(String artworkName, String owner, String activeInd, String memo1, String artworkType, String status, ArtworkLibB artworkLibB) {
    this.artworkName = artworkName;
    this.owner = owner;
    this.activeInd = activeInd;
    this.memo1 = memo1;
    this.artworkType = artworkType;
    this.status = status;
    this.artworkLibB = artworkLibB;
  }

  public ArtworkLibH artworkName(String artworkName) {
    this.artworkName = artworkName;
    return this;
  }

   /**
   * Artwork Name
   * @return artworkName
  **/
  @ApiModelProperty(value = "Artwork Name")
  public String getArtworkName() {
    return artworkName;
  }

  public void setArtworkName(String artworkName) {
    this.artworkName = artworkName;
  }

  public ArtworkLibH owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * owner
   * @return owner
  **/
  @ApiModelProperty(value = "owner")
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public ArtworkLibH activeInd(String activeInd) {
    this.activeInd = activeInd;
    return this;
  }

   /**
   * active indicator
   * @return activeInd
  **/
  @ApiModelProperty(value = "active indicator")
  public String getActiveInd() {
    return activeInd;
  }

  public void setActiveInd(String activeInd) {
    this.activeInd = activeInd;
  }

  public ArtworkLibH memo1(String memo1) {
    this.memo1 = memo1;
    return this;
  }

   /**
   * Artwork Reference Object ID
   * @return memo1
  **/
  @ApiModelProperty(value = "Artwork Reference Object ID")
  public String getMemo1() {
    return memo1;
  }

  public void setMemo1(String memo1) {
    this.memo1 = memo1;
  }

  public ArtworkLibH artworkType(String artworkType) {
    this.artworkType = artworkType;
    return this;
  }

   /**
   * Artwork Type
   * @return artworkType
  **/
  @ApiModelProperty(value = "Artwork Type")
  public String getArtworkType() {
    return artworkType;
  }

  public void setArtworkType(String artworkType) {
    this.artworkType = artworkType;
  }

  public ArtworkLibH status(String status) {
    this.status = status;
    return this;
  }

   /**
   * status
   * @return status
  **/
  @ApiModelProperty(value = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ArtworkLibH artworkLibB(ArtworkLibB artworkLibB) {
    this.artworkLibB = artworkLibB;
    return this;
  }

   /**
   * Get artworkLibB
   * @return artworkLibB
  **/
  @ApiModelProperty(value = "")
  public ArtworkLibB getArtworkLibB() {
    return artworkLibB;
  }

  public void setArtworkLibB(ArtworkLibB artworkLibB) {
    this.artworkLibB = artworkLibB;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtworkLibH artworkLibH = (ArtworkLibH) o;
    return Objects.equals(this.artworkName, artworkLibH.artworkName) &&
        Objects.equals(this.owner, artworkLibH.owner) &&
        Objects.equals(this.activeInd, artworkLibH.activeInd) &&
        Objects.equals(this.memo1, artworkLibH.memo1) &&
        Objects.equals(this.artworkType, artworkLibH.artworkType) &&
        Objects.equals(this.status, artworkLibH.status) &&
        Objects.equals(this.artworkLibB, artworkLibH.artworkLibB);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artworkName, owner, activeInd, memo1, artworkType, status, artworkLibB);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtworkLibH {\n");

    sb.append("    artworkName: ").append(toIndentedString(artworkName)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    activeInd: ").append(toIndentedString(activeInd)).append("\n");
    sb.append("    memo1: ").append(toIndentedString(memo1)).append("\n");
    sb.append("    artworkType: ").append(toIndentedString(artworkType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    artworkLibB: ").append(toIndentedString(artworkLibB)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

