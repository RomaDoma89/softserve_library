package com.softserve.team2.library.entities;

public class Reader {

  private int id;
  private String name;
  private String birthday;

  public Reader() {}

  public Reader(int id, String name, String birthday) {
    this.id = id;
    this.name = name;
    this.birthday = birthday;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "Reader{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", birthday='"
        + birthday
        + '\''
        + '}';
  }
}
