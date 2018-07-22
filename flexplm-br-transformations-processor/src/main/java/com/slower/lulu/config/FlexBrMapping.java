package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * FlexBrMapping
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-05T02:02:28.246-07:00")

public class FlexBrMapping   {
  @JsonProperty("flex_code")
  private String flexCode = null;

  @JsonProperty("flex_description")
  private String flexDescription = null;

  @JsonProperty("br_code")
  private String brCode = null;

  @JsonProperty("br_description")
  private String brDescription = null;

  @JsonProperty("translation_required")
  private String translationRequired = null;

  public FlexBrMapping flexCode(String flexCode) {
    this.flexCode = flexCode;
    return this;
  }

   /**
   * FlexPLM code
   * @return flexCode
  **/
  @ApiModelProperty(value = "FlexPLM code")
  public String getFlexCode() {
    return flexCode;
  }

  public void setFlexCode(String flexCode) {
    this.flexCode = flexCode;
  }

  public FlexBrMapping flexDescription(String flexDescription) {
    this.flexDescription = flexDescription;
    return this;
  }

   /**
   * FlexPLM description
   * @return flexDescription
  **/
  @ApiModelProperty(value = "FlexPLM description")
  public String getFlexDescription() {
    return flexDescription;
  }

  public void setFlexDescription(String flexDescription) {
    this.flexDescription = flexDescription;
  }

  public FlexBrMapping brCode(String brCode) {
    this.brCode = brCode;
    return this;
  }

   /**
   * Bamboo Rose code
   * @return brCode
  **/
  @ApiModelProperty(value = "Bamboo Rose code")
  public String getBrCode() {
    return brCode;
  }

  public void setBrCode(String brCode) {
    this.brCode = brCode;
  }

  public FlexBrMapping brDescription(String brDescription) {
    this.brDescription = brDescription;
    return this;
  }

   /**
   * Bamboo Rose description
   * @return brDescription
  **/
  @ApiModelProperty(value = "Bamboo Rose description")
  public String getBrDescription() {
    return brDescription;
  }

  public void setBrDescription(String brDescription) {
    this.brDescription = brDescription;
  }

  public FlexBrMapping translationRequired(String translationRequired) {
    this.translationRequired = translationRequired;
    return this;
  }

   /**
   * translation required or not
   * @return translationRequired
  **/
  @ApiModelProperty(value = "translation required or not")
  public String getTranslationRequired() {
    return translationRequired;
  }

  public void setTranslationRequired(String translationRequired) {
    this.translationRequired = translationRequired;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlexBrMapping flexBrMapping = (FlexBrMapping) o;
    return Objects.equals(this.flexCode, flexBrMapping.flexCode) &&
        Objects.equals(this.flexDescription, flexBrMapping.flexDescription) &&
        Objects.equals(this.brCode, flexBrMapping.brCode) &&
        Objects.equals(this.brDescription, flexBrMapping.brDescription) &&
        Objects.equals(this.translationRequired, flexBrMapping.translationRequired);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flexCode, flexDescription, brCode, brDescription, translationRequired);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlexBrMapping {\n");

    sb.append("    flexCode: ").append(toIndentedString(flexCode)).append("\n");
    sb.append("    flexDescription: ").append(toIndentedString(flexDescription)).append("\n");
    sb.append("    brCode: ").append(toIndentedString(brCode)).append("\n");
    sb.append("    brDescription: ").append(toIndentedString(brDescription)).append("\n");
    sb.append("    translationRequired: ").append(toIndentedString(translationRequired)).append("\n");
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

