package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Quote
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-28T23:51:44.370-07:00")

public class Quote   {
  @JsonProperty("@owner")
  private String owner = null;

  @JsonProperty("@item_no")
  private String itemNo = null;

  @JsonProperty("@description")
  private String description = null;

  @JsonProperty("@season")
  private String season = null;

  @JsonProperty("@season_year")
  private String seasonYear = null;

  @JsonProperty("@alt_desc1")
  private String altDesc1 = null;

  @JsonProperty("@status_04")
  private String status04 = null;

  @JsonProperty("@request_type")
  private String requestType = null;

  @JsonProperty("@status")
  private String status = null;

  @JsonProperty("@buy_program_no")
  private String buyProgramNo = null;

  @JsonProperty("@commodity")
  private String commodity = null;

  @JsonProperty("@brand")
  private String brand = null;

  @JsonProperty("@class")
  private String propertyClass = null;

  @JsonProperty("@subclass")
  private String subclass = null;

  @JsonProperty("@dept")
  private String dept = null;

  @JsonProperty("@division")
  private String division = null;

  @JsonProperty("@size_ranges")
  private SizeRange sizeRanges = null;

  @JsonProperty("@quote_ext")
  private QuoteExt quoteExt = null;

  @JsonProperty("@attachment")
  private Attachment attachment = null;

  public Quote() {
  }

  public Quote(String owner, String itemNo, String description, String season, String seasonYear, String altDesc1, String status04, String requestType, String status, String buyProgramNo, String commodity, String brand, String propertyClass, String subclass, String dept, String division, SizeRange sizeRanges, QuoteExt quoteExt, Attachment attachment) {
    this.owner = owner;
    this.itemNo = itemNo;
    this.description = description;
    this.season = season;
    this.seasonYear = seasonYear;
    this.altDesc1 = altDesc1;
    this.status04 = status04;
    this.requestType = requestType;
    this.status = status;
    this.buyProgramNo = buyProgramNo;
    this.commodity = commodity;
    this.brand = brand;
    this.propertyClass = propertyClass;
    this.subclass = subclass;
    this.dept = dept;
    this.division = division;
    this.sizeRanges = sizeRanges;
    this.quoteExt = quoteExt;
    this.attachment = attachment;
  }

  public Quote owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * owner name
   * @return owner
  **/
  @ApiModelProperty(value = "owner name")
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Quote itemNo(String itemNo) {
    this.itemNo = itemNo;
    return this;
  }

   /**
   * item number
   * @return itemNo
  **/
  @ApiModelProperty(value = "item number")
  public String getItemNo() {
    return itemNo;
  }

  public void setItemNo(String itemNo) {
    this.itemNo = itemNo;
  }

  public Quote description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description of item
   * @return description
  **/
  @ApiModelProperty(value = "description of item")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Quote season(String season) {
    this.season = season;
    return this;
  }

   /**
   * Season
   * @return season
  **/
  @ApiModelProperty(value = "Season")
  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public Quote seasonYear(String seasonYear) {
    this.seasonYear = seasonYear;
    return this;
  }

   /**
   * Season year
   * @return seasonYear
  **/
  @ApiModelProperty(value = "Season year")
  public String getSeasonYear() {
    return seasonYear;
  }

  public void setSeasonYear(String seasonYear) {
    this.seasonYear = seasonYear;
  }

  public Quote altDesc1(String altDesc1) {
    this.altDesc1 = altDesc1;
    return this;
  }

   /**
   * alt_desc1
   * @return altDesc1
  **/
  @ApiModelProperty(value = "alt_desc1")
  public String getAltDesc1() {
    return altDesc1;
  }

  public void setAltDesc1(String altDesc1) {
    this.altDesc1 = altDesc1;
  }

  public Quote status04(String status04) {
    this.status04 = status04;
    return this;
  }

   /**
   * seasonal style type
   * @return status04
  **/
  @ApiModelProperty(value = "seasonal style type")
  public String getStatus04() {
    return status04;
  }

  public void setStatus04(String status04) {
    this.status04 = status04;
  }

  public Quote requestType(String requestType) {
    this.requestType = requestType;
    return this;
  }

   /**
   * request type
   * @return requestType
  **/
  @ApiModelProperty(value = "request type")
  public String getRequestType() {
    return requestType;
  }

  public void setRequestType(String requestType) {
    this.requestType = requestType;
  }

  public Quote status(String status) {
    this.status = status;
    return this;
  }

   /**
   * status
   * @return status
  **/
  @ApiModelProperty(value = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Quote buyProgramNo(String buyProgramNo) {
    this.buyProgramNo = buyProgramNo;
    return this;
  }

   /**
   * buy program number
   * @return buyProgramNo
  **/
  @ApiModelProperty(value = "buy program number")
  public String getBuyProgramNo() {
    return buyProgramNo;
  }

  public void setBuyProgramNo(String buyProgramNo) {
    this.buyProgramNo = buyProgramNo;
  }

  public Quote commodity(String commodity) {
    this.commodity = commodity;
    return this;
  }

   /**
   * commodity
   * @return commodity
  **/
  @ApiModelProperty(value = "commodity")
  public String getCommodity() {
    return commodity;
  }

  public void setCommodity(String commodity) {
    this.commodity = commodity;
  }

  public Quote brand(String brand) {
    this.brand = brand;
    return this;
  }

   /**
   * brand
   * @return brand
  **/
  @ApiModelProperty(value = "brand")
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Quote propertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
    return this;
  }

