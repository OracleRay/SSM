package service.impl;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;

//<bean id="userService" class="service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Value("${jdbc.driver}")
    public String driver;


    //<property name="dao" ref="userDao" />
    //@Autowired           //按照数据类型从Spring容器中进行匹配的
    //@Qualifier("userDao") //是按照id值从容器中进行匹配的 但是主要此处@Qualifier结合@Autowired一起使用
    @Resource(name = "userDao")  //@Resource相当于@Qualifier+@Autowired
    private UserDao dao;
    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    //set方法依赖注入
    public void setDao(UserDao dao) {
        this.dao = dao;
    }               //注解方法可以不写set方法

    @Override
    public void save() {
        dao.save();
        System.out.println(driver);
    }
}
