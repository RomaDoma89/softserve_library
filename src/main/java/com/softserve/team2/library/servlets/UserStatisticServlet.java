package com.softserve.team2.library.servlets;

import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.dto.ReaderDto;
import com.softserve.team2.library.services.ReaderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userStatisticName")
public class UserStatisticServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String reader = req.getParameter("name");
    String select = req.getParameter("select");
    req.setAttribute("name",reader);
      ReaderServices readerServices=new ReaderServices();
      List<BookDto>listOfBook;
    if (select.equals("value1")) {
       listOfBook= readerServices.getReadBook(reader);
      System.out.println(listOfBook);
        req.setAttribute("listOfBook",listOfBook);
      req.getRequestDispatcher("WEB-INF/views/userStatisticRead.jsp").forward(req, resp);
    } else if (select.equals("value2")) {
       listOfBook= readerServices.getNotReturnedBook(reader);
       req.setAttribute("listOfBook",listOfBook);
      req.getRequestDispatcher("WEB-INF/views/userStatisticOnHand.jsp").forward(req, resp);

    } else {
      ReaderDto readerDto= readerServices.getRegisterDate(reader);
      req.setAttribute("readerDto",readerDto);
      req.getRequestDispatcher("WEB-INF/views/userStatisticRegistration.jsp").forward(req, resp);
    }
  }
}
