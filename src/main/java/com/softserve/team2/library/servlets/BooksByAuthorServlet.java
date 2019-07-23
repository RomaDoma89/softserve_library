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

@WebServlet("/books_by_author")
public class BooksByAuthorServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    BookService bookService = new BookService();
    String authorName = req.getParameter("author");
//    String authorName = req.getParameter("Joshua Bloch");

    List<BookDto> listBookDto = bookService.findBooksByAuthor(authorName);
    req.setAttribute("listBookDto", listBookDto);
    System.out.println(listBookDto);
    req.getRequestDispatcher("WEB-INF/views/booksByAuthor.jsp").forward(req,resp);
  }
}
