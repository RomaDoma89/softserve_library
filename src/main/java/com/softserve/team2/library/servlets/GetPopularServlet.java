package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetPopularServlet", value = "/getPopularServlet")
public class GetPopularServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String firstDate = request.getParameter("date1");
    String secondDate = request.getParameter("date2");

        BookService bookService = new BookService();
        BookDto bookDto = bookService.findPopular(firstDate,secondDate);
        String nameOfBook = bookDto.getTitle();
        bookDto = bookService.findNotPopular(firstDate,secondDate);
        request.setAttribute("popular", nameOfBook);
        request.setAttribute("notPopular", bookDto.getTitle());
        getServletContext().getRequestDispatcher("/getPopular").forward(request,response);

    }
}
