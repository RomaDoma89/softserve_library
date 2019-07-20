package com.softserve.team2.library.dto;

import java.time.LocalDate;
import java.util.List;

public class ReaderDto {
    public static double averageTimeOfUsing;
    public static double averageAgeOfReaders;

    private String name;
    private String author;
    private long dayOfUsingLibrary;
    private LocalDate localDate;

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
        return "ReaderDto{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", dayOfUsingLibrary=" + dayOfUsingLibrary +
                ", localDate=" + localDate +
                ", listOfReaderBooks=" + listOfReaderBooks +
                ", listOfNotReturnedBooks=" + listOfNotReturnedBooks +
                '}';
    }
}

