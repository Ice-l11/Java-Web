package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @ClassName WelcomeServlet
 * @Description 欢迎页面
 * @Author Ice
 * @Date 2022/9/29 18:02
 * @Version 1.0
 **/
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        Cookie[] cookies = req.getCookies();
        String name = "";
        String pwd = "";
        if (cookies != null){
            for (Cookie cookie : cookies){
                if ("user".equals(cookie.getName())){
                    name = cookie.getValue(); //将cookie中的user取出判断
                }
                if ("password".equals(cookie.getName())){
                    pwd = cookie.getValue(); //将cookie中的password取出判断
                }
            }
        }
        if (!"".equals(name) && !"".equals(pwd)){
            resp.sendRedirect(contextPath + "/index.html");
        }else {
            resp.sendRedirect(contextPath + "/login.html");
        }
//        PrintWriter out = resp.getWriter();
//        out.print("<!DOCTYPE html>");
//        out.print("<html lang=\"en\">");
//        out.print("<head>");
//        out.print("    <meta charset=\"UTF-8\">");
//        out.print("    <title>Welcome to Department</title>");
//        out.print("</head>");
//        out.print("<body>");
//        out.print("    <h2>Welcome</h2>");
//        out.print("    <a href=\"/servlet-department/dept/list\">查看部门信息</a>");
//        out.print("</body>");
//        out.print("</html>");
    }
}
