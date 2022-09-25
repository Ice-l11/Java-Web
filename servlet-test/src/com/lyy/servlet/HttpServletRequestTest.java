package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * @description HttpServletRequestTest
 * @author Ice
 * @date 2022/09/25 22:43
 * @version 1.0
 */
public class HttpServletRequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter respWriter = resp.getWriter();
        respWriter.print(req); //org.apache.catalina.connector.RequestFacade@52e1f779
        /* HttpServletRequest接口中常用方法
         *  1、Map<String,String[]> getParameterMap()  //这个是获取Map
         *  2、Enumeration<String> getParameterNames() //这个是获取Map集合中所有的key
         *  3、String[] getParameterValues(String name)  //根据key获取Map集合的value
         *  4、String getParameter(String name)  //获取value这个一维数组当中的第一个元素。这个方法最常用。
         */
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println("parameterMap = " + parameterMap);
        for (Map.Entry<String,String[]> entry : parameterMap.entrySet()){
            String key = entry.getKey();
            String values[] = entry.getValue();
            System.out.println("key = " + key);
            for (String value : values){
                System.out.println("value = " + value);
            }
        }
        //获取Map集合中所有的key
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println("parameterNames.nextElement() = " + parameterNames.nextElement());
        }
        //根据key获取Map集合的value
        String[] usernames = req.getParameterValues("username");
        for (String user : usernames){
            System.out.println("user = " + user);
        }
        //获取value这个一维数组当中的第一个元素
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String password = req.getParameter("password");
        System.out.println("password = " + password);
    }
}
