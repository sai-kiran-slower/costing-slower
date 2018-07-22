package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * QuoteMapping
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-09T23:33:02.571-07:00")

public class QuoteMapping {
  @JsonProperty("seasonal_type")
  private List<FlexBrMapping> seasonalType = new ArrayList<FlexBrMapping>();

  @JsonProperty("season_style_level_status")
  private List<FlexBrMapping> seasonStyleLevelStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("season_style_option_level_status")
  private List<FlexBrMapping> seasonStyleOptionLevelStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("category")
  private List<FlexBrMapping> category = new ArrayList<FlexBrMapping>();

  @JsonProperty("design_line")
  private List<FlexBrMapping> designLine = new ArrayList<FlexBrMapping>();

  @JsonProperty("calendar_track")
  private List<FlexBrMapping> calendarTrack = new ArrayList<FlexBrMapping>();

  @JsonProperty("proto_sample_status")
  private List<FlexBrMapping> protoSampleStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("size_run_sample_status")
  private List<FlexBrMapping> sizeRunSampleStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("design_pod")
  private List<FlexBrMapping> designPod = new ArrayList<FlexBrMapping>();

  public QuoteMapping seasonalType(List<FlexBrMapping> seasonalType) {
    this.seasonalType = seasonalType;
    return this;
  }

  public QuoteMapping addSeasonalTypeItem(FlexBrMapping seasonalTypeItem) {
    this.seasonalType.add(seasonalTypeItem);
    return this;
  }

