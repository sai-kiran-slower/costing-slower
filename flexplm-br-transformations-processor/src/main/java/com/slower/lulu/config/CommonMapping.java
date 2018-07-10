package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CommonMapping
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-08T21:05:13.398-07:00")

public class CommonMapping   {
  @JsonProperty("active_ind")
  private List<FlexBrMapping> activeInd = new ArrayList<FlexBrMapping>();

  public CommonMapping activeInd(List<FlexBrMapping> activeInd) {
    this.activeInd = activeInd;
    return this;
  }

  public CommonMapping addActiveIndItem(FlexBrMapping activeIndItem) {
    this.activeInd.add(activeIndItem);
    return this;
  }

   /**
   * Get activeInd
   * @return activeInd
  **/
  @ApiModelProperty(value = "")
  public List<FlexBrMapping> getActiveInd() {
    return activeInd;
  }

  public void setActiveInd(List<FlexBrMapping> activeInd) {
    this.activeInd = activeInd;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonMapping commonMapping = (CommonMapping) o;
    return Objects.equals(this.activeInd, commonMapping.activeInd);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeInd);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonMapping {\n");

    sb.append("    activeInd: ").append(toIndentedString(activeInd)).append("\n");
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

