package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ArtworkBambooRoseResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class ArtworkBambooRoseResponse   {
  @JsonProperty("document")
  private ArtworkDocument document = null;

  public ArtworkBambooRoseResponse document(ArtworkDocument document) {
    this.document = document;
    return this;
  }

   /**
   * Get document
   * @return document
  **/
  @ApiModelProperty(value = "")
  public ArtworkDocument getDocument() {
    return document;
  }

  public void setDocument(ArtworkDocument document) {
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
    ArtworkBambooRoseResponse artworkBambooRoseResponse = (ArtworkBambooRoseResponse) o;
    return Objects.equals(this.document, artworkBambooRoseResponse.document);
  }

  @Override
  public int hashCode() {
    return Objects.hash(document);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtworkBambooRoseResponse {\n");

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

