package dao.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
    private JdbcTemplate template = app.getBean(JdbcTemplate.class);

    @Override
    public List<Role> findAll() {
        String sql = "select * from test.sys_role";
        return template.query(sql,new BeanPropertyRowMapper<Role>(Role.class));
    }

    @Override
    public void save(Role role) {
        String sql = "insert into test.sys_role values(?,?,?)";
        template.update(sql,null,role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findUserById(Long id) {
        String sql = "select * from test.sys_user_role ur,test.sys_role r where ur.roleId = r.id and ur.userId = ?";
        return template.query(sql,new BeanPropertyRowMapper<Role>(Role.class),id);
    }
}
