package com.lyy.servlet;

import com.lyy.util.JdbcUtils;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName DepartmentUpdateServlet
 * @Description 更新数据操作
 * @Author Ice
 * @Date 2022/9/27 17:58
 * @Version 1.0
 **/
public class DepartmentUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        // 解决请求体的中文乱码问题
        req.setCharacterEncoding("UTF-8");
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "update dept set dname = ?,loc = ? where deptno = ?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,dname);
            ps.setObject(2,loc);
            ps.setObject(3,deptno);
            int i = ps.executeUpdate();
            if (i == 1){
                req.getRequestDispatcher("/index.html").forward(req,resp);
            }else {
                req.getRequestDispatcher("/error.html").forward(req,resp); //失败页面跳转
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn,ps,null);
        }
    }
}