   /**
   * class
   * @return propertyClass
  **/
  @ApiModelProperty(value = "class")
  public String getPropertyClass() {
    return propertyClass;
  }

  public void setPropertyClass(String propertyClass) {
    this.propertyClass = propertyClass;
  }

  public Quote subclass(String subclass) {
    this.subclass = subclass;
    return this;
  }

   /**
   * sub class
   * @return subclass
  **/
  @ApiModelProperty(value = "sub class")
  public String getSubclass() {
    return subclass;
  }

  public void setSubclass(String subclass) {
    this.subclass = subclass;
  }

  public Quote dept(String dept) {
    this.dept = dept;
    return this;
  }

   /**
   * department
   * @return dept
  **/
  @ApiModelProperty(value = "department")
  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public Quote division(String division) {
    this.division = division;
    return this;
  }

   /**
   * division
   * @return division
  **/
  @ApiModelProperty(value = "division")
  public String getDivision() {
    return division;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  public Quote sizeRanges(SizeRange sizeRanges) {
    this.sizeRanges = sizeRanges;
    return this;
  }

   /**
   * Get sizeRanges
   * @return sizeRanges
  **/
  @ApiModelProperty(value = "")
  public SizeRange getSizeRanges() {
    return sizeRanges;
  }

  public void setSizeRanges(SizeRange sizeRanges) {
    this.sizeRanges = sizeRanges;
  }

  public Quote quoteExt(QuoteExt quoteExt) {
    this.quoteExt = quoteExt;
    return this;
  }

   /**
   * Get quoteExt
   * @return quoteExt
  **/
  @ApiModelProperty(value = "")
  public QuoteExt getQuoteExt() {
    return quoteExt;
  }

  public void setQuoteExt(QuoteExt quoteExt) {
    this.quoteExt = quoteExt;
  }

  public Quote attachment(Attachment attachment) {
    this.attachment = attachment;
    return this;
  }

   /**
   * Get attachment
   * @return attachment
  **/
  @ApiModelProperty(value = "")
  public Attachment getAttachment() {
    return attachment;
  }

  public void setAttachment(Attachment attachment) {
    this.attachment = attachment;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quote quote = (Quote) o;
    return Objects.equals(this.owner, quote.owner) &&
        Objects.equals(this.itemNo, quote.itemNo) &&
        Objects.equals(this.description, quote.description) &&
        Objects.equals(this.season, quote.season) &&
        Objects.equals(this.seasonYear, quote.seasonYear) &&
        Objects.equals(this.altDesc1, quote.altDesc1) &&
        Objects.equals(this.status04, quote.status04) &&
        Objects.equals(this.requestType, quote.requestType) &&
        Objects.equals(this.status, quote.status) &&
        Objects.equals(this.buyProgramNo, quote.buyProgramNo) &&
        Objects.equals(this.commodity, quote.commodity) &&
        Objects.equals(this.brand, quote.brand) &&
        Objects.equals(this.propertyClass, quote.propertyClass) &&
        Objects.equals(this.subclass, quote.subclass) &&
        Objects.equals(this.dept, quote.dept) &&
        Objects.equals(this.division, quote.division) &&
        Objects.equals(this.sizeRanges, quote.sizeRanges) &&
        Objects.equals(this.quoteExt, quote.quoteExt) &&
        Objects.equals(this.attachment, quote.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, itemNo, description, season, seasonYear, altDesc1, status04, requestType, status, buyProgramNo, commodity, brand, propertyClass, subclass, dept, division, sizeRanges, quoteExt, attachment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Quote {\n");

    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    itemNo: ").append(toIndentedString(itemNo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    season: ").append(toIndentedString(season)).append("\n");
    sb.append("    seasonYear: ").append(toIndentedString(seasonYear)).append("\n");
    sb.append("    altDesc1: ").append(toIndentedString(altDesc1)).append("\n");
    sb.append("    status04: ").append(toIndentedString(status04)).append("\n");
    sb.append("    requestType: ").append(toIndentedString(requestType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    buyProgramNo: ").append(toIndentedString(buyProgramNo)).append("\n");
    sb.append("    commodity: ").append(toIndentedString(commodity)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    subclass: ").append(toIndentedString(subclass)).append("\n");
    sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
    sb.append("    division: ").append(toIndentedString(division)).append("\n");
    sb.append("    sizeRanges: ").append(toIndentedString(sizeRanges)).append("\n");
    sb.append("    quoteExt: ").append(toIndentedString(quoteExt)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
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

