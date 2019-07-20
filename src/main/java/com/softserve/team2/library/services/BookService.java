package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
  private Connection connection;
  //    private boolean available;

  public BookService() {
    connection = Connector.getConnection();
  }

  // 1
  public BookDto findBookByTitle(String title) {

    BookDto bookDto = new BookDto();
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "SELECT COUNT(library.book_copies.available)as available "
                  + "FROM library.book_copies "
                  + "JOIN library.books"
                  + " ON library.books.id = library.book_copies.id_book "
                  + "WHERE title =?");
      preparedStatement.setString(1, title);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        //                int i=resultSet.getInt("available");
        //                System.out.println(i);
        bookDto.setTitle(title);
        bookDto.setAvailable(resultSet.getInt("available"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bookDto;
  }

  // 2
  public List<BookDto> findBooksByAuthor(String author) {
    BookDto bookDto;
    List<BookDto> listBooksDto = new ArrayList<>();
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              ""
                  + "SELECT library.books.title as title"
                  + " FROM library.books\n"
                  + "\tJOIN library.book_authors ON books.id = book_authors.id_book\n"
                  + "    JOIN library.authors ON authors.id = book_authors.id_author\n"
                  + "    WHERE name =?");

      preparedStatement.setString(1, author);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        bookDto = new BookDto();
        bookDto.setAuthor(author);
        bookDto.setTitle(resultSet.getString("title"));
        listBooksDto.add(bookDto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listBooksDto;
  }

  /**
   * Checks and return all copies of a specified book with their availability.
   *
   * @param title of a book for searching.
   * @return a list of BookDto contained the title, id of a copy and it's availability.
   */
  public List<BookDto> findCopiesAvailabilityByTitle(String title) {
    BookDto bookCopy;
    List<BookDto> listBooksDto = new ArrayList<>();

    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "SELECT id_copy, available from book_copies\n"
                  + "JOIN books ON books.id = book_copies.id_book\n"
                  + "WHERE books.title = ?");

      preparedStatement.setString(1, title);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        bookCopy = new BookDto();
        bookCopy.setTitle(title);
        bookCopy.setIdCopy(resultSet.getInt("id_copy"));
        bookCopy.setAvailable(resultSet.getInt("available"));
        listBooksDto.add(bookCopy);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return listBooksDto;
  }
}