   /**
   * Get seasonalType
   * @return seasonalType
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getSeasonalType() {
    return seasonalType;
  }

  public void setSeasonalType(List<FlexBrMapping> seasonalType) {
    this.seasonalType = seasonalType;
  }

  public QuoteMapping seasonStyleLevelStatus(List<FlexBrMapping> seasonStyleLevelStatus) {
    this.seasonStyleLevelStatus = seasonStyleLevelStatus;
    return this;
  }

  public QuoteMapping addSeasonStyleLevelStatusItem(FlexBrMapping seasonStyleLevelStatusItem) {
    this.seasonStyleLevelStatus.add(seasonStyleLevelStatusItem);
    return this;
  }

   /**
   * Get seasonStyleLevelStatus
   * @return seasonStyleLevelStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getSeasonStyleLevelStatus() {
    return seasonStyleLevelStatus;
  }

  public void setSeasonStyleLevelStatus(List<FlexBrMapping> seasonStyleLevelStatus) {
    this.seasonStyleLevelStatus = seasonStyleLevelStatus;
  }

  public QuoteMapping seasonStyleOptionLevelStatus(List<FlexBrMapping> seasonStyleOptionLevelStatus) {
    this.seasonStyleOptionLevelStatus = seasonStyleOptionLevelStatus;
    return this;
  }

  public QuoteMapping addSeasonStyleOptionLevelStatusItem(FlexBrMapping seasonStyleOptionLevelStatusItem) {
    this.seasonStyleOptionLevelStatus.add(seasonStyleOptionLevelStatusItem);
    return this;
  }

   /**
   * Get seasonStyleOptionLevelStatus
   * @return seasonStyleOptionLevelStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getSeasonStyleOptionLevelStatus() {
    return seasonStyleOptionLevelStatus;
  }

  public void setSeasonStyleOptionLevelStatus(List<FlexBrMapping> seasonStyleOptionLevelStatus) {
    this.seasonStyleOptionLevelStatus = seasonStyleOptionLevelStatus;
  }

  public QuoteMapping category(List<FlexBrMapping> category) {
    this.category = category;
    return this;
  }

  public QuoteMapping addCategoryItem(FlexBrMapping categoryItem) {
    this.category.add(categoryItem);
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getCategory() {
    return category;
  }

  public void setCategory(List<FlexBrMapping> category) {
    this.category = category;
  }

  public QuoteMapping designLine(List<FlexBrMapping> designLine) {
    this.designLine = designLine;
    return this;
  }

  public QuoteMapping addDesignLineItem(FlexBrMapping designLineItem) {
    this.designLine.add(designLineItem);
    return this;
  }

   /**
   * Get designLine
   * @return designLine
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getDesignLine() {
    return designLine;
  }

  public void setDesignLine(List<FlexBrMapping> designLine) {
    this.designLine = designLine;
  }

  public QuoteMapping calendarTrack(List<FlexBrMapping> calendarTrack) {
    this.calendarTrack = calendarTrack;
    return this;
  }

  public QuoteMapping addCalendarTrackItem(FlexBrMapping calendarTrackItem) {
    this.calendarTrack.add(calendarTrackItem);
    return this;
  }

   /**
   * Get calendarTrack
   * @return calendarTrack
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getCalendarTrack() {
    return calendarTrack;
  }

  public void setCalendarTrack(List<FlexBrMapping> calendarTrack) {
    this.calendarTrack = calendarTrack;
  }

  public QuoteMapping protoSampleStatus(List<FlexBrMapping> protoSampleStatus) {
    this.protoSampleStatus = protoSampleStatus;
    return this;
  }

  public QuoteMapping addProtoSampleStatusItem(FlexBrMapping protoSampleStatusItem) {
    this.protoSampleStatus.add(protoSampleStatusItem);
    return this;
  }

   /**
   * Get protoSampleStatus
   * @return protoSampleStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getProtoSampleStatus() {
    return protoSampleStatus;
  }

  public void setProtoSampleStatus(List<FlexBrMapping> protoSampleStatus) {
    this.protoSampleStatus = protoSampleStatus;
  }

  public QuoteMapping sizeRunSampleStatus(List<FlexBrMapping> sizeRunSampleStatus) {
    this.sizeRunSampleStatus = sizeRunSampleStatus;
    return this;
  }

  public QuoteMapping addSizeRunSampleStatusItem(FlexBrMapping sizeRunSampleStatusItem) {
    this.sizeRunSampleStatus.add(sizeRunSampleStatusItem);
    return this;
  }

   /**
   * Get sizeRunSampleStatus
   * @return sizeRunSampleStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getSizeRunSampleStatus() {
    return sizeRunSampleStatus;
  }

  public void setSizeRunSampleStatus(List<FlexBrMapping> sizeRunSampleStatus) {
    this.sizeRunSampleStatus = sizeRunSampleStatus;
  }

  public QuoteMapping designPod(List<FlexBrMapping> designPod) {
    this.designPod = designPod;
    return this;
  }

  public QuoteMapping addDesignPodItem(FlexBrMapping designPodItem) {
    this.designPod.add(designPodItem);
    return this;
  }

   /**
   * Get designPod
   * @return designPod
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getDesignPod() {
    return designPod;
  }

  public void setDesignPod(List<FlexBrMapping> designPod) {
    this.designPod = designPod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuoteMapping quoteMapping = (QuoteMapping) o;
    return Objects.equals(this.seasonalType, quoteMapping.seasonalType) &&
        Objects.equals(this.seasonStyleLevelStatus, quoteMapping.seasonStyleLevelStatus) &&
        Objects.equals(this.seasonStyleOptionLevelStatus, quoteMapping.seasonStyleOptionLevelStatus) &&
        Objects.equals(this.category, quoteMapping.category) &&
        Objects.equals(this.designLine, quoteMapping.designLine) &&
        Objects.equals(this.calendarTrack, quoteMapping.calendarTrack) &&
        Objects.equals(this.protoSampleStatus, quoteMapping.protoSampleStatus) &&
        Objects.equals(this.sizeRunSampleStatus, quoteMapping.sizeRunSampleStatus) &&
        Objects.equals(this.designPod, quoteMapping.designPod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seasonalType, seasonStyleLevelStatus, seasonStyleOptionLevelStatus, category, designLine, calendarTrack, protoSampleStatus, sizeRunSampleStatus, designPod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteMapping {\n");

    sb.append("    seasonalType: ").append(toIndentedString(seasonalType)).append("\n");
    sb.append("    seasonStyleLevelStatus: ").append(toIndentedString(seasonStyleLevelStatus)).append("\n");
    sb.append("    seasonStyleOptionLevelStatus: ").append(toIndentedString(seasonStyleOptionLevelStatus)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    designLine: ").append(toIndentedString(designLine)).append("\n");
    sb.append("    calendarTrack: ").append(toIndentedString(calendarTrack)).append("\n");
    sb.append("    protoSampleStatus: ").append(toIndentedString(protoSampleStatus)).append("\n");
    sb.append("    sizeRunSampleStatus: ").append(toIndentedString(sizeRunSampleStatus)).append("\n");
    sb.append("    designPod: ").append(toIndentedString(designPod)).append("\n");
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

