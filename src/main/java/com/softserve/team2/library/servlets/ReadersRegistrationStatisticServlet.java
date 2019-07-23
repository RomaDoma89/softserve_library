package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.ReaderDto;
import com.softserve.team2.library.services.ReaderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/reader_registration")
public class ReadersRegistrationStatisticServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ReaderServices readerServices = new ReaderServices();
    List<ReaderDto> listReaderDto;

    listReaderDto = readerServices.getListOfReadersRegistration();
    req.setAttribute("listReaderDto", listReaderDto);
    req.getRequestDispatcher("WEB-INF/views/readersRegistrationStatistic.jsp").forward(req, resp);
  }
}
