package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @ClassName GenerateCookieServlet
 * @Description 存储cookie
 * @Author Ice
 * @Date 2022/9/29 16:36
 * @Version 1.0
 **/
@WebServlet("/servlet/generateCookie")
public class GenerateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("user", "ice");
        Cookie cookie2 = new Cookie("password", "123");

        // 设置cookie在一小时之后失效。（保存在硬盘文件当中）
        //cookie.setMaxAge(60 * 60);
        // 设置cookie的有效期为0，表示该cookie被删除。主要应用在：使用这种方式删除浏览器上的同名cookie。
        //cookie.setMaxAge(0);
        // 设置cookie的有效期 < 0，表示该cookie不会被存储。（表示不会被存储到硬盘文件中。会放在浏览器运行内存当中。）
        cookie1.setMaxAge(60 * 60);
        cookie2.setMaxAge(60 * 60);

        cookie1.setPath(req.getContextPath());
        cookie2.setPath(req.getContextPath());

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
