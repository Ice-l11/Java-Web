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
import java.sql.ResultSet;

/**
 * @ClassName DepartmentEditServlet
 * @Description 编辑部门信息页面
 * @Author Ice
 * @Date 2022/9/27 17:40
 * @Version 1.0
 **/
public class DepartmentEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String contextPath = req.getContextPath();
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html lang=\"en\">");
        out.print("<head>");
        out.print("    <meta charset=\"UTF-8\">");
        out.print("    <title>Edit</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("     <h2>修改部门</h2>");
        out.print("<hr>");
        out.print("<body>");
        out.print("<form action='"+contextPath+"/dept/update' method='post'>");
        String deptno = req.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select deptno,dname,loc from dept where deptno = ?";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,deptno);
            rs = ps.executeQuery();
            while (rs.next()){
                int no = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("		部门编号：<input type='text' name='deptno' value='"+no+"' readonly /><br>"); //只读
                out.print("		部门名称：<input type='text' name='dname' value='"+dname+"' /><br>");
                out.print("		所属城市：<input type='text' name='loc' value='"+loc+"'/> <br>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn,ps,rs);
        }
        out.print("     <input type='submit' value='修改'>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }
}
