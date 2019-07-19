package com.softserve.team2.library.entities;

public class Author {
  private int id;
  private int name;

  public Author() {}

  public Author(int id, int name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
