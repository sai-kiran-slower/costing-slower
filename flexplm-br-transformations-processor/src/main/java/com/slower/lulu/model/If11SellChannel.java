package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * If11SellChannel
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class If11SellChannel   {
  @JsonProperty("@selling_channel")
  private String sellingChannel = null;

  @JsonProperty("@plan_total")
  private String planTotal = null;

  @JsonProperty("sell_channel_flow")
  private If11SellChannelFlow sellChannelFlow = null;

  public If11SellChannel sellingChannel(String sellingChannel) {
    this.sellingChannel = sellingChannel;
    return this;
  }

   /**
   * Selling Channel
   * @return sellingChannel
  **/
  @ApiModelProperty(value = "Selling Channel")
  public String getSellingChannel() {
    return sellingChannel;
  }

  public void setSellingChannel(String sellingChannel) {
    this.sellingChannel = sellingChannel;
  }

  public If11SellChannel planTotal(String planTotal) {
    this.planTotal = planTotal;
    return this;
  }

   /**
   * Plan Total
   * @return planTotal
  **/
  @ApiModelProperty(value = "Plan Total")
  public String getPlanTotal() {
    return planTotal;
  }

  public void setPlanTotal(String planTotal) {
    this.planTotal = planTotal;
  }

  public If11SellChannel sellChannelFlow(If11SellChannelFlow sellChannelFlow) {
    this.sellChannelFlow = sellChannelFlow;
    return this;
  }

   /**
   * Get sellChannelFlow
   * @return sellChannelFlow
  **/
  @ApiModelProperty(value = "")
  public If11SellChannelFlow getSellChannelFlow() {
    return sellChannelFlow;
  }

  public void setSellChannelFlow(If11SellChannelFlow sellChannelFlow) {
    this.sellChannelFlow = sellChannelFlow;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    If11SellChannel if11SellChannel = (If11SellChannel) o;
    return Objects.equals(this.sellingChannel, if11SellChannel.sellingChannel) &&
        Objects.equals(this.planTotal, if11SellChannel.planTotal) &&
        Objects.equals(this.sellChannelFlow, if11SellChannel.sellChannelFlow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sellingChannel, planTotal, sellChannelFlow);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11SellChannel {\n");

    sb.append("    sellingChannel: ").append(toIndentedString(sellingChannel)).append("\n");
    sb.append("    planTotal: ").append(toIndentedString(planTotal)).append("\n");
    sb.append("    sellChannelFlow: ").append(toIndentedString(sellChannelFlow)).append("\n");
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

