package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * StyleDocument
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-29T01:48:05.312-07:00")

public class StyleDocument   {
  @JsonProperty("request")
  private Request request = null;

  public StyleDocument request(Request request) {
    this.request = request;
    return this;
  }

   /**
   * Get request
   * @return request
  **/
  @ApiModelProperty(value = "")
  public Request getRequest() {
    return request;
  }

  public void setRequest(Request request) {
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
    StyleDocument styleDocument = (StyleDocument) o;
    return Objects.equals(this.request, styleDocument.request);
  }

  @Override
  public int hashCode() {
    return Objects.hash(request);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StyleDocument {\n");

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

