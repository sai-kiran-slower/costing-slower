package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ArtworkLibD
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class ArtworkLibD   {
  @JsonProperty("@memo3")
  private String memo3 = null;

  @JsonProperty("@color_pos")
  private String colorPos = null;

  @JsonProperty("@memo1")
  private String memo1 = null;

  @JsonProperty("@combo_id")
  private String comboId = null;

  public ArtworkLibD memo3(String memo3) {
    this.memo3 = memo3;
    return this;
  }

   /**
   * Color ID
   * @return memo3
  **/
  @ApiModelProperty(value = "Color ID")
  public String getMemo3() {
    return memo3;
  }

  public void setMemo3(String memo3) {
    this.memo3 = memo3;
  }

  public ArtworkLibD colorPos(String colorPos) {
    this.colorPos = colorPos;
    return this;
  }

   /**
   * Color Position
   * @return colorPos
  **/
  @ApiModelProperty(value = "Color Position")
  public String getColorPos() {
    return colorPos;
  }

  public void setColorPos(String colorPos) {
    this.colorPos = colorPos;
  }

  public ArtworkLibD memo1(String memo1) {
    this.memo1 = memo1;
    return this;
  }

   /**
   * Artwork No
   * @return memo1
  **/
  @ApiModelProperty(value = "Artwork No")
  public String getMemo1() {
    return memo1;
  }

  public void setMemo1(String memo1) {
    this.memo1 = memo1;
  }

  public ArtworkLibD comboId(String comboId) {
    this.comboId = comboId;
    return this;
  }

   /**
   * Combo ID
   * @return comboId
  **/
  @ApiModelProperty(value = "Combo ID")
  public String getComboId() {
    return comboId;
  }

  public void setComboId(String comboId) {
    this.comboId = comboId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtworkLibD artworkLibD = (ArtworkLibD) o;
    return Objects.equals(this.memo3, artworkLibD.memo3) &&
        Objects.equals(this.colorPos, artworkLibD.colorPos) &&
        Objects.equals(this.memo1, artworkLibD.memo1) &&
        Objects.equals(this.comboId, artworkLibD.comboId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memo3, colorPos, memo1, comboId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArtworkLibD {\n");

    sb.append("    memo3: ").append(toIndentedString(memo3)).append("\n");
    sb.append("    colorPos: ").append(toIndentedString(colorPos)).append("\n");
    sb.append("    memo1: ").append(toIndentedString(memo1)).append("\n");
    sb.append("    comboId: ").append(toIndentedString(comboId)).append("\n");
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

