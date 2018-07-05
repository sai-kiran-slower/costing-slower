package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * MappingRule
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-05T02:02:28.246-07:00")

public class MappingRule   {
  @JsonProperty("quote_mapping")
  private QuoteMapping quoteMapping = null;

  public MappingRule quoteMapping(QuoteMapping quoteMapping) {
    this.quoteMapping = quoteMapping;
    return this;
  }

   /**
   * Get quoteMapping
   * @return quoteMapping
  **/
  @ApiModelProperty(value = "")
  public QuoteMapping getQuoteMapping() {
    return quoteMapping;
  }

  public void setQuoteMapping(QuoteMapping quoteMapping) {
    this.quoteMapping = quoteMapping;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MappingRule mappingRule = (MappingRule) o;
    return Objects.equals(this.quoteMapping, mappingRule.quoteMapping);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quoteMapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MappingRule {\n");

    sb.append("    quoteMapping: ").append(toIndentedString(quoteMapping)).append("\n");
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

