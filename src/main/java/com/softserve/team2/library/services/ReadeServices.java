package com.softserve.team2.library.services;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.dto.ReaderDao;
import com.softserve.team2.library.entities.Author;
import com.softserve.team2.library.jdbc.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadeServices {
    private Connection connection;

    public ReadeServices() {
        connection = Connector.getConnection();
    }


    public ReaderDao statisticOfReader(String name) {
        ReaderDao readerDao = new ReaderDao();
        readerDao.setName(name);
        List<String> titles;
        try {
            titles = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT library.books.title\n" +
                    "FROM library.books\n" +
                    "JOIN library.reader_story ON library.books.id = library.reader_story.id_book\n" +
                    "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n" +
                    "WHERE name = ?;");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                titles.add(resultSet.getString("title"));

            }
            readerDao.setListOfreadedBooks(titles);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            titles = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT library.books.title\n" +
                    "FROM library.books\n" +
                    "JOIN library.reader_story ON library.books.id = library.reader_story.id_book\n" +
                    "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n" +
                    "WHERE name = ?\n" +
                    " AND time_return IS NULL;");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                titles.add(resultSet.getString("title"));

            }
            readerDao.setListOfNotReturnedBooks(titles);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT MIN(library.reader_story.time_take)as registration_day\n" +
                            "FROM library.reader_story\n" +
                            "JOIN library.readers ON library.readers.id = library.reader_story.id_reader\n" +
                            "WHERE name =?;");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                readerDao.setDate(resultSet.getString("registration_day"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return readerDao;
    }


}
