package com.lyy.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @ClassName MyFilter01
 * @Description MyFilter01
 * @Author Ice
 * @Date 2022/10/3 16:18
 * @Version 1.0
 **/
@WebFilter(value = {"/filter/abc"})
public class MyFilter01 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("调用过滤器MyFilter01对请求进行过滤...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("调用过滤器MyFilter01对响应进行过滤...");
    }
}
