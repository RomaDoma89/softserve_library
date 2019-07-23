package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookTitle")
public class BookServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    BookService bookService = new BookService();
    String bookTitle = req.getParameter("title");

    BookDto bookDto = bookService.findBookByTitle(bookTitle);
    req.setAttribute("bookDto", bookDto);
    req.getRequestDispatcher("WEB-INF/views/availableBook.jsp").forward(req, resp);
  }
}
