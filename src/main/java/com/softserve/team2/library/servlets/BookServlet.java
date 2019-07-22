package com.softserve.team2.library.servlets;


import com.softserve.team2.library.dto.BookDto;
import com.softserve.team2.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class BookServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService=new BookService();
        String bookTitle="Effective Java";

//            BookDto bookDto=bookService.findBookByTitle(bookTitle);
        BookDto bookDto= new BookDto();
        bookDto.setTitle("Effective Java");
        bookDto.setAvailable(6);
            req.setAttribute("title",1);
            req.setAttribute("ava",bookDto.getAvailable());
            getServletContext().getRequestDispatcher("/menu.jsp").forward(req,resp);


    }
}
