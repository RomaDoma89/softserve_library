package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.Reader;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDao {

  private Connection connection;

  private static final String SQL_INSERT = "INSERT INTO readers (name, birthday) VALUES (?, ?);";
  private static final String SQL_SELECT_BY_ID =
      "SELECT id, name, birthday FROM readers WHERE id = ?";
  private static final String SQL_SELECT_BY_NAME =
      "SELECT id, name, birthday FROM readers WHERE name = ?";
  private static final String SQL_SELECT_ALL = "SELECT * FROM readers";
  private static final String SQL_UPDATE =
      "UPDATE readers SET name = ?, birthday = ? WHERE id = ?;";
  private static final String SQL_DELETE = "DELETE FROM readers WHERE id = ?;";

  public ReaderDao() {
    connection = Connector.getConnection();
  }

  public void insert(String name, String birthday) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, birthday);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public Reader selectById(int id) {
    Reader reader = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int rId = resultSet.getInt(1);
        String rName = resultSet.getString(2);
        String rBDay = resultSet.getString(3);
        reader = new Reader(rId, rName, rBDay);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return reader;
  }

  public Reader selectByName(String name) {
    Reader reader = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME);
      preparedStatement.setString(1, name);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int rId = resultSet.getInt(1);
        String rName = resultSet.getString(2);
        String rBDay = resultSet.getString(3);
        reader = new Reader(rId, rName, rBDay);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return reader;
  }

  public List<Reader> selectAll() {
    List<Reader> readers = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int rId = resultSet.getInt(1);
        String rName = resultSet.getString(2);
        String rBDay = resultSet.getString(3);
        readers.add(new Reader(rId, rName, rBDay));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return readers;
  }

  public boolean update(Reader reader) {
    boolean updated = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
      preparedStatement.setString(1, reader.getName());
      preparedStatement.setString(2, reader.getBirthday());
      preparedStatement.setInt(3, reader.getId());
      updated = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
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
}
