package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName AServlet
 * @Description AServlet
 * @Author Ice
 * @Date 2022/9/27 11:01
 * @Version 1.0
 **/
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object nowTime = new Date();
        req.setAttribute("dateTime",nowTime);

        Object dateTime = req.getAttribute("dateTime");
        System.out.println("dateTime = " + dateTime);

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("AServlet dateTime = " + dateTime);

        //AServlet转发到BServlet，保证AServlet和BServlet在同一次请求中，这样可以做到两个Servlet或多个Servlet共享同一份数据
        req.getRequestDispatcher("/BServlet").forward(req,resp);


    }
}
