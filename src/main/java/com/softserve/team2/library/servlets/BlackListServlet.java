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

@WebServlet(name = "BlackListServlet", value = "/getBlackListServlet")
public class BlackListServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ReaderServices readerServices = new ReaderServices();
    List<ReaderDto> readerList = readerServices.getBlackList();
    request.setAttribute("list", readerList);
    getServletContext().getRequestDispatcher("/getBList").forward(request, response);
  }
}
