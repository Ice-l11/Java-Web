package com.lyy.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @ClassName StudentServlet
 * @Description StudentServlet
 * @Author Ice
 * @Date 2022/9/21 14:17
 * @Version 1.0
 **/
public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("无参构造执行...");
        System.out.println("execute init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行了StudentServlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("execute destroy");
    }
}
