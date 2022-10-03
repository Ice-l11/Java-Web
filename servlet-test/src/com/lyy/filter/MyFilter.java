package com.lyy.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description 过滤器测试
 * @Author Ice
 * @Date 2022/10/3 14:07
 * @Version 1.0
 **/
//@WebFilter(value = {"/*"}, filterName = "myFilter")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("对request进行过滤");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("对response进行过滤");
    }
}
