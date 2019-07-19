package com.softserve.team2.library.entities;

public class BooksAuthors {
  private int idBook;
  private int idAuthor;

  public BooksAuthors() {}

  public BooksAuthors(int idBook, int idAuthor) {
    this.idBook = idBook;
    this.idAuthor = idAuthor;
  }

  public int getIdBook() {
    return idBook;
  }

  public void setIdBook(int idBook) {
    this.idBook = idBook;
  }

  public int getIdAuthor() {
    return idAuthor;
  }

  public void setIdAuthor(int idAuthor) {
    this.idAuthor = idAuthor;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
