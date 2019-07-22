package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Books;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksDao {

  private Connection connection;

  private static final String SQL_INSERT = "INSERT INTO books (title) VALUES (?);";
  private static final String SQL_SELECT_BY_ID = "SELECT id, title FROM books WHERE id = ?";
  private static final String SQL_SELECT_BY_NAME = "SELECT id, title FROM books WHERE title = ?";
  private static final String SQL_SELECT_ALL = "SELECT * FROM books";
  private static final String SQL_DELETE = "DELETE FROM books WHERE id = ?;";
  private static final String SQL_UPDATE = "UPDATE books SET title = ? WHERE id = ?;";

  public BooksDao() {
    connection = Connector.getConnection();
  }

  public void insert(String title) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
      preparedStatement.setString(1, title);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Books selectById(int id) {
    Books book = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int authorId = resultSet.getInt(1);
        String authorName = resultSet.getString(2);
        book = new Books(authorId, authorName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return book;
  }

  public Books selectByTitle(String title) {
    Books book = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME);
      preparedStatement.setString(1, title);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int bookId = resultSet.getInt(1);
        String bookName = resultSet.getString(2);
        book = new Books(bookId, bookName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return book;
  }

  public List<Books> selectAll() {
    List<Books> books = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int bookId = resultSet.getInt(1);
        String bookName = resultSet.getString(2);
        books.add(new Books(bookId, bookName));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return books;
  }

  public boolean delete(int id) {
    boolean deleted = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
      preparedStatement.setInt(1, id);
      deleted = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return deleted;
  }

  public boolean update(int id, String title) {
    boolean updated = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
      preparedStatement.setString(1, title);
      preparedStatement.setInt(2, id);
      updated = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }
}
