package com.lyy.servlet;

import com.lyy.util.JdbcUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName DepartmentAddServlet
 * @Description 部门新增操作
 * @Author Ice
 * @Date 2022/9/28 16:19
 * @Version 1.0
 **/
public class DepartmentAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String deptno = req.getParameter("deptno");
            String dname = req.getParameter("dname");
            String loc = req.getParameter("loc");
            String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,deptno);
            ps.setObject(2,dname);
            ps.setObject(3,loc);
            int i = ps.executeUpdate();
            if (i == 1){
                //success
                req.getRequestDispatcher("/index.html").forward(req,resp);
            }else {
                req.getRequestDispatcher("/error.html").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn,ps,null);
        }
    }
}
