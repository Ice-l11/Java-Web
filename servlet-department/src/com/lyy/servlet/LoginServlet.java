package com.lyy.servlet;

import com.lyy.util.JdbcUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName LoginServlet
 * @Description 登陆校验
 * @Author Ice
 * @Date 2022/9/29 17:19
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String contextPath = req.getContextPath();
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        String noLogin = req.getParameter("noLogin");
        System.out.println("noLogin = " + noLogin);  //noLogin = on
        boolean loginFlag = login(user,password);
        //十天免登录
        if ( noLogin != null && loginFlag){
            Cookie cookie1 = new Cookie("user",user);
            Cookie cookie2 = new Cookie("password",password);
            cookie1.setPath(contextPath);
            cookie2.setPath(contextPath);
            cookie1.setMaxAge(60 * 60 * 24 * 10);
            cookie2.setMaxAge(60 * 60 * 24 * 10);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        }
        if (!loginFlag){
            System.out.println("密码错误，请检查！");
            resp.sendRedirect(contextPath + "/error.html");
        }else {
            resp.sendRedirect(contextPath + "/index.html");
        }
    }

    protected boolean login(String user,String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select 1 from user where name = ? and password = ?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,user);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            if (rs.next()) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn,ps,rs);
        }
        return false;
    }
}
