package com.softserve.team2.library.dto;

import java.time.LocalDate;
import java.util.List;

public class ReaderDto {
  public static double averageTimeOfUsing;
  public static double averageAgeOfReaders;
  private int user_id;
  private String name;
  private String author;
  private String title;
  private int avgAge;
  private String dateOfBirthday;
  private long dayOfUsingLibrary;
  private LocalDate localDate;

  public static double getAverageTimeOfUsing() {
    return averageTimeOfUsing;
  }

  public static void setAverageTimeOfUsing(double averageTimeOfUsing) {
    ReaderDto.averageTimeOfUsing = averageTimeOfUsing;
  }

  public static double getAverageAgeOfReaders() {
    return averageAgeOfReaders;
  }

  public static void setAverageAgeOfReaders(double averageAgeOfReaders) {
    ReaderDto.averageAgeOfReaders = averageAgeOfReaders;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getDateOfBirthday() {
    return dateOfBirthday;
  }

  public void setDateOfBirthday(String dateOfBirthday) {
    this.dateOfBirthday = dateOfBirthday;
  }

  private List<String> listOfReaderBooks;
  private List<String> listOfNotReturnedBooks;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getAvgAge() {
    return avgAge;
  }

  public void setAvgAge(int avgAge) {
    this.avgAge = avgAge;
  }

  public long getDayOfUsingLibrary() {
    return dayOfUsingLibrary;
  }

  public void setDayOfUsingLibrary(long dayOfUsingLibrary) {
    this.dayOfUsingLibrary = dayOfUsingLibrary;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public List<String> getListOfReaderBooks() {
    return listOfReaderBooks;
  }

  public void setListOfReaderBooks(List<String> listOfReaderBooks) {
    this.listOfReaderBooks = listOfReaderBooks;
  }

  public List<String> getListOfNotReturnedBooks() {
    return listOfNotReturnedBooks;
  }

  public void setListOfNotReturnedBooks(List<String> listOfNotReturnedBooks) {
    this.listOfNotReturnedBooks = listOfNotReturnedBooks;
  }

  @Override
  public String toString() {
    return "ReaderDto{"
        + "user_id="
        + user_id
        + ", name='"
        + name
        + ", author='"
        + author
        + ", title='"
        + title
        + ", avgAge="
        + avgAge
        + ", dateOfBirthday='"
        + dateOfBirthday
        + ", dayOfUsingLibrary="
        + dayOfUsingLibrary
        + ", localDate="
        + localDate
        + ", listOfReaderBooks="
        + listOfReaderBooks
        + ", listOfNotReturnedBooks="
        + listOfNotReturnedBooks
        + '}';
  }
}
