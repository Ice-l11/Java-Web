package com.lyy.servlet;

import jakarta.servlet.*;

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
//        System.out.println("this.getServletInfo = " + this.getServletInfo());
//        System.out.println("this.getServletName() = " + this.getServletName());
//        System.out.println("this.getServletConfig() = " + this.getServletConfig());
//        System.out.println("this.getInitParameterNames() = " + this.getInitParameterNames());

        Enumeration<String> enumeration = this.getInitParameterNames();
        while (enumeration.hasMoreElements()){
            System.out.println("enumeration.nextElement() = " + enumeration.nextElement());
        }

        ServletContext servletContext = this.getServletConfig().getServletContext();
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
//            System.out.println("initParameterNames.nextElement() = " + initParameterNames.nextElement());
            String initParameter = servletContext.getInitParameter(initParameterNames.nextElement());
            System.out.println("initParameter = " + initParameter);
        }
        String contextPath = servletContext.getContextPath();  //获取应用的根路径
        System.out.println("contextPath = " + contextPath);    //  /servlet-test

        String realPath = servletContext.getRealPath("web.xml");
        System.out.println("realPath = " + realPath); //D:\lyy\java-web\out\artifacts\servlet_test_war_exploded\web.xml

        //向ServletContext应用域中存储数据
        servletContext.log("print servletContext log...");
        servletContext.setAttribute("sessionId","login123");
        System.out.println("servletContext.getAttribute(\"sessionId\") = " + servletContext.getAttribute("sessionId"));
        servletContext.removeAttribute("sessionId");



    }
}
