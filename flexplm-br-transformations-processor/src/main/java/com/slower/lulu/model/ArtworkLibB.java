package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ArtworkLibB
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-08T20:42:10.136-07:00")

public class ArtworkLibB   {
  @JsonProperty("@combo_id")
  private String comboId = null;

  @JsonProperty("@memo1")
  private String memo1 = null;

  @JsonProperty("@combo_name")
  private String comboName = null;

  @JsonProperty("@combo_abrv")
  private String comboAbrv = null;

  @JsonProperty("@status")
  private String status = null;

  @JsonProperty("artwork_lib_d")
  private List<ArtworkLibD> artworkLibD = new ArrayList<ArtworkLibD>();

  @JsonProperty("attachment")
  private Attachment attachment = null;

  public ArtworkLibB comboId(String comboId) {
    this.comboId = comboId;
    return this;
  }

   /**
   * Combo ID
   * @return comboId
  **/
  @ApiModelProperty(value = "Combo ID")
  public String getComboId() {
    return comboId;
  }

  public void setComboId(String comboId) {
    this.comboId = comboId;
  }

  public ArtworkLibB memo1(String memo1) {
    this.memo1 = memo1;
    return this;
  }

   /**
   * Artwork No
   * @return memo1
  **/
  @ApiModelProperty(value = "Artwork No")
  public String getMemo1() {
    return memo1;
  }

  public void setMemo1(String memo1) {
    this.memo1 = memo1;
  }

  public ArtworkLibB comboName(String comboName) {
    this.comboName = comboName;
    return this;
  }

   /**
   * Combo Name
   * @return comboName
  **/
  @ApiModelProperty(value = "Combo Name")
  public String getComboName() {
    return comboName;
  }

  public void setComboName(String comboName) {
    this.comboName = comboName;
  }

  public ArtworkLibB comboAbrv(String comboAbrv) {
    this.comboAbrv = comboAbrv;
    return this;
  }

   /**
   * Combo
   * @return comboAbrv
  **/
  @ApiModelProperty(value = "Combo")
  public String getComboAbrv() {
    return comboAbrv;
  }

  public void setComboAbrv(String comboAbrv) {
    this.comboAbrv = comboAbrv;
  }

  public ArtworkLibB status(String status) {
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

  public ArtworkLibB artworkLibD(List<ArtworkLibD> artworkLibD) {
    this.artworkLibD = artworkLibD;
    return this;
  }

  public ArtworkLibB addArtworkLibDItem(ArtworkLibD artworkLibDItem) {
    this.artworkLibD.add(artworkLibDItem);
    return this;
  }

   /**
   * Get artworkLibD
   * @return artworkLibD
  **/
  @ApiModelProperty(value = "")
  public List<ArtworkLibD> getArtworkLibD() {
    return artworkLibD;
  }

  public void setArtworkLibD(List<ArtworkLibD> artworkLibD) {
    this.artworkLibD = artworkLibD;
  }

  public ArtworkLibB attachment(Attachment attachment) {
    this.attachment = attachment;
    return this;
  }

   /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")
  public Attachment getAttachment() {
    return attachment;
  }

  public void setAttachment(Attachment attachment) {
    this.attachment = attachment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtworkLibB artworkLibB = (ArtworkLibB) o;
    return Objects.equals(this.comboId, artworkLibB.comboId) &&
        Objects.equals(this.memo1, artworkLibB.memo1) &&
        Objects.equals(this.comboName, artworkLibB.comboName) &&
        Objects.equals(this.comboAbrv, artworkLibB.comboAbrv) &&
        Objects.equals(this.status, artworkLibB.status) &&
        Objects.equals(this.artworkLibD, artworkLibB.artworkLibD) &&
        Objects.equals(this.attachment, artworkLibB.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comboId, memo1, comboName, comboAbrv, status, artworkLibD, attachment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtworkLibB {\n");

    sb.append("    comboId: ").append(toIndentedString(comboId)).append("\n");
    sb.append("    memo1: ").append(toIndentedString(memo1)).append("\n");
    sb.append("    comboName: ").append(toIndentedString(comboName)).append("\n");
    sb.append("    comboAbrv: ").append(toIndentedString(comboAbrv)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    artworkLibD: ").append(toIndentedString(artworkLibD)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
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

