package dao.Impl;

import dao.UserDao;
import domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Properties;
//<bean id="userDao" class="dao.Impl.UserDaoImpl"></bean>
//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    private String username;
    private int age;
    //@PostConstruct
    public void init(){
        System.out.println("容器被创建了！");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println("hello spring!");
        /*System.out.println(username + " " + age);
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);*/
    }
    //@PreDestroy
    public void destroy(){
        System.out.println("容器被销毁了！");
    }
}
