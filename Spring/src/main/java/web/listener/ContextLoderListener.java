package web.listener;

/**
 * �Լ�д����ٵļ�������spring�����ͬ���ļ�����
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
        ServletContext servletContext = sce.getServletContext();   //��ȡservletContext����
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //��spring��Ӧ�������Ĵ洢��Listener��contextListener��
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        servletContext.setAttribute("app",app);
        System.out.println("spring�����Ѿ�������ϣ�");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
