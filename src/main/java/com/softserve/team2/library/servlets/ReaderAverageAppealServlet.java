package com.softserve.team2.library.servlets;


import com.softserve.team2.library.dto.ReaderDto;
import com.softserve.team2.library.services.ReaderServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/readerAverageAppeal")
public class ReaderAverageAppealServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReaderServices readerServices=new ReaderServices();
        String fromDate=req.getParameter("fromDate");
        String toDate=req.getParameter("toDate");
        req.setAttribute("fromDate",fromDate);
        req.setAttribute("toDate",toDate);

        ReaderDto readerDto=readerServices.getAverageAppealByPeriod(fromDate,toDate);
        req.setAttribute("readerDto",readerDto);
        req.getRequestDispatcher("WEB-INF/views/readerAverageAppeal.jsp").forward(req,resp);

    }
}
