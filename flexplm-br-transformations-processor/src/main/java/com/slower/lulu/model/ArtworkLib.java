package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ArtworkLib
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class ArtworkLib   {
  @JsonProperty("artwork_lib_h")
  private ArtworkLibH artworkLibH = null;

  public ArtworkLib artworkLibH(ArtworkLibH artworkLibH) {
    this.artworkLibH = artworkLibH;
    return this;
  }

   /**
   * Get artworkLibH
   * @return artworkLibH
  **/
  @ApiModelProperty(value = "")
  public ArtworkLibH getArtworkLibH() {
    return artworkLibH;
  }

  public void setArtworkLibH(ArtworkLibH artworkLibH) {
    this.artworkLibH = artworkLibH;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtworkLib artworkLib = (ArtworkLib) o;
    return Objects.equals(this.artworkLibH, artworkLib.artworkLibH);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artworkLibH);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtworkLib {\n");

    sb.append("    artworkLibH: ").append(toIndentedString(artworkLibH)).append("\n");
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

