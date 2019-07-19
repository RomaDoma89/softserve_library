package com.softserve.team2.library.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for create connection with DB.
 *
 * @author Marian Milian
 * @version 1.0
 */
public class Connector {
    private static final String DB_LINK = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "library";
    //todo  change name & password of your workbench
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345milan";
    private static Connection connection;

    /**
     * Method for creating connection with mysql DB.
     *
     * @return connection with DB
     * @throws ClassNotFoundException - java can`t find Driver.
     * @throws SQLException           - error in sql query.
     */
    public static Connection getConnection()  {
        if (connection == null) {
            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        DB_LINK + DB_NAME +"?serverTimezone=UTC", DB_USER, DB_PASSWORD);

            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }

        }
        return connection;
    }

}
