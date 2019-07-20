package com.softserve.team2.library.dto;

public class BookDto {
  private int id;
  private int idCopy;
  private String title;
  private int available;
  private int count;
  private String author;
  private double avgOfReading;

  public int getIdCopy() {
    return idCopy;
  }

  public double getAvgOfReading() {
    return avgOfReading;
  }

  public void setAvgOfReading(double avgOfReading) {
    this.avgOfReading = avgOfReading;
  }

  public void setIdCopy(int idCopy) {
    this.idCopy = idCopy;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getAvailable() {
    return available;
  }

  public void setAvailable(int available) {
    this.available = available;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {

    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "BookDto{"
        + "id="
        + id
        + ", idCopy="
        + idCopy
        + ", title='"
        + title
        + '\''
        + ", available="
        + available
        + ", count="
        + count
        + ", author='"
        + author
        + '\''
        + ", avgOfReading="
        + avgOfReading
        + '}';
  }
}


