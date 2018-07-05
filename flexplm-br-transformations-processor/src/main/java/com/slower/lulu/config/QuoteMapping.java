package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * QuoteMapping
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-05T02:02:28.246-07:00")

public class QuoteMapping   {
  @JsonProperty("seasonal_type")
  private List<FlexBrMapping> seasonalType = new ArrayList<FlexBrMapping>();

  @JsonProperty("season_style_level_status")
  private List<FlexBrMapping> seasonStyleLevelStatus = new ArrayList<FlexBrMapping>();

  @JsonProperty("season_style_option_level_status")
  private List<FlexBrMapping> seasonStyleOptionLevelStatus = new ArrayList<FlexBrMapping>();

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
        Objects.equals(this.seasonStyleOptionLevelStatus, quoteMapping.seasonStyleOptionLevelStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(seasonalType, seasonStyleLevelStatus, seasonStyleOptionLevelStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteMapping {\n");

    sb.append("    seasonalType: ").append(toIndentedString(seasonalType)).append("\n");
    sb.append("    seasonStyleLevelStatus: ").append(toIndentedString(seasonStyleLevelStatus)).append("\n");
    sb.append("    seasonStyleOptionLevelStatus: ").append(toIndentedString(seasonStyleOptionLevelStatus)).append("\n");
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

