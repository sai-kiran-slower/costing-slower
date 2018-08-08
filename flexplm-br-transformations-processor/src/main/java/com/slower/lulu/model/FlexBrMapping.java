package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * FlexBrMapping
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-06T21:58:50.169-07:00")

public class FlexBrMapping   {
  @JsonProperty("flex_code")
  private String flexCode = null;

  @JsonProperty("br_code")
  private String brCode = null;

  public FlexBrMapping flexCode(String flexCode) {
    this.flexCode = flexCode;
    return this;
  }

   /**
   * FlexPLM code
   * @return flexCode
  **/
  @ApiModelProperty(value = "FlexPLM code")
  public String getFlexCode() {
    return flexCode;
  }

  public void setFlexCode(String flexCode) {
    this.flexCode = flexCode;
  }

  public FlexBrMapping brCode(String brCode) {
    this.brCode = brCode;
    return this;
  }

   /**
   * Bamboo Rose code
   * @return brCode
  **/
  @ApiModelProperty(value = "Bamboo Rose code")
  public String getBrCode() {
    return brCode;
  }

  public void setBrCode(String brCode) {
    this.brCode = brCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlexBrMapping flexBrMapping = (FlexBrMapping) o;
    return Objects.equals(this.flexCode, flexBrMapping.flexCode) &&
        Objects.equals(this.brCode, flexBrMapping.brCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flexCode, brCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlexBrMapping {\n");

    sb.append("    flexCode: ").append(toIndentedString(flexCode)).append("\n");
    sb.append("    brCode: ").append(toIndentedString(brCode)).append("\n");
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

