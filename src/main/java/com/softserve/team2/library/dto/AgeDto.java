package com.softserve.team2.library.dto;

/**
 * The DTO class provides an information about an average age of readers who read a particular book
 * or author.
 */
public class AgeDto {

  private int avgAge;
  private String bookTitle;
  private String authorName;

  public AgeDto() {}

  public int getAvgAge() {
    return avgAge;
  }

  public void setAvgAge(int avgAge) {
    this.avgAge = avgAge;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  @Override
  public String toString() {
    return "AgeDto{"
        + "avgAge="
        + avgAge
        + ", bookTitle='"
        + bookTitle
        + '\''
        + ", authorName='"
        + authorName
        + '\''
        + '}';
  }
}
