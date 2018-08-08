package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * MappingRule
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-06T21:58:50.169-07:00")

public class MappingRule   {
  @JsonProperty("active_ind")
  private List<FlexBrMapping> activeInd = new ArrayList<FlexBrMapping>();

  @JsonProperty("color_status")
  private List<FlexBrMapping> colorStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("color_category")
  private List<FlexBrMapping> colorCategory = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_seasonal_type")
  private List<FlexBrMapping> quoteSeasonalType = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_season_style_level_status")
  private List<FlexBrMapping> quoteSeasonStyleLevelStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_season_style_option_level_status")
  private List<FlexBrMapping> quoteSeasonStyleOptionLevelStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_category")
  private List<FlexBrMapping> quoteCategory = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_design_line")
  private List<FlexBrMapping> quoteDesignLine = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_calendar_track")
  private List<FlexBrMapping> quoteCalendarTrack = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_proto_sample_status")
  private List<FlexBrMapping> quoteProtoSampleStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_size_run_sample_status")
  private List<FlexBrMapping> quoteSizeRunSampleStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("quote_design_pod")
  private List<FlexBrMapping> quoteDesignPod = new ArrayList<FlexBrMapping>();

  public MappingRule activeInd(List<FlexBrMapping> activeInd) {
    this.activeInd = activeInd;
    return this;
  }

  public MappingRule addActiveIndItem(FlexBrMapping activeIndItem) {
    this.activeInd.add(activeIndItem);
    return this;
  }

