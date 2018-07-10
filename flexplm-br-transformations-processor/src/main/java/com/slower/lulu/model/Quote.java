package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Quote
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-08T14:46:41.638-07:00")

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

  @JsonProperty("@status_06")
  private String status06 = null;

  @JsonProperty("@buy_program_no")
  private String buyProgramNo = null;

  @JsonProperty("@memo1")
  private String memo1 = null;

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

  @JsonProperty("@ref_no")
  private String refNo = null;

  @JsonProperty("@subdept")
  private String subdept = null;

  @JsonProperty("@memo2")
  private String memo2 = null;

  @JsonProperty("@status_01")
  private String status01 = null;

  @JsonProperty("@status_03")
  private String status03 = null;

  @JsonProperty("@status_05")
  private String status05 = null;

  @JsonProperty("notes")
  private Note notes = null;

  @JsonProperty("size_ranges")
  private SizeRange sizeRanges = null;

  @JsonProperty("quote_ext")
  private QuoteExt quoteExt = null;

  @JsonProperty("attachment")
  private Attachment attachment = null;

  public Quote() {
  }

  public Quote(String owner, String itemNo, String description, String season, String seasonYear, String altDesc1, String status04, String requestType, String status06, String buyProgramNo, String memo1, String brand, String propertyClass, String subclass, String dept, String division, String refNo, String subdept, String memo2, String status01, String status03, String status05, Note notes, SizeRange sizeRanges, QuoteExt quoteExt, Attachment attachment) {
    this.owner = owner;
    this.itemNo = itemNo;
    this.description = description;
    this.season = season;
    this.seasonYear = seasonYear;
    this.altDesc1 = altDesc1;
    this.status04 = status04;
    this.requestType = requestType;
    this.status06 = status06;
    this.buyProgramNo = buyProgramNo;
    this.memo1 = memo1;
    this.brand = brand;
    this.propertyClass = propertyClass;
    this.subclass = subclass;
    this.dept = dept;
    this.division = division;
    this.refNo = refNo;
    this.subdept = subdept;
    this.memo2 = memo2;
    this.status01 = status01;
    this.status03 = status03;
    this.status05 = status05;
    this.notes = notes;
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

  public Quote status06(String status06) {
    this.status06 = status06;
    return this;
  }

   /**
   * status
   * @return status06
  **/
  @ApiModelProperty(value = "status")
  public String getStatus06() {
    return status06;
  }

  public void setStatus06(String status06) {
    this.status06 = status06;
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

  public Quote memo1(String memo1) {
    this.memo1 = memo1;
    return this;
  }

   /**
   * Design POD
   * @return memo1
  **/
  @ApiModelProperty(value = "Design POD")
  public String getMemo1() {
    return memo1;
  }

  public void setMemo1(String memo1) {
    this.memo1 = memo1;
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

  public Quote refNo(String refNo) {
    this.refNo = refNo;
    return this;
  }

   /**
   * What If Costing Group
   * @return refNo
  **/
  @ApiModelProperty(value = "What If Costing Group")
  public String getRefNo() {
    return refNo;
  }

  public void setRefNo(String refNo) {
    this.refNo = refNo;
  }

  public Quote subdept(String subdept) {
    this.subdept = subdept;
    return this;
  }

   /**
   * Category
   * @return subdept
  **/
  @ApiModelProperty(value = "Category")
  public String getSubdept() {
    return subdept;
  }

  public void setSubdept(String subdept) {
    this.subdept = subdept;
  }

  public Quote memo2(String memo2) {
    this.memo2 = memo2;
    return this;
  }

   /**
   * Design Line
   * @return memo2
  **/
  @ApiModelProperty(value = "Design Line")
  public String getMemo2() {
    return memo2;
  }

  public void setMemo2(String memo2) {
    this.memo2 = memo2;
  }

  public Quote status01(String status01) {
    this.status01 = status01;
    return this;
  }

   /**
   * Size Run Sample Status
   * @return status01
  **/
  @ApiModelProperty(value = "Size Run Sample Status")
  public String getStatus01() {
    return status01;
  }

  public void setStatus01(String status01) {
    this.status01 = status01;
  }

  public Quote status03(String status03) {
    this.status03 = status03;
    return this;
  }

   /**
   * Proto Sample Status
   * @return status03
  **/
  @ApiModelProperty(value = "Proto Sample Status")
  public String getStatus03() {
    return status03;
  }

  public void setStatus03(String status03) {
    this.status03 = status03;
  }

  public Quote status05(String status05) {
    this.status05 = status05;
    return this;
  }

   /**
   * Calendar Track
   * @return status05
  **/
  @ApiModelProperty(value = "Calendar Track")
  public String getStatus05() {
    return status05;
  }

  public void setStatus05(String status05) {
    this.status05 = status05;
  }

  public Quote notes(Note notes) {
    this.notes = notes;
    return this;
  }

   /**
   * Get notes
   * @return notes
  **/
  @ApiModelProperty(value = "")
  public Note getNotes() {
    return notes;
  }

  public void setNotes(Note notes) {
    this.notes = notes;
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
        Objects.equals(this.status06, quote.status06) &&
        Objects.equals(this.buyProgramNo, quote.buyProgramNo) &&
        Objects.equals(this.memo1, quote.memo1) &&
        Objects.equals(this.brand, quote.brand) &&
        Objects.equals(this.propertyClass, quote.propertyClass) &&
        Objects.equals(this.subclass, quote.subclass) &&
        Objects.equals(this.dept, quote.dept) &&
        Objects.equals(this.division, quote.division) &&
        Objects.equals(this.refNo, quote.refNo) &&
        Objects.equals(this.subdept, quote.subdept) &&
        Objects.equals(this.memo2, quote.memo2) &&
        Objects.equals(this.status01, quote.status01) &&
        Objects.equals(this.status03, quote.status03) &&
        Objects.equals(this.status05, quote.status05) &&
        Objects.equals(this.notes, quote.notes) &&
        Objects.equals(this.sizeRanges, quote.sizeRanges) &&
        Objects.equals(this.quoteExt, quote.quoteExt) &&
        Objects.equals(this.attachment, quote.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, itemNo, description, season, seasonYear, altDesc1, status04, requestType, status06, buyProgramNo, memo1, brand, propertyClass, subclass, dept, division, refNo, subdept, memo2, status01, status03, status05, notes, sizeRanges, quoteExt, attachment);
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
    sb.append("    status06: ").append(toIndentedString(status06)).append("\n");
    sb.append("    buyProgramNo: ").append(toIndentedString(buyProgramNo)).append("\n");
    sb.append("    memo1: ").append(toIndentedString(memo1)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
    sb.append("    subclass: ").append(toIndentedString(subclass)).append("\n");
    sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
    sb.append("    division: ").append(toIndentedString(division)).append("\n");
    sb.append("    refNo: ").append(toIndentedString(refNo)).append("\n");
    sb.append("    subdept: ").append(toIndentedString(subdept)).append("\n");
    sb.append("    memo2: ").append(toIndentedString(memo2)).append("\n");
    sb.append("    status01: ").append(toIndentedString(status01)).append("\n");
    sb.append("    status03: ").append(toIndentedString(status03)).append("\n");
    sb.append("    status05: ").append(toIndentedString(status05)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

