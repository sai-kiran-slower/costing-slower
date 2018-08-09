package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Attribute
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class Attribute   {
  @JsonProperty("OBJECT_LEVEL")
  private String OBJECT_LEVEL = null;

  @JsonProperty("OBJECT_ID")
  private String OBJECT_ID = null;

  @JsonProperty("FLEXTYPE")
  private String FLEXTYPE = null;

  @JsonProperty("FIELD_NAME_KEY")
  private String FIELD_NAME_KEY = null;

  @JsonProperty("FIELD_NAME_DISPLAY")
  private String FIELD_NAME_DISPLAY = null;

  @JsonProperty("FIELD_VALUE_KEY")
  private String FIELD_VALUE_KEY = null;

  @JsonProperty("FIELD_VALUE_DISPLAY")
  private String FIELD_VALUE_DISPLAY = null;

  @JsonProperty("FIELD_TYPE")
  private String FIELD_TYPE = null;

  @JsonProperty("CHANGE_IND")
  private String CHANGE_IND = null;

  public Attribute OBJECT_LEVEL(String OBJECT_LEVEL) {
    this.OBJECT_LEVEL = OBJECT_LEVEL;
    return this;
  }

   /**
   * object level
   * @return OBJECT_LEVEL
  **/
  @ApiModelProperty(value = "object level")
  public String getOBJECTLEVEL() {
    return OBJECT_LEVEL;
  }

  public void setOBJECTLEVEL(String OBJECT_LEVEL) {
    this.OBJECT_LEVEL = OBJECT_LEVEL;
  }

  public Attribute OBJECT_ID(String OBJECT_ID) {
    this.OBJECT_ID = OBJECT_ID;
    return this;
  }

   /**
   * object id
   * @return OBJECT_ID
  **/
  @ApiModelProperty(value = "object id")
  public String getOBJECTID() {
    return OBJECT_ID;
  }

  public void setOBJECTID(String OBJECT_ID) {
    this.OBJECT_ID = OBJECT_ID;
  }

  public Attribute FLEXTYPE(String FLEXTYPE) {
    this.FLEXTYPE = FLEXTYPE;
    return this;
  }

   /**
   * flex type
   * @return FLEXTYPE
  **/
  @ApiModelProperty(value = "flex type")
  public String getFLEXTYPE() {
    return FLEXTYPE;
  }

  public void setFLEXTYPE(String FLEXTYPE) {
    this.FLEXTYPE = FLEXTYPE;
  }

  public Attribute FIELD_NAME_KEY(String FIELD_NAME_KEY) {
    this.FIELD_NAME_KEY = FIELD_NAME_KEY;
    return this;
  }

   /**
   * field name key
   * @return FIELD_NAME_KEY
  **/
  @ApiModelProperty(value = "field name key")
  public String getFIELDNAMEKEY() {
    return FIELD_NAME_KEY;
  }

  public void setFIELDNAMEKEY(String FIELD_NAME_KEY) {
    this.FIELD_NAME_KEY = FIELD_NAME_KEY;
  }

  public Attribute FIELD_NAME_DISPLAY(String FIELD_NAME_DISPLAY) {
    this.FIELD_NAME_DISPLAY = FIELD_NAME_DISPLAY;
    return this;
  }

   /**
   * field name display
   * @return FIELD_NAME_DISPLAY
  **/
  @ApiModelProperty(value = "field name display")
  public String getFIELDNAMEDISPLAY() {
    return FIELD_NAME_DISPLAY;
  }

  public void setFIELDNAMEDISPLAY(String FIELD_NAME_DISPLAY) {
    this.FIELD_NAME_DISPLAY = FIELD_NAME_DISPLAY;
  }

  public Attribute FIELD_VALUE_KEY(String FIELD_VALUE_KEY) {
    this.FIELD_VALUE_KEY = FIELD_VALUE_KEY;
    return this;
  }

   /**
   * field name value
   * @return FIELD_VALUE_KEY
  **/
  @ApiModelProperty(value = "field name value")
  public String getFIELDVALUEKEY() {
    return FIELD_VALUE_KEY;
  }

  public void setFIELDVALUEKEY(String FIELD_VALUE_KEY) {
    this.FIELD_VALUE_KEY = FIELD_VALUE_KEY;
  }

  public Attribute FIELD_VALUE_DISPLAY(String FIELD_VALUE_DISPLAY) {
    this.FIELD_VALUE_DISPLAY = FIELD_VALUE_DISPLAY;
    return this;
  }

   /**
   * field name display
   * @return FIELD_VALUE_DISPLAY
  **/
  @ApiModelProperty(value = "field name display")
  public String getFIELDVALUEDISPLAY() {
    return FIELD_VALUE_DISPLAY;
  }

  public void setFIELDVALUEDISPLAY(String FIELD_VALUE_DISPLAY) {
    this.FIELD_VALUE_DISPLAY = FIELD_VALUE_DISPLAY;
  }

  public Attribute FIELD_TYPE(String FIELD_TYPE) {
    this.FIELD_TYPE = FIELD_TYPE;
    return this;
  }

   /**
   * field type
   * @return FIELD_TYPE
  **/
  @ApiModelProperty(value = "field type")
  public String getFIELDTYPE() {
    return FIELD_TYPE;
  }

  public void setFIELDTYPE(String FIELD_TYPE) {
    this.FIELD_TYPE = FIELD_TYPE;
  }

  public Attribute CHANGE_IND(String CHANGE_IND) {
    this.CHANGE_IND = CHANGE_IND;
    return this;
  }

   /**
   * change indicator
   * @return CHANGE_IND
  **/
  @ApiModelProperty(value = "change indicator")
  public String getCHANGEIND() {
    return CHANGE_IND;
  }

  public void setCHANGEIND(String CHANGE_IND) {
    this.CHANGE_IND = CHANGE_IND;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attribute attribute = (Attribute) o;
    return Objects.equals(this.OBJECT_LEVEL, attribute.OBJECT_LEVEL) &&
        Objects.equals(this.OBJECT_ID, attribute.OBJECT_ID) &&
        Objects.equals(this.FLEXTYPE, attribute.FLEXTYPE) &&
        Objects.equals(this.FIELD_NAME_KEY, attribute.FIELD_NAME_KEY) &&
        Objects.equals(this.FIELD_NAME_DISPLAY, attribute.FIELD_NAME_DISPLAY) &&
        Objects.equals(this.FIELD_VALUE_KEY, attribute.FIELD_VALUE_KEY) &&
        Objects.equals(this.FIELD_VALUE_DISPLAY, attribute.FIELD_VALUE_DISPLAY) &&
        Objects.equals(this.FIELD_TYPE, attribute.FIELD_TYPE) &&
        Objects.equals(this.CHANGE_IND, attribute.CHANGE_IND);
  }

  @Override
  public int hashCode() {
    return Objects.hash(OBJECT_LEVEL, OBJECT_ID, FLEXTYPE, FIELD_NAME_KEY, FIELD_NAME_DISPLAY, FIELD_VALUE_KEY, FIELD_VALUE_DISPLAY, FIELD_TYPE, CHANGE_IND);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attribute {\n");

    sb.append("    OBJECT_LEVEL: ").append(toIndentedString(OBJECT_LEVEL)).append("\n");
    sb.append("    OBJECT_ID: ").append(toIndentedString(OBJECT_ID)).append("\n");
    sb.append("    FLEXTYPE: ").append(toIndentedString(FLEXTYPE)).append("\n");
    sb.append("    FIELD_NAME_KEY: ").append(toIndentedString(FIELD_NAME_KEY)).append("\n");
    sb.append("    FIELD_NAME_DISPLAY: ").append(toIndentedString(FIELD_NAME_DISPLAY)).append("\n");
    sb.append("    FIELD_VALUE_KEY: ").append(toIndentedString(FIELD_VALUE_KEY)).append("\n");
    sb.append("    FIELD_VALUE_DISPLAY: ").append(toIndentedString(FIELD_VALUE_DISPLAY)).append("\n");
    sb.append("    FIELD_TYPE: ").append(toIndentedString(FIELD_TYPE)).append("\n");
    sb.append("    CHANGE_IND: ").append(toIndentedString(CHANGE_IND)).append("\n");
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

