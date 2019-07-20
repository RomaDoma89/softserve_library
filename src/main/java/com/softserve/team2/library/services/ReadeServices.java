package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.ReaderDto;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ReadeServices {
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private Connection connection;

  public ReadeServices() {
    connection = Connector.getConnection();
  }

  public List<ReaderDto> getBlackList() {
    String quary =
        "SELECT library.readers.id, library.readers.name, library.readers.birthday FROM library.readers\n"
            + "\tJOIN library.reader_story ON library.readers.id = library.reader_story.id_reader\n"
            + "    WHERE time_return IS NULL\n"
            + "    GROUP BY library.readers.id;";
    List<ReaderDto> list = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(quary);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        ReaderDto readerDto = new ReaderDto();
        readerDto.setUser_id(resultSet.getInt(1));
        readerDto.setName(resultSet.getString(2));
        readerDto.setDateOfBirthday(resultSet.getString(3));
        list.add(readerDto);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public ReaderDto statisticOfReader(String name) {
    ReaderDto readerDto = new ReaderDto();
    readerDto.setName(name);
    List<String> titles;
    try {
      titles = new ArrayList<>();
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "SELECT library.books.title\n"
                  + "FROM library.books\n"
                  + "JOIN library.reader_story ON library.books.id = library.reader_story.id_book\n"
                  + "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n"
                  + "WHERE name = ?;");
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        titles.add(resultSet.getString("title"));
      }
      readerDto.setListOfReaderBooks(titles);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      titles = new ArrayList<>();
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "SELECT library.books.title\n"
                  + "FROM library.books\n"
                  + "JOIN library.reader_story ON library.books.id = library.reader_story.id_book\n"
                  + "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n"
                  + "WHERE name = ?\n"
                  + " AND time_return IS NULL;");
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        titles.add(resultSet.getString("title"));
      }
      readerDto.setListOfNotReturnedBooks(titles);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {

      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "SELECT MIN(library.reader_story.time_take)as registration_day\n"
                  + "FROM library.reader_story\n"
                  + "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n"
                  + "WHERE name =?;");
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        readerDto.setLocalDate(LocalDate.parse(resultSet.getString("registration_day"), formatter));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return readerDto;
  }

  // 8
  public List<ReaderDto> fullStatisticsOfReaders(String dateFrom, String dateTo) {
    ReaderDto readerDto;
    List<ReaderDto> listReadersDto = new ArrayList<>();

    LocalDate localDateNow = LocalDate.now();
    LocalDate timeOfUsingLibrary;
    try {

      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "SELECT library.readers.name, MIN(library.reader_story.time_take) as registration_time "
                  + "FROM library.reader_story\n"
                  + "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n"
                  + "GROUP BY library.readers.id;");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        readerDto = new ReaderDto();
        readerDto.setName(resultSet.getString("name"));
        readerDto.setDayOfUsingLibrary(
            ChronoUnit.DAYS.between(
                LocalDate.parse(resultSet.getString("registration_time"), formatter),
                localDateNow));
        listReadersDto.add(readerDto);
      }

      preparedStatement =
          connection.prepareStatement(
              "SELECT AVG(YEAR(NOW()) - YEAR(library.readers.birthday)) as avg_age FROM library.readers;");
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        ReaderDto.averageAgeOfReaders = resultSet.getDouble("avg_age");
      }
      preparedStatement =
          connection.prepareStatement(
              "SELECT AVG(counter.take_count) "
                  + "FROM\n"
                  + "(SELECT COUNT(library.reader_story.time_take) as take_count FROM library.reader_story\n"
                  + "WHERE library.reader_story.time_take "
                  + "BETWEEN ? AND ? \n"
                  + "GROUP BY library.reader_story.id_reader)"
                  + "AS counter;");
      preparedStatement.setString(1, dateFrom);
      preparedStatement.setString(2, dateTo);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        ReaderDto.averageTimeOfUsing = resultSet.getInt(1);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listReadersDto;
  }

  /**
   * Finds an average age of readers of the specify book's title.
   *
   * @param title of a book for searching.
   * @return ReaderDto object contained average age of readers and the title of the book.
   */
  public ReaderDto getAvgAgeByBook(String title) {

    ReaderDto ageDto = new ReaderDto();
    ageDto.setTitle(title);

    try {
      PreparedStatement preparedStatement =
              connection.prepareStatement(
                      "SELECT AVG(YEAR(NOW()) - YEAR(readers.birthday)) as avg_age FROM readers "
                              + "JOIN reader_story ON readers.id = reader_story.id_reader "
                              + "JOIN books ON books.id = reader_story.id_book "
                              + "WHERE books.title = ?");

      preparedStatement.setString(1, title);

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {

        int avgAge = resultSet.getInt("avg_age");
        ageDto.setAvgAge(avgAge);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ageDto;
  }

  /**
   * Finds an average age of readers of the specify author's name.
   *
   * @param name of an author for searching.
   * @return ReaderDto object contained average age of readers and the name of the author.
   */
  public ReaderDto getAvgAgeByAuthor(String name) {

    ReaderDto readerDto = new ReaderDto();
    readerDto.setAuthor(name);

    try {
      PreparedStatement preparedStatement =
              connection.prepareStatement(
                      "SELECT AVG(YEAR(NOW()) - YEAR(readers.birthday)) as avg_age FROM readers "
                              + "JOIN reader_story ON readers.id = reader_story.id_reader "
                              + "JOIN book_authors ON book_authors.id_book = reader_story.id_book "
                              + "JOIN authors ON authors.id = book_authors.id_author "
                              + "WHERE authors.name = ?;");
      preparedStatement.setString(1, name);

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {

        int avgAge = resultSet.getInt("avg_age");
        readerDto.setAvgAge(avgAge);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return readerDto;
  }
}
