package com.softserve.team2.library.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class for create connection with DB.
 *
 * @author Marian Milian
 * @version 1.0
 */
public class Connector {
  private static final String DB_LINK = "jdbc:mysql://localhost:3306/";
  private static final String DB_NAME = "library";
  private static final String DB_USER = "root";
//    private static final String DB_PASSWORD = "root";
  private static final String DB_PASSWORD = "1123581321";
  private static final String DB_TIME_ZONE = "?serverTimezone=UTC";
  private static Connection connection;

  /**
   * Method for creating connection with mysql DB.
   *
   * @return connection with DB
   */
  public static Connection getConnection() {
    if (connection == null) {
      try {
        Properties propObj = new Properties();
        propObj.setProperty("user", DB_USER);
        propObj.setProperty("password", DB_PASSWORD);
        String url = DB_LINK + DB_NAME + DB_TIME_ZONE;

        connection = DriverManager.getConnection(url, propObj);

      } catch (SQLException e) {
        System.out.println("Connection failed");
        e.printStackTrace();
      }
    }
    return connection;
  }
}
