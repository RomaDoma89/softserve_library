package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookService {
    private Connection connection;
//    private boolean available;

    public BookService() {
        connection = Connector.getConnection();

    }

    public BookDto findByTitle(String title) {

        BookDto bookDto = new BookDto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(available) " +
                    "from library.book_copies " +
                    "JOIN library.books" +
                    " ON books.id = book_copies.id_book " +
                    "WHERE title =?");
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bookDto.setAvailable(resultSet.getInt("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookDto;
    }
}
