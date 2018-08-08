package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * If11Quote
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-06T21:58:50.169-07:00")

public class If11Quote   {
  @JsonProperty("@season")
  private String season = null;

  @JsonProperty("@item_no")
  private String itemNo = null;

  @JsonProperty("@Fowner")
  private String fowner = null;

  @JsonProperty("sell_channel")
  private List<If11SellChannel> sellChannel = new ArrayList<If11SellChannel>();

  public If11Quote season(String season) {
    this.season = season;
    return this;
  }

   /**
   * Season
   * @return season
  **/
  @ApiModelProperty(value = "Season")
  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public If11Quote itemNo(String itemNo) {
    this.itemNo = itemNo;
    return this;
  }

   /**
   * Item Number
   * @return itemNo
  **/
  @ApiModelProperty(value = "Item Number")
  public String getItemNo() {
    return itemNo;
  }

  public void setItemNo(String itemNo) {
    this.itemNo = itemNo;
  }

  public If11Quote fowner(String fowner) {
    this.fowner = fowner;
    return this;
  }

   /**
   * owner
   * @return fowner
  **/
  @ApiModelProperty(value = "owner")
  public String getFowner() {
    return fowner;
  }

  public void setFowner(String fowner) {
    this.fowner = fowner;
  }

  public If11Quote sellChannel(List<If11SellChannel> sellChannel) {
    this.sellChannel = sellChannel;
    return this;
  }

  public If11Quote addSellChannelItem(If11SellChannel sellChannelItem) {
    this.sellChannel.add(sellChannelItem);
    return this;
  }

   /**
   * Get sellChannel
   * @return sellChannel
  **/
  @ApiModelProperty(value = "")
  public List<If11SellChannel> getSellChannel() {
    return sellChannel;
  }

  public void setSellChannel(List<If11SellChannel> sellChannel) {
    this.sellChannel = sellChannel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    If11Quote if11Quote = (If11Quote) o;
    return Objects.equals(this.season, if11Quote.season) &&
        Objects.equals(this.itemNo, if11Quote.itemNo) &&
        Objects.equals(this.fowner, if11Quote.fowner) &&
        Objects.equals(this.sellChannel, if11Quote.sellChannel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(season, itemNo, fowner, sellChannel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11Quote {\n");

    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    itemNo: ").append(toIndentedString(itemNo)).append("\n");
    sb.append("    fowner: ").append(toIndentedString(fowner)).append("\n");
    sb.append("    sellChannel: ").append(toIndentedString(sellChannel)).append("\n");
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

