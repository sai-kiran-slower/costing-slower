package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ColorLibrary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-29T01:48:05.312-07:00")

public class ColorLibrary   {
  @JsonProperty("colorlib_h")
  private ColorlibH colorlibH = null;

  public ColorLibrary colorlibH(ColorlibH colorlibH) {
    this.colorlibH = colorlibH;
    return this;
  }

   /**
   * Get colorlibH
   * @return colorlibH
  **/
  @ApiModelProperty(value = "")
  public ColorlibH getColorlibH() {
    return colorlibH;
  }

  public void setColorlibH(ColorlibH colorlibH) {
    this.colorlibH = colorlibH;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColorLibrary colorLibrary = (ColorLibrary) o;
    return Objects.equals(this.colorlibH, colorLibrary.colorlibH);
  }

  @Override
  public int hashCode() {
    return Objects.hash(colorlibH);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorLibrary {\n");

    sb.append("    colorlibH: ").append(toIndentedString(colorlibH)).append("\n");
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

