package com.softserve.team2.library;

import com.softserve.team2.library.entities.Author;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorP {

    private  Connection connection;

    public AuthorP() {
        connection = Connector.getConnection();
    }

    public void insertAuthor (Author author){
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("INSERT INTO library.authors (id, name)  VALUE (?,?)");
            preparedStatement.setInt(1,author.getId());

            preparedStatement.setString(2,author.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Я тут");
            e.printStackTrace();
        }
    }
}
