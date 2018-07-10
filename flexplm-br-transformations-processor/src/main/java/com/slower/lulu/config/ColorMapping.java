package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ColorMapping
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-09T21:39:42.672-07:00")

public class ColorMapping   {
  @JsonProperty("status")
  private List<FlexBrMapping> status = new ArrayList<FlexBrMapping>();

  public ColorMapping status(List<FlexBrMapping> status) {
    this.status = status;
    return this;
  }

  public ColorMapping addStatusItem(FlexBrMapping statusItem) {
    this.status.add(statusItem);
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getStatus() {
    return status;
  }

  public void setStatus(List<FlexBrMapping> status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColorMapping colorMapping = (ColorMapping) o;
    return Objects.equals(this.status, colorMapping.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorMapping {\n");

    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

