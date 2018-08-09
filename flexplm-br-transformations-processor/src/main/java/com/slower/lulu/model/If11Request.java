package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * If11Request
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class If11Request   {
  @JsonProperty("request")
  private List<If11Quote> request = new ArrayList<If11Quote>();

  public If11Request request(List<If11Quote> request) {
    this.request = request;
    return this;
  }

  public If11Request addRequestItem(If11Quote requestItem) {
    this.request.add(requestItem);
    return this;
  }

   /**
   * Get request
   * @return request
  **/
  @ApiModelProperty(value = "")
  public List<If11Quote> getRequest() {
    return request;
  }

  public void setRequest(List<If11Quote> request) {
    this.request = request;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    If11Request if11Request = (If11Request) o;
    return Objects.equals(this.request, if11Request.request);
  }

  @Override
  public int hashCode() {
    return Objects.hash(request);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11Request {\n");

    sb.append("    request: ").append(toIndentedString(request)).append("\n");
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

