package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName BServlet
 * @Description BServlet
 * @Author Ice
 * @Date 2022/9/27 11:05
 * @Version 1.0
 **/
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object dateTime = req.getAttribute("dateTime");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("BServlet dateTime = " + dateTime);
    }
}
