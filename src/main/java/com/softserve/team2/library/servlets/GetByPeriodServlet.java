package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getByPeriodServlet")
public class GetByPeriodServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String firstPeriod = request.getParameter("firstInput");
    String secondPeriod = request.getParameter("secondInput");
    BookService bookService = new BookService();

    BookDto bookDto = bookService.findByPeriod(firstPeriod, secondPeriod);
    request.setAttribute("count", bookDto.getCount());
    getServletContext().getRequestDispatcher("/getByPeriod").forward(request, response);
  }
}
