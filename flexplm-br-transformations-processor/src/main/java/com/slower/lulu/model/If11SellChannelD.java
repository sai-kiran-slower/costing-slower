package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * If11SellChannelD
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class If11SellChannelD   {
  @JsonProperty("@alloc_by_1")
  private String allocBy1 = null;

  @JsonProperty("@alloc_by_2")
  private String allocBy2 = null;

  @JsonProperty("@alloc_by_3")
  private String allocBy3 = null;

  public If11SellChannelD allocBy1(String allocBy1) {
    this.allocBy1 = allocBy1;
    return this;
  }

   /**
   * STORE
   * @return allocBy1
  **/
  @ApiModelProperty(value = "STORE")
  public String getAllocBy1() {
    return allocBy1;
  }

  public void setAllocBy1(String allocBy1) {
    this.allocBy1 = allocBy1;
  }

  public If11SellChannelD allocBy2(String allocBy2) {
    this.allocBy2 = allocBy2;
    return this;
  }

   /**
   * Plan ID
   * @return allocBy2
  **/
  @ApiModelProperty(value = "Plan ID")
  public String getAllocBy2() {
    return allocBy2;
  }

  public void setAllocBy2(String allocBy2) {
    this.allocBy2 = allocBy2;
  }

  public If11SellChannelD allocBy3(String allocBy3) {
    this.allocBy3 = allocBy3;
    return this;
  }

   /**
   * STYC
   * @return allocBy3
  **/
  @ApiModelProperty(value = "STYC")
  public String getAllocBy3() {
    return allocBy3;
  }

  public void setAllocBy3(String allocBy3) {
    this.allocBy3 = allocBy3;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    If11SellChannelD if11SellChannelD = (If11SellChannelD) o;
    return Objects.equals(this.allocBy1, if11SellChannelD.allocBy1) &&
        Objects.equals(this.allocBy2, if11SellChannelD.allocBy2) &&
        Objects.equals(this.allocBy3, if11SellChannelD.allocBy3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allocBy1, allocBy2, allocBy3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11SellChannelD {\n");

    sb.append("    allocBy1: ").append(toIndentedString(allocBy1)).append("\n");
    sb.append("    allocBy2: ").append(toIndentedString(allocBy2)).append("\n");
    sb.append("    allocBy3: ").append(toIndentedString(allocBy3)).append("\n");
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

