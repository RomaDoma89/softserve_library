package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.BooksAuthors;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksAuthorsDao {

  private Connection connection;

  private static final String SQL_INSERT =
      "INSERT INTO book_authors (id_book, id_author) VALUES (?, ?);";
  private static final String SQL_SELECT_BY_BOOK_ID =
      "SELECT id_book, id_author  FROM book_authors WHERE id_book = ?";
  private static final String SQL_SELECT_BY_AUTHOR_ID =
      "SELECT id_book, id_author FROM book_authors WHERE id_author = ?";
  private static final String SQL_SELECT_ALL = "SELECT * FROM book_authors";
  private static final String SQL_DELETE =
      "DELETE FROM book_authors WHERE id_book = ? AND id_author = ?;";

  public BooksAuthorsDao() {
    connection = Connector.getConnection();
  }

  public void insert(int idBook, int idAuthor) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
      preparedStatement.setInt(1, idBook);
      preparedStatement.setInt(2, idAuthor);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<BooksAuthors> selectByIdBook(int idBook) {
    List<BooksAuthors> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_BOOK_ID);
      preparedStatement.setInt(1, idBook);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        list.add(new BooksAuthors(resultSet.getInt(1), resultSet.getInt(2)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public List<BooksAuthors> selectByIdAuthor(int idAuthor) {
    List<BooksAuthors> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_AUTHOR_ID);
      preparedStatement.setInt(1, idAuthor);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        list.add(new BooksAuthors(resultSet.getInt(1), resultSet.getInt(2)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public List<BooksAuthors> selectAll() {
    List<BooksAuthors> list = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        list.add(new BooksAuthors(resultSet.getInt(1), resultSet.getInt(2)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }

  public boolean delete(int id_book, int id_author) {
    boolean deleted = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
      preparedStatement.setInt(1, id_book);
      preparedStatement.setInt(2, id_author);
      deleted = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return deleted;
  }
}
