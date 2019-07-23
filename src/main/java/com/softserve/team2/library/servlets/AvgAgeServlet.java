package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.ReaderDto;
import com.softserve.team2.library.services.ReaderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AvgAgeServlet", value = "/avgAgeServlet")
public class AvgAgeServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    ReaderServices readerServices = new ReaderServices();
    ReaderDto readerDto = readerServices.getAvgAgeByBook(title);
    int avgByBook = readerDto.getAvgAge();
    readerDto = readerServices.getAvgAgeByAuthor(author);
    request.setAttribute("ageBook", avgByBook);
    request.setAttribute("ageAuthor", readerDto.getAvgAge());
    getServletContext().getRequestDispatcher("/getAvgAge").forward(request, response);
  }
}
