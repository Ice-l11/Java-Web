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
 * @ClassName DepartmentDetailServlet
 * @Description 部门详情信息
 * @Author Ice
 * @Date 2022/9/27 16:18
 * @Version 1.0
 **/
public class DepartmentDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
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
                out.print("<tr>");
                out.print("     <td>部门编号："+no+"</td>");
                out.print("		<td>部门名称："+dname+"</td>");
                out.print("		<td>所属城市："+loc+"</td>");
                out.print("	</tr>");
                out.print("	<br>");
            }
        }catch (Exception e){
            out.print(e.getMessage());
        }finally {
            JdbcUtils.closeResource(conn,ps,rs);
        }
    }
}
