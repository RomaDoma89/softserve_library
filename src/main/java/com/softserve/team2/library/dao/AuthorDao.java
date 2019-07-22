package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Author;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

  private Connection connection;

  private static final String SQL_INSERT = "INSERT INTO authors (name) VALUES (?);";
  private static final String SQL_SELECT_BY_ID = "SELECT id , name FROM authors where id = ?";
  private static final String SQL_SELECT_BY_NAME = "SELECT id , name FROM authors where name = ?";
  private static final String SQL_SELECT_ALL = "SELECT * FROM authors";
  private static final String SQL_DELETE = "DELETE FROM authors WHERE id = ?;";
  private static final String SQL_UPDATE = "UPDATE authors SET name = ? WHERE id = ?;";

  public AuthorDao() {
    connection = Connector.getConnection();
  }

  public void insert(String name) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
      preparedStatement.setString(1, name);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Author selectById(int id) {
    Author author = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int authorId = resultSet.getInt(1);
        String authorName = resultSet.getString(2);
        author = new Author(authorId, authorName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return author;
  }

  public Author selectByName(String name) {
    Author author = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME);
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int authorId = resultSet.getInt(1);
        String authorName = resultSet.getString(2);
        author = new Author(authorId, authorName);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return author;
  }

  public List<Author> selectAll() {
    List<Author> authors = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int authorId = resultSet.getInt(1);
        String authorName = resultSet.getString(2);
        authors.add(new Author(authorId, authorName));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return authors;
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

  public boolean update(Author author) {
    boolean updated = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
      preparedStatement.setString(1, author.getName());
      preparedStatement.setInt(2, author.getId());
      updated = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }
}
