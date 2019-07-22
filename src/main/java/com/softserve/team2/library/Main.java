package com.softserve.team2.library;

import com.softserve.team2.library.services.BookService;
import com.softserve.team2.library.services.ReaderServices;

public class Main {
  public static void main(String[] args) {
      ReaderServices readerServices = new ReaderServices();
    System.out.println(readerServices.getBlackList());
  }
}
