package com.softserve.team2.library.dao;

import com.softserve.team2.library.entities.ReaderStory;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReaderStoryDao {

  private Connection connection;

  private static final String SQL_INSERT =
      "INSERT INTO reader_story (id_reader, id_book, id_book_copy, time_take) VALUES (?, ?, ?, ?);";
  private static final String SQL_SELECT_BY_ID =
      "SELECT id, id_reader, id_book, id_book_copy, time_take, time_return FROM reader_story WHERE id = ?";
  private static final String SQL_SELECT_ALL = "SELECT * FROM reader_story";
  private static final String SQL_DELETE = "DELETE FROM reader_story WHERE id = ?;";
  private static final String SQL_UPDATE = "UPDATE reader_story SET time_return = ? WHERE id = ?;";

  public ReaderStoryDao() {
    connection = Connector.getConnection();
  }

  public void insert(int readerId, int bookId, int copyId, String timeTake) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
      preparedStatement.setInt(1, readerId);
      preparedStatement.setInt(1, bookId);
      preparedStatement.setInt(1, copyId);
      preparedStatement.setString(1, timeTake);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public ReaderStory selectById(int id) {
    ReaderStory story = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
      preparedStatement.setInt(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        int sId = resultSet.getInt(1);
        int sReaderId = resultSet.getInt(2);
        int sBookId = resultSet.getInt(3);
        int sCopyId = resultSet.getInt(4);
        String sTake = resultSet.getString(5);
        String sReturn = resultSet.getString(6);
        story = new ReaderStory(sId, sReaderId, sBookId, sCopyId, sTake, sReturn);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return story;
  }

  public List<ReaderStory> selectAll() {
    List<ReaderStory> stories = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int sId = resultSet.getInt(1);
        int sReaderId = resultSet.getInt(2);
        int sBookId = resultSet.getInt(3);
        int sCopyId = resultSet.getInt(4);
        String sTake = resultSet.getString(5);
        String sReturn = resultSet.getString(6);
        stories.add(new ReaderStory(sId, sReaderId, sBookId, sCopyId, sTake, sReturn));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return stories;
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

  public boolean update(int id) {
    boolean updated = false;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
      preparedStatement.setInt(1, id);
      updated = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return updated;
  }
}
