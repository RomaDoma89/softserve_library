package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.AgeDto;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class provides methods for obtaining information from the DB about the average age of readers
 * who read a particular book or author.
 *
 * @author Roma Zhahorui
 * @version 1.0
 */
public class AgeService {

  /** The name of the result table column which provides average age of readers */
  private static final String AVG_AGE = "avg_age";

  /** @see java.sql.Connection */
  private Connection connection;

  /** The constructor initializes the <code>connection</code> variable */
  public AgeService() {
    connection = Connector.getConnection();
  }

  /**
   * Finds an average age of readers of the specify book's title.
   *
   * @param title of a book for searching.
   * @return AgeDto object contained average age of readers and the title of the book.
   */
  public AgeDto getAvgAgeByBook(String title) {

    AgeDto ageDto = new AgeDto();
    ageDto.setBookTitle(title);

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

        int avgAge = resultSet.getInt(AVG_AGE);
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
   * @return AgeDto object contained average age of readers and the name of the author.
   */
  public AgeDto getAvgAgeByAuthor(String name) {

    AgeDto ageDto = new AgeDto();
    ageDto.setAuthorName(name);

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

        int avgAge = resultSet.getInt(AVG_AGE);
        ageDto.setAvgAge(avgAge);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ageDto;
  }
}
