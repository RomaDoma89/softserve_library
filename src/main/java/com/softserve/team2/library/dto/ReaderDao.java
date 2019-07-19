package com.softserve.team2.library.dto;

import java.util.List;

public class ReaderDao {
 private String name;
 private String date;
 private List<String> listOfreadedBooks;
 private List<String> listOfNotReturnedBooks;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getDate() {
  return date;
 }

 public void setDate(String date) {
  this.date = date;
 }

 public List<String> getListOfreadedBooks() {
  return listOfreadedBooks;
 }

 public void setListOfreadedBooks(List<String> listOfreadedBooks) {
  this.listOfreadedBooks = listOfreadedBooks;
 }

 public List<String> getListOfNotReturnedBooks() {
  return listOfNotReturnedBooks;
 }

 public void setListOfNotReturnedBooks(List<String> listOfNotReturnedBooks) {
  this.listOfNotReturnedBooks = listOfNotReturnedBooks;
 }

 @Override
 public String toString() {
  return "ReaderDao{" +
          "name='" + name + '\'' +
          ", date='" + date + '\'' +
          ", listOfreadedBooks=" + listOfreadedBooks +
          ", listOfNotReturnedBooks=" + listOfNotReturnedBooks +
          '}';
 }
}

