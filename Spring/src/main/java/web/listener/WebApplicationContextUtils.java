package web.listener;

/**
 * �Լ�д����ٵĹ����࣬Spring����������������Լ�д
 */

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContextUtils(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
