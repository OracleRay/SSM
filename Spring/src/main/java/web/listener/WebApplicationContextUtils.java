package web.listener;

/**
 * 自己写的虚假的工具类，Spring有这个工具类无需自己写
 */

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContextUtils(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
