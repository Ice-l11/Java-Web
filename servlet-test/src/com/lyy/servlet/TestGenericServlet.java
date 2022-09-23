package com.lyy.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName TestGenericServlet
 * @Description TestGenericServlet
 * @Author Ice
 * @Date 2022/9/23 18:19
 * @Version 1.0
 **/
public class TestGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("this.getServletInfo = " + this.getServletInfo());
        System.out.println("this.getServletName() = " + this.getServletName());
        System.out.println("this.getServletConfig() = " + this.getServletConfig());
        System.out.println("this.getInitParameterNames() = " + this.getInitParameterNames());
        Enumeration<String> enumeration = this.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            System.out.println("enumeration.nextElement() = " + enumeration.nextElement());
        }
    }
}
