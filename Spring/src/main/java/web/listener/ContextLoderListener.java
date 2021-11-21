package web.listener;

/**
 * 自己写的虚假的监听器，spring框架有同名的监听器
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebListener
public class ContextLoderListener implements ServletContextListener{

    public ContextLoderListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        ServletContext servletContext = sce.getServletContext();   //获取servletContext对象
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //将spring的应用上下文存储到Listener的contextListener中
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        servletContext.setAttribute("app",app);
        System.out.println("spring容器已经创建完毕！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
