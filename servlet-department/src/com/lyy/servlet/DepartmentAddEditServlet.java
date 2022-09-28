package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName DepartmentAddEditServlet
 * @Description 新增部门编辑页面
 * @Author Ice
 * @Date 2022/9/28 16:13
 * @Version 1.0
 **/
public class DepartmentAddEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        PrintWriter out = resp.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<head>");
        out.print("    <meta charset=\"UTF-8\">");
        out.print("    <title>Add Dept</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("    <form action=\""+contextPath+"/dept/add\" method=\"post\">");
        out.print("        <input type=\"text\" name=\"deptno\" value=\"\"/>");
        out.print("        <input type=\"text\" name=\"dname\" value=\"\"/>");
        out.print("        <input type=\"text\" name=\"loc\" value=\"\"/>");
        out.print("        <input type=\"submit\" value=\"新增\"/>");
        out.print("    </form>");
        out.print("</body>");
        out.print("</html>");
    }
}
