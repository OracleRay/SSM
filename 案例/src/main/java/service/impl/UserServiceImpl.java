package service.impl;

import dao.RoleDao;
import dao.UserDao;
import domain.Role;
import domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao dao;

    @Resource(name = "roleDao")
    private RoleDao roleDao;

    @Override
    public List<User> list() {
        List<User> userList = dao.list();
        for(User user : userList){
            Long id = user.getId();
            List<Role> roles = roleDao.findUserById(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public User login(String username, String password) {
        try {
            User user = dao.findUserByUsernameAndPassword(username,password);
            return user;
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
