package com.softserve.team2.library;

public class Main {
  public static void main(String[] args) {
    System.out.println("just for start...");
    AuthorP authorP =new AuthorP();

    AuthorDAO authorDAO =new AuthorDAO();
    authorDAO.setId(15);

    authorDAO.setName("Marian");
    authorP.insertAuthor(authorDAO);

  }
}
