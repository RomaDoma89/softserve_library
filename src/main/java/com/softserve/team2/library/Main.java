package com.softserve.team2.library;

import com.softserve.team2.library.entities.Author;

public class Main {
  public static void main(String[] args) {
    System.out.println("just for start...");
    AuthorP authorP =new AuthorP();

    Author author =new Author();
    author.setId(16);

    author.setName("Mariann");
    authorP.insertAuthor(author);

  }
}
