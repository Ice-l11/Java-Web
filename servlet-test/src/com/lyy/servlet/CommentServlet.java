package com.lyy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;

/**
 * @ClassName CommentServlet
 * @Description CommentServlet
 * @Author Ice
 * @Date 2022/10/3 16:55
 * @Version 1.0
 **/
@WebServlet(name = "commentServlet",value = "/comment")
public class CommentServlet extends HttpServlet {

    private HashSet<String> sensitiveWordIpSet = new HashSet<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String comment = (String) req.getAttribute("comment");
        if (message.equals(comment)){
            System.out.println("没有敏感词...");
            req.setAttribute("name","good boy:");
        }else {
            String localAddr = req.getLocalAddr();
            System.out.println("localAddr = " + localAddr);
            sensitiveWordIpSet.add(localAddr); //记录IP
            req.setAttribute("name","bad boy:");
        }
        req.getRequestDispatcher("/comment.jsp").forward(req,resp);
    }
}
