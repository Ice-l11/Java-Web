package com.lyy.servlet;

import com.lyy.util.JdbcUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName DeleteByDeptNoServlet
 * @Description 删除一条部门信息记录
 * @Author Ice
 * @Date 2022/9/27 17:04
 * @Version 1.0
 **/
public class DeleteByDeptNoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
        PreparedStatement ps = null;
        String deptno = req.getParameter("deptno");
        try {
            String sql = "delete from dept where deptno = ?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,deptno);
            int num = ps.executeUpdate();
            if (num == 1){
                //成功
                req.getRequestDispatcher("/index.html").forward(req,resp);
            }else {
                req.getRequestDispatcher("/error.html").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeResource(conn,ps,null);
        }
    }
}
