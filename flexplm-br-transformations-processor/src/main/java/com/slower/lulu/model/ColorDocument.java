package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ColorDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class ColorDocument   {
  @JsonProperty("@xmlns:xsi")
  private String xmlnsxsi = null;

  @JsonProperty("color_library")
  private ColorLibrary colorLibrary = null;

  public ColorDocument xmlnsxsi(String xmlnsxsi) {
    this.xmlnsxsi = xmlnsxsi;
    return this;
  }

   /**
   * xlmns xsi
   * @return xmlnsxsi
  **/
  @ApiModelProperty(value = "xlmns xsi")
  public String getXmlnsxsi() {
    return xmlnsxsi;
  }

  public void setXmlnsxsi(String xmlnsxsi) {
    this.xmlnsxsi = xmlnsxsi;
  }

  public ColorDocument colorLibrary(ColorLibrary colorLibrary) {
    this.colorLibrary = colorLibrary;
    return this;
  }

   /**
   * Get colorLibrary
   * @return colorLibrary
  **/
  @ApiModelProperty(value = "")
  public ColorLibrary getColorLibrary() {
    return colorLibrary;
  }

  public void setColorLibrary(ColorLibrary colorLibrary) {
    this.colorLibrary = colorLibrary;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColorDocument colorDocument = (ColorDocument) o;
    return Objects.equals(this.xmlnsxsi, colorDocument.xmlnsxsi) &&
        Objects.equals(this.colorLibrary, colorDocument.colorLibrary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xmlnsxsi, colorLibrary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorDocument {\n");

    sb.append("    xmlnsxsi: ").append(toIndentedString(xmlnsxsi)).append("\n");
    sb.append("    colorLibrary: ").append(toIndentedString(colorLibrary)).append("\n");
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

