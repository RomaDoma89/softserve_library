package com.softserve.team2.library.entities;

import java.util.Date;

public class ReaderStory {
  private int id;
  private int idReader;
  private int idBook;
  private int IdBookCopy;
  private Date timeTake;
  private Date timeReturn;

  public ReaderStory() {}

  public ReaderStory(
      int id, int idReader, int idBook, int idBookCopy, Date timeTake, Date timeReturn) {
    this.id = id;
    this.idReader = idReader;
    this.idBook = idBook;
    IdBookCopy = idBookCopy;
    this.timeTake = timeTake;
    this.timeReturn = timeReturn;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdReader() {
    return idReader;
  }

  public void setIdReader(int idReader) {
    this.idReader = idReader;
  }

  public int getIdBook() {
    return idBook;
  }

  public void setIdBook(int idBook) {
    this.idBook = idBook;
  }

  public int getIdBookCopy() {
    return IdBookCopy;
  }

  public void setIdBookCopy(int idBookCopy) {
    IdBookCopy = idBookCopy;
  }

  public Date getTimeTake() {
    return timeTake;
  }

  public void setTimeTake(Date timeTake) {
    this.timeTake = timeTake;
  }

  public Date getTimeReturn() {
    return timeReturn;
  }

  public void setTimeReturn(Date timeReturn) {
    this.timeReturn = timeReturn;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
