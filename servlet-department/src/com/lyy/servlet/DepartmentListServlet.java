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
 * @ClassName DepartmentListServlet
 * @Description 查询部门数据
 * @Author Ice
 * @Date 2022/9/27 15:16
 * @Version 1.0
 **/
public class DepartmentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String contextPath = req.getContextPath();
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html lang=\"en\">");
        out.print("<head>");
        out.print("    <meta charset=\"UTF-8\">");
        out.print("    <title>Detail</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<script type=\"text/javascript\">");
        out.print("    function deleteData(no){");
        out.print("        var flag = window.confirm(\"请确认是否删除？\");");
        out.print("        if (flag){");
        out.print("            document.location.href=\""+contextPath+"/dept/delete?deptno=\" + no;");
        out.print("        }");
        out.print("    }");
        out.print("</script>");
        out.print("<h2>这是详情页</h2>");
        out.print("<hr>");
        out.print("<h2 align=\"center\">部门列表</h2>");
        out.print("<table border=\"1px\" align=\"center\" width=\"50%\">");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "select deptno,dname,loc from dept";
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()){
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("			<tr>");
                out.print("				<td>"+(++i)+"</td>");
                out.print("				<td>"+deptno+"</td>");
                out.print("				<td>"+dname+"</td>");
                out.print("				<td>");
                out.print("					<a href=\"javascript:void(0)\" onclick=\"deleteData("+deptno+")\">删除</a>");
                out.print("					<a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>");
                out.print("					<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.print("				</td>");
                out.print("			</tr>");
                out.print("			<br>");
            }
        }catch (Exception e){
            out.print(e.getMessage());
        }finally {
            JdbcUtils.closeResource(conn,ps,rs);
        }
        out.print("</table>");
        out.print("<h2><a href='"+contextPath+"/dept/addEdit'>新增部门</a></h2>");
        out.print("</body>");
        out.print("</html>");
    }
}
