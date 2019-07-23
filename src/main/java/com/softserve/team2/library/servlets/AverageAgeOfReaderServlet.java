package com.softserve.team2.library.servlets;


import com.softserve.team2.library.dto.ReaderDto;
import com.softserve.team2.library.services.ReaderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/averageAgeOfReader")
public class AverageAgeOfReaderServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReaderServices readerServices=new ReaderServices();
        ReaderDto readerDto=readerServices.getAverageAgeOfReaders();
        String str= String.valueOf(readerDto.getAverageAge());
        req.setAttribute("str",str);
    System.out.println(readerDto.getAverageAge());
    System.out.println(str);
    req.getRequestDispatcher("WEB-INF/views/readerAverageAge.jsp").forward(req, resp);
    }
}
