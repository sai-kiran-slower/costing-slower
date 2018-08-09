package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ColorlibH
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class ColorlibH   {
  @JsonProperty("@memo3")
  private String memo3 = null;

  @JsonProperty("@color_name")
  private String colorName = null;

  @JsonProperty("@alt_name1")
  private String altName1 = null;

  @JsonProperty("@memo2")
  private String memo2 = null;

  @JsonProperty("@status")
  private String status = null;

  @JsonProperty("@rgb_r")
  private String rgbR = null;

  @JsonProperty("@rgb_g")
  private String rgbG = null;

  @JsonProperty("@rgb_b")
  private String rgbB = null;

  @JsonProperty("@owner")
  private String owner = null;

  @JsonProperty("@active_ind")
  private String activeInd = null;

  @JsonProperty("attachment")
  private Attachment attachment = null;

  public ColorlibH memo3(String memo3) {
    this.memo3 = memo3;
    return this;
  }

   /**
   * Color No
   * @return memo3
  **/
  @ApiModelProperty(value = "Color No")
  public String getMemo3() {
    return memo3;
  }

  public void setMemo3(String memo3) {
    this.memo3 = memo3;
  }

  public ColorlibH colorName(String colorName) {
    this.colorName = colorName;
    return this;
  }

   /**
   * Color Name
   * @return colorName
  **/
  @ApiModelProperty(value = "Color Name")
  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }

  public ColorlibH altName1(String altName1) {
    this.altName1 = altName1;
    return this;
  }

   /**
   * Alt Color Name
   * @return altName1
  **/
  @ApiModelProperty(value = "Alt Color Name")
  public String getAltName1() {
    return altName1;
  }

  public void setAltName1(String altName1) {
    this.altName1 = altName1;
  }

  public ColorlibH memo2(String memo2) {
    this.memo2 = memo2;
    return this;
  }

   /**
   * CATEGORY
   * @return memo2
  **/
  @ApiModelProperty(value = "CATEGORY")
  public String getMemo2() {
    return memo2;
  }

  public void setMemo2(String memo2) {
    this.memo2 = memo2;
  }

  public ColorlibH status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status
   * @return status
  **/
  @ApiModelProperty(value = "Status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ColorlibH rgbR(String rgbR) {
    this.rgbR = rgbR;
    return this;
  }

   /**
   * RGB_R
   * @return rgbR
  **/
  @ApiModelProperty(value = "RGB_R")
  public String getRgbR() {
    return rgbR;
  }

  public void setRgbR(String rgbR) {
    this.rgbR = rgbR;
  }

  public ColorlibH rgbG(String rgbG) {
    this.rgbG = rgbG;
    return this;
  }

   /**
   * RGB_G
   * @return rgbG
  **/
  @ApiModelProperty(value = "RGB_G")
  public String getRgbG() {
    return rgbG;
  }

  public void setRgbG(String rgbG) {
    this.rgbG = rgbG;
  }

  public ColorlibH rgbB(String rgbB) {
    this.rgbB = rgbB;
    return this;
  }

   /**
   * RGB_B
   * @return rgbB
  **/
  @ApiModelProperty(value = "RGB_B")
  public String getRgbB() {
    return rgbB;
  }

  public void setRgbB(String rgbB) {
    this.rgbB = rgbB;
  }

  public ColorlibH owner(String owner) {
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

  public ColorlibH activeInd(String activeInd) {
    this.activeInd = activeInd;
    return this;
  }

   /**
   * Active
   * @return activeInd
  **/
  @ApiModelProperty(value = "Active")
  public String getActiveInd() {
    return activeInd;
  }

  public void setActiveInd(String activeInd) {
    this.activeInd = activeInd;
  }

  public ColorlibH attachment(Attachment attachment) {
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
    ColorlibH colorlibH = (ColorlibH) o;
    return Objects.equals(this.memo3, colorlibH.memo3) &&
        Objects.equals(this.colorName, colorlibH.colorName) &&
        Objects.equals(this.altName1, colorlibH.altName1) &&
        Objects.equals(this.memo2, colorlibH.memo2) &&
        Objects.equals(this.status, colorlibH.status) &&
        Objects.equals(this.rgbR, colorlibH.rgbR) &&
        Objects.equals(this.rgbG, colorlibH.rgbG) &&
        Objects.equals(this.rgbB, colorlibH.rgbB) &&
        Objects.equals(this.owner, colorlibH.owner) &&
        Objects.equals(this.activeInd, colorlibH.activeInd) &&
        Objects.equals(this.attachment, colorlibH.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memo3, colorName, altName1, memo2, status, rgbR, rgbG, rgbB, owner, activeInd, attachment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorlibH {\n");

    sb.append("    memo3: ").append(toIndentedString(memo3)).append("\n");
    sb.append("    colorName: ").append(toIndentedString(colorName)).append("\n");
    sb.append("    altName1: ").append(toIndentedString(altName1)).append("\n");
    sb.append("    memo2: ").append(toIndentedString(memo2)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    rgbR: ").append(toIndentedString(rgbR)).append("\n");
    sb.append("    rgbG: ").append(toIndentedString(rgbG)).append("\n");
    sb.append("    rgbB: ").append(toIndentedString(rgbB)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    activeInd: ").append(toIndentedString(activeInd)).append("\n");
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

