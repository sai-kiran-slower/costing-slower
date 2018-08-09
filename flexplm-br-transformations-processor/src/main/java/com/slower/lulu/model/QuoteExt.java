package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * QuoteExt
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-08T21:12:44.291-07:00")

public class QuoteExt   {
  @JsonProperty("@pattern_maker")
  private String patternMaker = null;

  @JsonProperty("@prodmgr")
  private String prodmgr = null;

  @JsonProperty("@designer")
  private String designer = null;

  public QuoteExt patternMaker(String patternMaker) {
    this.patternMaker = patternMaker;
    return this;
  }

   /**
   * pattern maker
   * @return patternMaker
  **/
  @ApiModelProperty(value = "pattern maker")
  public String getPatternMaker() {
    return patternMaker;
  }

  public void setPatternMaker(String patternMaker) {
    this.patternMaker = patternMaker;
  }

  public QuoteExt prodmgr(String prodmgr) {
    this.prodmgr = prodmgr;
    return this;
  }

   /**
   * prod manager
   * @return prodmgr
  **/
  @ApiModelProperty(value = "prod manager")
  public String getProdmgr() {
    return prodmgr;
  }

  public void setProdmgr(String prodmgr) {
    this.prodmgr = prodmgr;
  }

  public QuoteExt designer(String designer) {
    this.designer = designer;
    return this;
  }

   /**
   * designer
   * @return designer
  **/
  @ApiModelProperty(value = "designer")
  public String getDesigner() {
    return designer;
  }

  public void setDesigner(String designer) {
    this.designer = designer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuoteExt quoteExt = (QuoteExt) o;
    return Objects.equals(this.patternMaker, quoteExt.patternMaker) &&
        Objects.equals(this.prodmgr, quoteExt.prodmgr) &&
        Objects.equals(this.designer, quoteExt.designer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patternMaker, prodmgr, designer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteExt {\n");

    sb.append("    patternMaker: ").append(toIndentedString(patternMaker)).append("\n");
    sb.append("    prodmgr: ").append(toIndentedString(prodmgr)).append("\n");
    sb.append("    designer: ").append(toIndentedString(designer)).append("\n");
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

