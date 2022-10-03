package com.lyy.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @ClassName MyFilter02
 * @Description MyFilter02
 * @Author Ice
 * @Date 2022/10/3 16:19
 * @Version 1.0
 **/
@WebFilter(value = {"/filter/abc"})
public class MyFilter02 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("调用过滤器MyFilter02对请求进行过滤...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("调用过滤器MyFilter02对响应进行过滤...");
    }
}
