package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Attachment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class Attachment   {
  @JsonProperty("@location")
  private String location = null;

  @JsonProperty("@attachment_no")
  private String attachmentNo = null;

  @JsonProperty("@custom_location")
  private String customLocation = null;

  @JsonProperty("@icon_location")
  private String iconLocation = null;

  @JsonProperty("@largeview_location")
  private String largeviewLocation = null;

  @JsonProperty("@overview_location")
  private String overviewLocation = null;

  @JsonProperty("@thumbnail_location")
  private String thumbnailLocation = null;

  public Attachment location(String location) {
    this.location = location;
    return this;
  }

   /**
   * location
   * @return location
  **/
  @ApiModelProperty(value = "location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Attachment attachmentNo(String attachmentNo) {
    this.attachmentNo = attachmentNo;
    return this;
  }

   /**
   * attachment number
   * @return attachmentNo
  **/
  @ApiModelProperty(value = "attachment number")
  public String getAttachmentNo() {
    return attachmentNo;
  }

  public void setAttachmentNo(String attachmentNo) {
    this.attachmentNo = attachmentNo;
  }

  public Attachment customLocation(String customLocation) {
    this.customLocation = customLocation;
    return this;
  }

   /**
   * custom location
   * @return customLocation
  **/
  @ApiModelProperty(value = "custom location")
  public String getCustomLocation() {
    return customLocation;
  }

  public void setCustomLocation(String customLocation) {
    this.customLocation = customLocation;
  }

  public Attachment iconLocation(String iconLocation) {
    this.iconLocation = iconLocation;
    return this;
  }

   /**
   * icon location
   * @return iconLocation
  **/
  @ApiModelProperty(value = "icon location")
  public String getIconLocation() {
    return iconLocation;
  }

  public void setIconLocation(String iconLocation) {
    this.iconLocation = iconLocation;
  }

  public Attachment largeviewLocation(String largeviewLocation) {
    this.largeviewLocation = largeviewLocation;
    return this;
  }

   /**
   * largeview location
   * @return largeviewLocation
  **/
  @ApiModelProperty(value = "largeview location")
  public String getLargeviewLocation() {
    return largeviewLocation;
  }

  public void setLargeviewLocation(String largeviewLocation) {
    this.largeviewLocation = largeviewLocation;
  }

  public Attachment overviewLocation(String overviewLocation) {
    this.overviewLocation = overviewLocation;
    return this;
  }

   /**
   * overview location
   * @return overviewLocation
  **/
  @ApiModelProperty(value = "overview location")
  public String getOverviewLocation() {
    return overviewLocation;
  }

  public void setOverviewLocation(String overviewLocation) {
    this.overviewLocation = overviewLocation;
  }

  public Attachment thumbnailLocation(String thumbnailLocation) {
    this.thumbnailLocation = thumbnailLocation;
    return this;
  }

   /**
   * thumbnail location
   * @return thumbnailLocation
  **/
  @ApiModelProperty(value = "thumbnail location")
  public String getThumbnailLocation() {
    return thumbnailLocation;
  }

  public void setThumbnailLocation(String thumbnailLocation) {
    this.thumbnailLocation = thumbnailLocation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.location, attachment.location) &&
        Objects.equals(this.attachmentNo, attachment.attachmentNo) &&
        Objects.equals(this.customLocation, attachment.customLocation) &&
        Objects.equals(this.iconLocation, attachment.iconLocation) &&
        Objects.equals(this.largeviewLocation, attachment.largeviewLocation) &&
        Objects.equals(this.overviewLocation, attachment.overviewLocation) &&
        Objects.equals(this.thumbnailLocation, attachment.thumbnailLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, attachmentNo, customLocation, iconLocation, largeviewLocation, overviewLocation, thumbnailLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");

    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    attachmentNo: ").append(toIndentedString(attachmentNo)).append("\n");
    sb.append("    customLocation: ").append(toIndentedString(customLocation)).append("\n");
    sb.append("    iconLocation: ").append(toIndentedString(iconLocation)).append("\n");
    sb.append("    largeviewLocation: ").append(toIndentedString(largeviewLocation)).append("\n");
    sb.append("    overviewLocation: ").append(toIndentedString(overviewLocation)).append("\n");
    sb.append("    thumbnailLocation: ").append(toIndentedString(thumbnailLocation)).append("\n");
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

