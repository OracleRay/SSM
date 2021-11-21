package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //调用监听器来完成对spring容器的创建
        ServletContext servletContext = request.getServletContext();
        //ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        //使用工具类获取监听器中的app
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContextUtils(servletContext);
        //使用spring框架已经有的监听器和工具类来获取ApplicationContext
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService bean = app.getBean(UserService.class);
        bean.save();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
