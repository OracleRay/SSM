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
        //���ü���������ɶ�spring�����Ĵ���
        ServletContext servletContext = request.getServletContext();
        //ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        //ʹ�ù������ȡ�������е�app
        //ApplicationContext app = WebApplicationContextUtils.getWebApplicationContextUtils(servletContext);
        //ʹ��spring����Ѿ��еļ������͹���������ȡApplicationContext
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService bean = app.getBean(UserService.class);
        bean.save();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
