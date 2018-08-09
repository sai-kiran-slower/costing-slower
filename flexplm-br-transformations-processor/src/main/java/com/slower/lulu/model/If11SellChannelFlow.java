package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * If11SellChannelFlow
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class If11SellChannelFlow   {
  @JsonProperty("@plan_id")
  private String planId = null;

  @JsonProperty("@plan_qty")
  private String planQty = null;

  @JsonProperty("sell_channel_d")
  private If11SellChannelD sellChannelD = null;

  @JsonProperty("sell_channel_defn")
  private List<If11SellChannelDefinition> sellChannelDefn = new ArrayList<If11SellChannelDefinition>();

  public If11SellChannelFlow planId(String planId) {
    this.planId = planId;
    return this;
  }

   /**
   * Plan ID
   * @return planId
  **/
  @ApiModelProperty(value = "Plan ID")
  public String getPlanId() {
    return planId;
  }

  public void setPlanId(String planId) {
    this.planId = planId;
  }

  public If11SellChannelFlow planQty(String planQty) {
    this.planQty = planQty;
    return this;
  }

   /**
   * Plan Quantity
   * @return planQty
  **/
  @ApiModelProperty(value = "Plan Quantity")
  public String getPlanQty() {
    return planQty;
  }

  public void setPlanQty(String planQty) {
    this.planQty = planQty;
  }

  public If11SellChannelFlow sellChannelD(If11SellChannelD sellChannelD) {
    this.sellChannelD = sellChannelD;
    return this;
  }

   /**
   * Get sellChannelD
   * @return sellChannelD
  **/
  @ApiModelProperty(value = "")
  public If11SellChannelD getSellChannelD() {
    return sellChannelD;
  }

  public void setSellChannelD(If11SellChannelD sellChannelD) {
    this.sellChannelD = sellChannelD;
  }

  public If11SellChannelFlow sellChannelDefn(List<If11SellChannelDefinition> sellChannelDefn) {
    this.sellChannelDefn = sellChannelDefn;
    return this;
  }

  public If11SellChannelFlow addSellChannelDefnItem(If11SellChannelDefinition sellChannelDefnItem) {
    this.sellChannelDefn.add(sellChannelDefnItem);
    return this;
  }

   /**
   * Get sellChannelDefn
   * @return sellChannelDefn
  **/
  @ApiModelProperty(value = "")
  public List<If11SellChannelDefinition> getSellChannelDefn() {
    return sellChannelDefn;
  }

  public void setSellChannelDefn(List<If11SellChannelDefinition> sellChannelDefn) {
    this.sellChannelDefn = sellChannelDefn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    If11SellChannelFlow if11SellChannelFlow = (If11SellChannelFlow) o;
    return Objects.equals(this.planId, if11SellChannelFlow.planId) &&
        Objects.equals(this.planQty, if11SellChannelFlow.planQty) &&
        Objects.equals(this.sellChannelD, if11SellChannelFlow.sellChannelD) &&
        Objects.equals(this.sellChannelDefn, if11SellChannelFlow.sellChannelDefn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planId, planQty, sellChannelD, sellChannelDefn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11SellChannelFlow {\n");

    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    planQty: ").append(toIndentedString(planQty)).append("\n");
    sb.append("    sellChannelD: ").append(toIndentedString(sellChannelD)).append("\n");
    sb.append("    sellChannelDefn: ").append(toIndentedString(sellChannelDefn)).append("\n");
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

