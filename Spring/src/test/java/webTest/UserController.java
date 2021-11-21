package webTest;
/**
 * ģ��web
 */

import AnnotationTest.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class UserController {
    public static void main(String[] args) {
        //xml�����ļ�����
        //ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext app = new FileSystemXmlApplicationContext("D:\\�׶��\\IdeaProjects\\SSM���\\Spring\\src\\main\\resources\\applicationContext.xml");
        //ע�⿪��
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userDao = (UserService) app.getBean("userService");
        //UserDao userDao = app.getBean(UserDaoImpl.class);
        userDao.save();
    }
}
