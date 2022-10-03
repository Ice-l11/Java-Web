package com.lyy.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName LifeCycleFilter
 * @Description 拦截过滤器
 * @Author Ice
 * @Date 2022/10/3 15:24
 * @Version 1.0
 **/
public class LifeCycleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行了init方法...");
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            System.out.println(name + " = " + filterConfig.getInitParameter(name));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行了doFilter方法...");
    }

    @Override
    public void destroy() {
        System.out.println("执行了destroy方法...");
    }
}
