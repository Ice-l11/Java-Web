package com.lyy.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommentFilter
 * @Description 评论过滤
 * @Author Ice
 * @Date 2022/10/3 16:48
 * @Version 1.0
 **/
//servletNames指定过滤的servlet,value过滤路径
@WebFilter(servletNames = "commentServlet",value = {"/comment"},initParams = {@WebInitParam(name = "sensitiveWord",value = "sb")})
public class CommentFilter implements Filter {

    private List<String> sensitiveWordList = new ArrayList<>();  //存放敏感词集合
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String sensitiveWord = filterConfig.getInitParameter("sensitiveWord");
        sensitiveWordList.add(sensitiveWord);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        String message = servletRequest.getParameter("message");
        for (String sw : sensitiveWordList){
            //遍历判断是否包含敏感词，是则替换**
            if (message.contains(sw)){
                message = message.replaceAll(sw,"**");
            }
        }
        servletRequest.setAttribute("comment",message);
        filterChain.doFilter(servletRequest,servletResponse); //放行
    }
}
