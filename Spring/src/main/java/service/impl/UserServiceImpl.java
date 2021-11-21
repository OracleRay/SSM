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
    //@Autowired           //�����������ʹ�Spring�����н���ƥ���
    //@Qualifier("userDao") //�ǰ���idֵ�������н���ƥ��� ������Ҫ�˴�@Qualifier���@Autowiredһ��ʹ��
    @Resource(name = "userDao")  //@Resource�൱��@Qualifier+@Autowired
    private UserDao dao;
    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    //set��������ע��
    public void setDao(UserDao dao) {
        this.dao = dao;
    }               //ע�ⷽ�����Բ�дset����

    @Override
    public void save() {
        dao.save();
        System.out.println(driver);
    }
}
