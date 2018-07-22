package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ArtworkDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-08T20:42:10.136-07:00")

public class ArtworkDocument   {
  @JsonProperty("artwork_lib")
  private ArtworkLib artworkLib = null;

  public ArtworkDocument artworkLib(ArtworkLib artworkLib) {
    this.artworkLib = artworkLib;
    return this;
  }

   /**
   * Get artworkLib
   * @return artworkLib
  **/
  @ApiModelProperty(value = "")
  public ArtworkLib getArtworkLib() {
    return artworkLib;
  }

  public void setArtworkLib(ArtworkLib artworkLib) {
    this.artworkLib = artworkLib;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtworkDocument artworkDocument = (ArtworkDocument) o;
    return Objects.equals(this.artworkLib, artworkDocument.artworkLib);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artworkLib);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtworkDocument {\n");

    sb.append("    artworkLib: ").append(toIndentedString(artworkLib)).append("\n");
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

