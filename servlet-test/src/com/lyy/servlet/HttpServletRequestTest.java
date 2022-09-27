package com.lyy.servlet;

import jakarta.servlet.RequestDispatcher;
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

        //转发
        //1、获取请求转发器对象
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet/student");
        //2、调用forward方法完成跳转/转发
//        requestDispatcher.forward(req,resp);

        req.getRequestDispatcher("/servlet/student").forward(req,resp);

        //两个容易混淆的方法
        req.getParameter("username"); //获取请求参数中key为username当中的第一个元素
        req.getAttribute("session"); //获取请求域中绑定key为session的值，在此之前有执行req.setAttribute("session",new Object());

        /*
        * 其它常用方法
        *   1、String getRemoteAddr(); //获取客户端的IP地址
        *   2、void setCharacterEncoding(String var1) throws UnsupportedEncodingException;; //设置请求的字符集
        *   3、String getContextPath(); //获取应用的根路径
        *   4、String getMethod(); //获取请求方式
        *   5、String getRequestURI(); //获取请求URI
        *   6、 String getServletPath(); //获取Servlet path
        * */
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr); //0:0:0:0:0:0:0:1

        /*
        * get请求在请求行上提交数据
        * post请求在请求体中提交数据
        * 设置请求体的字符集。（显然这个方法是处理POST请求的乱码问题。这种方式并不能解决get请求的乱码问题。）
        * Tomcat10之后，request请求体当中的字符集默认就是UTF-8，不需要设置字符集，不会出现乱码问题
        * Tomcat9前（包括9在内），如果前端请求体提交的是中文，后端获取之后出现乱码，怎么解决这个乱码？执行以下代码
        */
        req.setCharacterEncoding("UTF-8");

        /*
        * get请求乱码问题怎么解决？
        * get请求发送的时候，数据是在请求行上提交的，不是在请求体当中提交的。
        * get请求乱码怎么解决
        * 方案：修改CATALINA_HOME/conf/server.xml配置文件  <Connector URIEncoding="UTF-8" />
        * 注意：从Tomcat8之后，URIEncoding的默认值就是UTF-8，所以GET请求也没有乱码问题了。
        */

        //获取应用的根路径
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath); //contextPath = /servlet-test

        //获取请求方式
        String method = req.getMethod();
        System.out.println("method = " + method); //method = GET

        //获取请求URI
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI); //requestURI = /servlet-test/httpServletRequest

        //获取servlet path
        String servletPath = req.getServletPath();
        System.out.println("servletPath = " + servletPath); //servletPath = /httpServletRequest

    }
}
