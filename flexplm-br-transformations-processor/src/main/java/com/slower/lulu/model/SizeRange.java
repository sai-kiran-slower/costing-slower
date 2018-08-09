package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * SizeRange
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class SizeRange   {
  @JsonProperty("@size_range")
  private String sizeRange = null;

  public SizeRange sizeRange(String sizeRange) {
    this.sizeRange = sizeRange;
    return this;
  }

   /**
   * size range
   * @return sizeRange
  **/
  @ApiModelProperty(value = "size range")
  public String getSizeRange() {
    return sizeRange;
  }

  public void setSizeRange(String sizeRange) {
    this.sizeRange = sizeRange;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SizeRange sizeRange = (SizeRange) o;
    return Objects.equals(this.sizeRange, sizeRange.sizeRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sizeRange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SizeRange {\n");

    sb.append("    sizeRange: ").append(toIndentedString(sizeRange)).append("\n");
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

