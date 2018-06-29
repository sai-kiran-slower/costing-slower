package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * StyleFlexPLMResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-28T23:51:44.370-07:00")

public class StyleFlexPLMResponse   {
  @JsonProperty("Flex_interface")
  private FlexInterface flexInterface = null;

  public StyleFlexPLMResponse flexInterface(FlexInterface flexInterface) {
    this.flexInterface = flexInterface;
    return this;
  }

   /**
   * Get flexInterface
   * @return flexInterface
  **/
  @ApiModelProperty(value = "")
  public FlexInterface getFlexInterface() {
    return flexInterface;
  }

  public void setFlexInterface(FlexInterface flexInterface) {
    this.flexInterface = flexInterface;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StyleFlexPLMResponse styleFlexPLMResponse = (StyleFlexPLMResponse) o;
    return Objects.equals(this.flexInterface, styleFlexPLMResponse.flexInterface);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flexInterface);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StyleFlexPLMResponse {\n");

    sb.append("    flexInterface: ").append(toIndentedString(flexInterface)).append("\n");
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

