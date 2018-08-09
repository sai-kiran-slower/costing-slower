package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * If11SellChannelDefinition
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class If11SellChannelDefinition   {
  @JsonProperty("@attrib_value")
  private String attribValue = null;

  @JsonProperty("@attrib_name")
  private String attribName = null;

  public If11SellChannelDefinition attribValue(String attribValue) {
    this.attribValue = attribValue;
    return this;
  }

   /**
   * Attribute Value
   * @return attribValue
  **/
  @ApiModelProperty(value = "Attribute Value")
  public String getAttribValue() {
    return attribValue;
  }

  public void setAttribValue(String attribValue) {
    this.attribValue = attribValue;
  }

  public If11SellChannelDefinition attribName(String attribName) {
    this.attribName = attribName;
    return this;
  }

   /**
   * Attribute Name
   * @return attribName
  **/
  @ApiModelProperty(value = "Attribute Name")
  public String getAttribName() {
    return attribName;
  }

  public void setAttribName(String attribName) {
    this.attribName = attribName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    If11SellChannelDefinition if11SellChannelDefinition = (If11SellChannelDefinition) o;
    return Objects.equals(this.attribValue, if11SellChannelDefinition.attribValue) &&
        Objects.equals(this.attribName, if11SellChannelDefinition.attribName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attribValue, attribName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11SellChannelDefinition {\n");

    sb.append("    attribValue: ").append(toIndentedString(attribValue)).append("\n");
    sb.append("    attribName: ").append(toIndentedString(attribName)).append("\n");
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

