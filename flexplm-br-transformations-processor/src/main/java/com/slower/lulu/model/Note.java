package com.slower.lulu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Note
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-02T08:10:41.428-07:00")

public class Note   {
  @JsonProperty("@note_id")
  private String noteId = null;

  @JsonProperty("@text")
  private String text = null;

  public Note noteId(String noteId) {
    this.noteId = noteId;
    return this;
  }

   /**
   * Note ID
   * @return noteId
  **/
  @ApiModelProperty(value = "Note ID")
  public String getNoteId() {
    return noteId;
  }

  public void setNoteId(String noteId) {
    this.noteId = noteId;
  }

  public Note text(String text) {
    this.text = text;
    return this;
  }

   /**
   * Comments
   * @return text
  **/
  @ApiModelProperty(value = "Comments")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Note note = (Note) o;
    return Objects.equals(this.noteId, note.noteId) &&
        Objects.equals(this.text, note.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noteId, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Note {\n");

    sb.append("    noteId: ").append(toIndentedString(noteId)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

