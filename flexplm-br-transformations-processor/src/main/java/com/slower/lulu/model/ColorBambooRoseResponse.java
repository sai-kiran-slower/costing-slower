package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ColorBambooRoseResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-29T01:48:05.312-07:00")

public class ColorBambooRoseResponse   {
  @JsonProperty("document")
  private ColorDocument document = null;

  public ColorBambooRoseResponse document(ColorDocument document) {
    this.document = document;
    return this;
  }

   /**
   * Get document
   * @return document
  **/
  @ApiModelProperty(value = "")
  public ColorDocument getDocument() {
    return document;
  }

  public void setDocument(ColorDocument document) {
    this.document = document;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColorBambooRoseResponse colorBambooRoseResponse = (ColorBambooRoseResponse) o;
    return Objects.equals(this.document, colorBambooRoseResponse.document);
  }

  @Override
  public int hashCode() {
    return Objects.hash(document);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColorBambooRoseResponse {\n");

    sb.append("    document: ").append(toIndentedString(document)).append("\n");
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

