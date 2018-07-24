package com.slower.lulu.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * MappingConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-23T22:31:43.648-07:00")

public class MappingConfig   {
  @JsonProperty("mapping_rules")
  private MappingRule mappingRules = null;

  public MappingConfig mappingRules(MappingRule mappingRules) {
    this.mappingRules = mappingRules;
    return this;
  }

   /**
   * Get mappingRules
   * @return mappingRules
  **/
  @ApiModelProperty(value = "")
  public MappingRule getMappingRules() {
    return mappingRules;
  }

  public void setMappingRules(MappingRule mappingRules) {
    this.mappingRules = mappingRules;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MappingConfig mappingConfig = (MappingConfig) o;
    return Objects.equals(this.mappingRules, mappingConfig.mappingRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mappingRules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MappingConfig {\n");

    sb.append("    mappingRules: ").append(toIndentedString(mappingRules)).append("\n");
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

