package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @ClassName AnnotationTest
 * @Description 注解的使用
 * @Author Ice
 * @Date 2022/9/29 10:54
 * @Version 1.0
 **/
@WebServlet(value = "/servlet/annotation")
public class AnnotationTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object nowTime = new Date();
        PrintWriter out = resp.getWriter();
        out.print("AnnotationTest nowTime = " + nowTime);
        HttpSession session = req.getSession();
        out.print("sessionid = " + session.getId());
//        session.invalidate(); //销毁session
        Object user = session.getAttribute("user");
        out.print("user = " + user);
    }
}
