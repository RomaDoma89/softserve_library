package com.softserve.team2.library.entities;

public class BookCopies {
  private int idCopy;
  private int idBook;
  private boolean isAvailable;

  public BookCopies() {}

  public BookCopies(int idCopy, int idBook, boolean isAvailable) {
    this.idCopy = idCopy;
    this.idBook = idBook;
    this.isAvailable = isAvailable;
  }

  public int getIdCopy() {
    return idCopy;
  }

  public void setIdCopy(int idCopy) {
    this.idCopy = idCopy;
  }

  public int getIdBook() {
    return idBook;
  }

  public void setIdBook(int idBook) {
    this.idBook = idBook;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