   /**
   * Get activeInd
   * @return activeInd
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getActiveInd() {
    return activeInd;
  }

  public void setActiveInd(List<FlexBrMapping> activeInd) {
    this.activeInd = activeInd;
  }

  public MappingRule colorStatus(List<FlexBrMapping> colorStatus) {
    this.colorStatus = colorStatus;
    return this;
  }

  public MappingRule addColorStatusItem(FlexBrMapping colorStatusItem) {
    this.colorStatus.add(colorStatusItem);
    return this;
  }

   /**
   * Get colorStatus
   * @return colorStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getColorStatus() {
    return colorStatus;
  }

  public void setColorStatus(List<FlexBrMapping> colorStatus) {
    this.colorStatus = colorStatus;
  }

  public MappingRule colorCategory(List<FlexBrMapping> colorCategory) {
    this.colorCategory = colorCategory;
    return this;
  }

  public MappingRule addColorCategoryItem(FlexBrMapping colorCategoryItem) {
    this.colorCategory.add(colorCategoryItem);
    return this;
  }

   /**
   * Get colorCategory
   * @return colorCategory
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getColorCategory() {
    return colorCategory;
  }

  public void setColorCategory(List<FlexBrMapping> colorCategory) {
    this.colorCategory = colorCategory;
  }

  public MappingRule quoteSeasonalType(List<FlexBrMapping> quoteSeasonalType) {
    this.quoteSeasonalType = quoteSeasonalType;
    return this;
  }

  public MappingRule addQuoteSeasonalTypeItem(FlexBrMapping quoteSeasonalTypeItem) {
    this.quoteSeasonalType.add(quoteSeasonalTypeItem);
    return this;
  }

   /**
   * Get quoteSeasonalType
   * @return quoteSeasonalType
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteSeasonalType() {
    return quoteSeasonalType;
  }

  public void setQuoteSeasonalType(List<FlexBrMapping> quoteSeasonalType) {
    this.quoteSeasonalType = quoteSeasonalType;
  }

  public MappingRule quoteSeasonStyleLevelStatus(List<FlexBrMapping> quoteSeasonStyleLevelStatus) {
    this.quoteSeasonStyleLevelStatus = quoteSeasonStyleLevelStatus;
    return this;
  }

  public MappingRule addQuoteSeasonStyleLevelStatusItem(FlexBrMapping quoteSeasonStyleLevelStatusItem) {
    this.quoteSeasonStyleLevelStatus.add(quoteSeasonStyleLevelStatusItem);
    return this;
  }

   /**
   * Get quoteSeasonStyleLevelStatus
   * @return quoteSeasonStyleLevelStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteSeasonStyleLevelStatus() {
    return quoteSeasonStyleLevelStatus;
  }

  public void setQuoteSeasonStyleLevelStatus(List<FlexBrMapping> quoteSeasonStyleLevelStatus) {
    this.quoteSeasonStyleLevelStatus = quoteSeasonStyleLevelStatus;
  }

  public MappingRule quoteSeasonStyleOptionLevelStatus(List<FlexBrMapping> quoteSeasonStyleOptionLevelStatus) {
    this.quoteSeasonStyleOptionLevelStatus = quoteSeasonStyleOptionLevelStatus;
    return this;
  }

  public MappingRule addQuoteSeasonStyleOptionLevelStatusItem(FlexBrMapping quoteSeasonStyleOptionLevelStatusItem) {
    this.quoteSeasonStyleOptionLevelStatus.add(quoteSeasonStyleOptionLevelStatusItem);
    return this;
  }

   /**
   * Get quoteSeasonStyleOptionLevelStatus
   * @return quoteSeasonStyleOptionLevelStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteSeasonStyleOptionLevelStatus() {
    return quoteSeasonStyleOptionLevelStatus;
  }

  public void setQuoteSeasonStyleOptionLevelStatus(List<FlexBrMapping> quoteSeasonStyleOptionLevelStatus) {
    this.quoteSeasonStyleOptionLevelStatus = quoteSeasonStyleOptionLevelStatus;
  }

  public MappingRule quoteCategory(List<FlexBrMapping> quoteCategory) {
    this.quoteCategory = quoteCategory;
    return this;
  }

  public MappingRule addQuoteCategoryItem(FlexBrMapping quoteCategoryItem) {
    this.quoteCategory.add(quoteCategoryItem);
    return this;
  }

   /**
   * Get quoteCategory
   * @return quoteCategory
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteCategory() {
    return quoteCategory;
  }

  public void setQuoteCategory(List<FlexBrMapping> quoteCategory) {
    this.quoteCategory = quoteCategory;
  }

  public MappingRule quoteDesignLine(List<FlexBrMapping> quoteDesignLine) {
    this.quoteDesignLine = quoteDesignLine;
    return this;
  }

  public MappingRule addQuoteDesignLineItem(FlexBrMapping quoteDesignLineItem) {
    this.quoteDesignLine.add(quoteDesignLineItem);
    return this;
  }

   /**
   * Get quoteDesignLine
   * @return quoteDesignLine
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteDesignLine() {
    return quoteDesignLine;
  }

  public void setQuoteDesignLine(List<FlexBrMapping> quoteDesignLine) {
    this.quoteDesignLine = quoteDesignLine;
  }

  public MappingRule quoteCalendarTrack(List<FlexBrMapping> quoteCalendarTrack) {
    this.quoteCalendarTrack = quoteCalendarTrack;
    return this;
  }

  public MappingRule addQuoteCalendarTrackItem(FlexBrMapping quoteCalendarTrackItem) {
    this.quoteCalendarTrack.add(quoteCalendarTrackItem);
    return this;
  }

   /**
   * Get quoteCalendarTrack
   * @return quoteCalendarTrack
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteCalendarTrack() {
    return quoteCalendarTrack;
  }

  public void setQuoteCalendarTrack(List<FlexBrMapping> quoteCalendarTrack) {
    this.quoteCalendarTrack = quoteCalendarTrack;
  }

  public MappingRule quoteProtoSampleStatus(List<FlexBrMapping> quoteProtoSampleStatus) {
    this.quoteProtoSampleStatus = quoteProtoSampleStatus;
    return this;
  }

  public MappingRule addQuoteProtoSampleStatusItem(FlexBrMapping quoteProtoSampleStatusItem) {
    this.quoteProtoSampleStatus.add(quoteProtoSampleStatusItem);
    return this;
  }

   /**
   * Get quoteProtoSampleStatus
   * @return quoteProtoSampleStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteProtoSampleStatus() {
    return quoteProtoSampleStatus;
  }

  public void setQuoteProtoSampleStatus(List<FlexBrMapping> quoteProtoSampleStatus) {
    this.quoteProtoSampleStatus = quoteProtoSampleStatus;
  }

  public MappingRule quoteSizeRunSampleStatus(List<FlexBrMapping> quoteSizeRunSampleStatus) {
    this.quoteSizeRunSampleStatus = quoteSizeRunSampleStatus;
    return this;
  }

  public MappingRule addQuoteSizeRunSampleStatusItem(FlexBrMapping quoteSizeRunSampleStatusItem) {
    this.quoteSizeRunSampleStatus.add(quoteSizeRunSampleStatusItem);
    return this;
  }

   /**
   * Get quoteSizeRunSampleStatus
   * @return quoteSizeRunSampleStatus
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteSizeRunSampleStatus() {
    return quoteSizeRunSampleStatus;
  }

  public void setQuoteSizeRunSampleStatus(List<FlexBrMapping> quoteSizeRunSampleStatus) {
    this.quoteSizeRunSampleStatus = quoteSizeRunSampleStatus;
  }

  public MappingRule quoteDesignPod(List<FlexBrMapping> quoteDesignPod) {
    this.quoteDesignPod = quoteDesignPod;
    return this;
  }

  public MappingRule addQuoteDesignPodItem(FlexBrMapping quoteDesignPodItem) {
    this.quoteDesignPod.add(quoteDesignPodItem);
    return this;
  }

   /**
   * Get quoteDesignPod
   * @return quoteDesignPod
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getQuoteDesignPod() {
    return quoteDesignPod;
  }

  public void setQuoteDesignPod(List<FlexBrMapping> quoteDesignPod) {
    this.quoteDesignPod = quoteDesignPod;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MappingRule mappingRule = (MappingRule) o;
    return Objects.equals(this.activeInd, mappingRule.activeInd) &&
        Objects.equals(this.colorStatus, mappingRule.colorStatus) &&
        Objects.equals(this.colorCategory, mappingRule.colorCategory) &&
        Objects.equals(this.quoteSeasonalType, mappingRule.quoteSeasonalType) &&
        Objects.equals(this.quoteSeasonStyleLevelStatus, mappingRule.quoteSeasonStyleLevelStatus) &&
        Objects.equals(this.quoteSeasonStyleOptionLevelStatus, mappingRule.quoteSeasonStyleOptionLevelStatus) &&
        Objects.equals(this.quoteCategory, mappingRule.quoteCategory) &&
        Objects.equals(this.quoteDesignLine, mappingRule.quoteDesignLine) &&
        Objects.equals(this.quoteCalendarTrack, mappingRule.quoteCalendarTrack) &&
        Objects.equals(this.quoteProtoSampleStatus, mappingRule.quoteProtoSampleStatus) &&
        Objects.equals(this.quoteSizeRunSampleStatus, mappingRule.quoteSizeRunSampleStatus) &&
        Objects.equals(this.quoteDesignPod, mappingRule.quoteDesignPod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeInd, colorStatus, colorCategory, quoteSeasonalType, quoteSeasonStyleLevelStatus, quoteSeasonStyleOptionLevelStatus, quoteCategory, quoteDesignLine, quoteCalendarTrack, quoteProtoSampleStatus, quoteSizeRunSampleStatus, quoteDesignPod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MappingRule {\n");

    sb.append("    activeInd: ").append(toIndentedString(activeInd)).append("\n");
    sb.append("    colorStatus: ").append(toIndentedString(colorStatus)).append("\n");
    sb.append("    colorCategory: ").append(toIndentedString(colorCategory)).append("\n");
    sb.append("    quoteSeasonalType: ").append(toIndentedString(quoteSeasonalType)).append("\n");
    sb.append("    quoteSeasonStyleLevelStatus: ").append(toIndentedString(quoteSeasonStyleLevelStatus)).append("\n");
    sb.append("    quoteSeasonStyleOptionLevelStatus: ").append(toIndentedString(quoteSeasonStyleOptionLevelStatus)).append("\n");
    sb.append("    quoteCategory: ").append(toIndentedString(quoteCategory)).append("\n");
    sb.append("    quoteDesignLine: ").append(toIndentedString(quoteDesignLine)).append("\n");
    sb.append("    quoteCalendarTrack: ").append(toIndentedString(quoteCalendarTrack)).append("\n");
    sb.append("    quoteProtoSampleStatus: ").append(toIndentedString(quoteProtoSampleStatus)).append("\n");
    sb.append("    quoteSizeRunSampleStatus: ").append(toIndentedString(quoteSizeRunSampleStatus)).append("\n");
    sb.append("    quoteDesignPod: ").append(toIndentedString(quoteDesignPod)).append("\n");
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

