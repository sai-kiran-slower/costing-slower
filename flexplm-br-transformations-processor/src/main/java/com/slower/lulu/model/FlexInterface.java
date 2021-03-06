package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * FlexInterface
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class FlexInterface   {
  @JsonProperty("FlexPLM_Header")
  private FlexplmHeader flexPLMHeader = null;

  public FlexInterface flexPLMHeader(FlexplmHeader flexPLMHeader) {
    this.flexPLMHeader = flexPLMHeader;
    return this;
  }

   /**
   * Get flexPLMHeader
   * @return flexPLMHeader
  **/
  @ApiModelProperty(value = "")
  public FlexplmHeader getFlexPLMHeader() {
    return flexPLMHeader;
  }

  public void setFlexPLMHeader(FlexplmHeader flexPLMHeader) {
    this.flexPLMHeader = flexPLMHeader;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlexInterface flexInterface = (FlexInterface) o;
    return Objects.equals(this.flexPLMHeader, flexInterface.flexPLMHeader);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flexPLMHeader);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlexInterface {\n");

    sb.append("    flexPLMHeader: ").append(toIndentedString(flexPLMHeader)).append("\n");
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

