package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookStatisticServlet", value = "/bookStatistic")
public class BookStatisticServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");
    BookService bookService = new BookService();

    BookDto bookDto = bookService.findUsingTotal(title);
    int countOfUsingBook = bookDto.getCount();
    bookDto = bookService.findAverageReadingBook(title);
    List<BookDto> list = bookService.findUsingByCopies(title);

    request.setAttribute("using", countOfUsingBook);
    request.setAttribute("avgReading", bookDto.getAvgOfReading());
    request.setAttribute("list", list);
    getServletContext().getRequestDispatcher("/statisticOfBook").forward(request, response);
  }
}
