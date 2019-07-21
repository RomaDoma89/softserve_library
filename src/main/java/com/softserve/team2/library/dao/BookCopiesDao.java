package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.BookCopies;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCopiesDao {

  private Connection connection;

  private static final String SQL_INSERT =
      "INSERT INTO book_copies (id_copy, id_book, available) VALUES (?, ?, ?);";
  private static final String SQL_SELECT_BY_ID =
      "SELECT id_copy, id_book, available FROM book_copies WHERE id_copy = ? AND id_book = ?;";
  private static final String SQL_SELECT_ALL = "SELECT * FROM book_copies";
  private static final String SQL_DELETE = "DELETE FROM book_copies WHERE id_copy = ? AND id_book = ?;";



  private static final String SQL_UPDATE = "UPDATE book_copies SET available = ? WHERE id_copy = ? AND id_book = ?;";

  public BookCopiesDao() {
    connection = Connector.getConnection();
  }

  public void insert(int idCopy, int idBook, boolean available) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
      preparedStatement.setInt(1, idCopy);
      preparedStatement.setInt(2, idBook);
      preparedStatement.setBoolean(3, available);
      preparedStatement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public BookCopies select(int idCopy, int idBook) {
    BookCopies copy = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
      preparedStatement.setInt(1, idCopy);
      preparedStatement.setInt(2, idBook);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int idC = resultSet.getInt(1);
        int idB = resultSet.getInt(2);
        boolean avail = resultSet.getBoolean(3);
        copy = new BookCopies(idC, idB, avail);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return copy;
  }

  public List<BookCopies> selectAll() {
    List<BookCopies> copies = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int idC = resultSet.getInt(1);
        int idB = resultSet.getInt(2);
        boolean avail = resultSet.getBoolean(3);
        copies.add(new BookCopies(idC, idB, avail));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return copies;
  }

  public boolean delete(int idCopy, int idBook) {
    boolean deleted = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
      preparedStatement.setInt(1, idCopy);
      preparedStatement.setInt(1, idBook);
      deleted = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return deleted;
  }

  public boolean update(int idCopy, int idBook, boolean available) {
    boolean updated = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
      preparedStatement.setInt(1, idCopy);
      preparedStatement.setInt(2, idBook);
      preparedStatement.setBoolean(3, available);
      updated = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }
}
