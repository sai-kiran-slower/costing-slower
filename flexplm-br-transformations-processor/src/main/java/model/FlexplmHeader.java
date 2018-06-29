package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FlexplmHeader
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-28T23:51:44.370-07:00")

public class FlexplmHeader   {
  @JsonProperty("EVENT")
  private String EVENT = null;

  @JsonProperty("INTERFACE")
  private String INTERFACE = null;

  @JsonProperty("TIMESTAMP")
  private String TIMESTAMP = null;

  @JsonProperty("Attribute_List")
  private List<Attribute> attributeList = new ArrayList<Attribute>();

  public FlexplmHeader EVENT(String EVENT) {
    this.EVENT = EVENT;
    return this;
  }

   /**
   * event type
   * @return EVENT
  **/
  @ApiModelProperty(value = "event type")
  public String getEVENT() {
    return EVENT;
  }

  public void setEVENT(String EVENT) {
    this.EVENT = EVENT;
  }

  public FlexplmHeader INTERFACE(String INTERFACE) {
    this.INTERFACE = INTERFACE;
    return this;
  }

   /**
   * interface name
   * @return INTERFACE
  **/
  @ApiModelProperty(value = "interface name")
  public String getINTERFACE() {
    return INTERFACE;
  }

  public void setINTERFACE(String INTERFACE) {
    this.INTERFACE = INTERFACE;
  }

  public FlexplmHeader TIMESTAMP(String TIMESTAMP) {
    this.TIMESTAMP = TIMESTAMP;
    return this;
  }

   /**
   * A UTC timestamp for when the response was given
   * @return TIMESTAMP
  **/
  @ApiModelProperty(value = "A UTC timestamp for when the response was given")
  public String getTIMESTAMP() {
    return TIMESTAMP;
  }

  public void setTIMESTAMP(String TIMESTAMP) {
    this.TIMESTAMP = TIMESTAMP;
  }

  public FlexplmHeader attributeList(List<Attribute> attributeList) {
    this.attributeList = attributeList;
    return this;
  }

  public FlexplmHeader addAttributeListItem(Attribute attributeListItem) {
    this.attributeList.add(attributeListItem);
    return this;
  }

   /**
   * Get attributeList
   * @return attributeList
  **/
  @ApiModelProperty(value = "")
  public List<Attribute> getAttributeList() {
    return attributeList;
  }

  public void setAttributeList(List<Attribute> attributeList) {
    this.attributeList = attributeList;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FlexplmHeader flexplmHeader = (FlexplmHeader) o;
    return Objects.equals(this.EVENT, flexplmHeader.EVENT) &&
        Objects.equals(this.INTERFACE, flexplmHeader.INTERFACE) &&
        Objects.equals(this.TIMESTAMP, flexplmHeader.TIMESTAMP) &&
        Objects.equals(this.attributeList, flexplmHeader.attributeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(EVENT, INTERFACE, TIMESTAMP, attributeList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FlexplmHeader {\n");

    sb.append("    EVENT: ").append(toIndentedString(EVENT)).append("\n");
    sb.append("    INTERFACE: ").append(toIndentedString(INTERFACE)).append("\n");
    sb.append("    TIMESTAMP: ").append(toIndentedString(TIMESTAMP)).append("\n");
    sb.append("    attributeList: ").append(toIndentedString(attributeList)).append("\n");
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

