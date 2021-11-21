package service.impl;

import dao.RoleDao;
import domain.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import service.RoleService;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name = "roleDao")
    private RoleDao dao;
    @Override
    public List<Role> list() {
        return dao.findAll();
    }

    @Override
    public void save(Role role) {
        dao.save(role);
    }
}
