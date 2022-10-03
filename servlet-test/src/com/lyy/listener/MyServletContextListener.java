package com.lyy.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * @ClassName MyServletContextListener
 * @Description MyServletContextListener
 * @Author Ice
 * @Date 2022/10/3 18:08
 * @Version 1.0
 **/
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...");
    }
}
