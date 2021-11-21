package webTest;
/**
 * 模拟web
 */

import AnnotationTest.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class UserController {
    public static void main(String[] args) {
        //xml配置文件开发
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext app = new FileSystemXmlApplicationContext("D:\\雷东宸\\IdeaProjects\\SSM框架\\Spring\\src\\main\\resources\\applicationContext.xml");
        //注解开发
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userDao = (UserService) app.getBean("userService");
        //UserDao userDao = app.getBean(UserDaoImpl.class);
        userDao.save();
    }
}
