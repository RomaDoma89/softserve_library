package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

/** */
public class BookService {
  private Connection connection;

  /**  */
  public BookService() {
    connection = Connector.getConnection();
  }

  /**
   * @param title
   * @return
   */
  public BookDto findAverageReadingBook(String title) {
    String query =
        "SELECT library.reader_story.time_take, library.reader_story.time_return FROM library.reader_story\n"
            + "\tJOIN library.books ON library.books.id = library.reader_story.id_book\n"
            + "WHERE title = ? AND time_return IS NOT NULL;";
    BookDto bookDto = new BookDto();
    ArrayList<Long> avg = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, title);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate firstLocalDate = formatter.parse(resultSet.getString(1), LocalDate::from);
        LocalDate secondLocalDate = formatter.parse(resultSet.getString(2), LocalDate::from);
        avg.add(DAYS.between(firstLocalDate, secondLocalDate));
      }
      bookDto.setAvgOfReading(avg.stream().mapToLong(a -> a).average().getAsDouble());
    } catch (SQLException | NoSuchElementException e) {
      e.printStackTrace();
    }
    return bookDto;
  }

  public BookDto findPopular(String firstDate, String secondDate) {
    String firstQuery =
        "SELECT library.reader_story.id_book, COUNT(library.reader_story.time_take) FROM library.reader_story \n"
            + "\tWHERE time_take BETWEEN ? AND ?\n"
            + "    GROUP BY library.reader_story.id_book;";

    String secondQuery = "SELECT library.books.title from library.books WHERE id = ?;";
    BookDto bookDto = new BookDto();
    ArrayList<BookDto> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(firstQuery);
      preparedStatement.setString(1, firstDate);
      preparedStatement.setString(2, secondDate);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        BookDto element = new BookDto();
        element.setId(resultSet.getInt(1));
        element.setCount(resultSet.getInt(2));
        list.add(element);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(secondQuery);
      BookDto max = Collections.max(list, Comparator.comparing(BookDto::getCount));
      preparedStatement.setInt(1, max.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        bookDto.setTitle(resultSet.getString(1));
      }
    } catch (SQLException | NoSuchElementException e) {
      e.printStackTrace();
    }

    return bookDto;
  }

  public BookDto findNotPopular(String firstDate, String secondDate) {
    String firstQuery =
        "SELECT library.reader_story.id_book, COUNT(library.reader_story.time_take) FROM library.reader_story \n"
            + "\tWHERE time_take BETWEEN ? AND ?\n"
            + "GROUP BY library.reader_story.id_book;";

    String secondQuery = "SELECT library.books.title from library.books WHERE id = ?;";
    BookDto bookDto = new BookDto();
    ArrayList<BookDto> list = new ArrayList<>();
    try {
      PreparedStatement secondPreparedStatement = connection.prepareStatement(firstQuery);
      secondPreparedStatement.setString(1, firstDate);
      secondPreparedStatement.setString(2, secondDate);
      ResultSet secondResultSet = secondPreparedStatement.executeQuery();
      while (secondResultSet.next()) {
        BookDto element = new BookDto();
        element.setId(secondResultSet.getInt(1));
        element.setCount(secondResultSet.getInt(2));
        list.add(element);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(secondQuery);
      BookDto min = Collections.min(list, Comparator.comparing(BookDto::getCount));
      preparedStatement.setInt(1, min.getId());
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        bookDto.setTitle(resultSet.getString(1));
      }
    } catch (SQLException | NoSuchElementException e) {
      e.printStackTrace();
    }

    return bookDto;
  }

  public BookDto findUsingTotal(String title) {
    String query =
        "SELECT COUNT(library.reader_story.id_book) "
            + "FROM library.reader_story JOIN library.books ON library.books.id = library.reader_story.id_book "
            + "WHERE  title = ?;";
    BookDto bookDto = new BookDto();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, title);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        bookDto.setCount(resultSet.getInt("COUNT(library.reader_story.id_book)"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bookDto;
  }

  public List<BookDto> findUsingByCopies(String title) {
    String query =
        "SELECT library.reader_story.id_book_copy, COUNT(library.reader_story.id_book_copy) from library.reader_story\n"
            + "JOIN library.books ON library.books.id = library.reader_story.id_book\n"
            + "WHERE library.books.title = ? \n"
            + "GROUP BY library.reader_story.id_book_copy;";
    List<BookDto> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, title);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        BookDto bookDto = new BookDto();
        bookDto.setCount(resultSet.getInt("COUNT(library.reader_story.id_book_copy)"));
        bookDto.setIdCopy(resultSet.getInt("reader_story.id_book_copy"));
        list.add(bookDto);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public BookDto findByPeriod(String firstDate, String secondDate) {
    String query =
        "SELECT COUNT(library.reader_story.id) "
            + "FROM library.books JOIN library.reader_story ON library.books.id = library.reader_story.id_book "
            + "WHERE time_take BETWEEN ? AND ?;";
    BookDto bookDto = new BookDto();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(query);

      preparedStatement.setDate(1, java.sql.Date.valueOf(firstDate));
      preparedStatement.setDate(2, java.sql.Date.valueOf(secondDate));
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        bookDto.setCount(resultSet.getInt("COUNT(library.reader_story.id)"));
      }
    } catch (SQLException | IllegalArgumentException e) {
      e.printStackTrace();
    }
    return bookDto;
  }
  // 1\
  /**
   * Checks and return one of a specified book and show how many available.
   *
   * @param title of a book for searching.
   * @return a bookDto contained the book title and quantity of available  .
   */
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
  /**
   * Checks and return one of a specified book.
   *
   * @param author of a book for searching.
   * @return a bookDto contained the title, name of a author .
   */
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
