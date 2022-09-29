package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @ClassName ReceiveCookieServlet
 * @Description 接收cookie的值
 * @Author Ice
 * @Date 2022/9/29 16:32
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/servlet/receiveCookie")
public class ReceiveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过java程序怎么接收到浏览器发送过来的cookie呢？
        // 当然通过request对象了。（返回值是一个数组，因为浏览器可能会提交多个cookie给服务器。）
        // 注意细节：这个方法可能会返回null。如果浏览器没有提交cookie，这个方法返回值是null，并不是返回一个长度为0的数组。
        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name = " + name + ",value = " + value);
            }
        }
        /* name = JSESSIONID,value = 6079C92EE671DDC72C35B475B30AD102
           name = user,value = ice
           name = password,value = 123
        */
    }
}
