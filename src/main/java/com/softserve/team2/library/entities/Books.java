package com.softserve.team2.library.entities;

public class Books {
  private int id;
  private String title;

  public Books() {}

  public int getId() {
    return id;
  }

  public Books(int id, String title) {
    this.id = id;
    this.title = title;
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
    return "Books{" + "id=" + id + ", title='" + title + '\'' + '}';
  }
}
