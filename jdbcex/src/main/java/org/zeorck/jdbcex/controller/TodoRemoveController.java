package org.zeorck.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.zeorck.jdbcex.dto.TodoDTO;
import org.zeorck.jdbcex.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@Log4j2
@WebServlet(name = "todoRemoveController", value = "/todo/remove")
public class TodoRemoveController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long tno = Long.parseLong(req.getParameter("tno"));

        log.info("tno: "+ tno);
        log.info("todo remove POST --------------");


        try{
            todoService.remove(tno);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException("read error");
        }
        resp.sendRedirect("/todo/list");
    }
}
