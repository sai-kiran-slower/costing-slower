package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * If11Document
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-06T21:58:50.169-07:00")

public class If11Document   {
  @JsonProperty("request")
  private If11Request request = null;

  public If11Document request(If11Request request) {
    this.request = request;
    return this;
  }

   /**
   * Get request
   * @return request
  **/
  @ApiModelProperty(value = "")
  public If11Request getRequest() {
    return request;
  }

  public void setRequest(If11Request request) {
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
    If11Document if11Document = (If11Document) o;
    return Objects.equals(this.request, if11Document.request);
  }

  @Override
  public int hashCode() {
    return Objects.hash(request);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class If11Document {\n");

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

