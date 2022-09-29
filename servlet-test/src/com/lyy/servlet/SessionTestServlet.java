package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName SessionTestServlet
 * @Description SessionTestServlet
 * @Author Ice
 * @Date 2022/9/29 14:51
 * @Version 1.0
 **/
@WebServlet("/servlet/session")
public class SessionTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        out.print("session = " + session + "<br>");
        session.setAttribute("user","aoni");
        out.print("sessionid = " + session.getId());
        out.print("session user = " + session.getAttribute("user"));
    }
}
