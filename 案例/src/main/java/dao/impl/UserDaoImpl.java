package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    private JdbcTemplate template = app.getBean(JdbcTemplate.class);
    @Override
    public List<User> list() {
        String sql = "select * from test.sys_user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from test.sys_user where username = ? and password = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        System.out.println(user);
        return user;

    }

}
