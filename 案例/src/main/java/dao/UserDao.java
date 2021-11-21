package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    List<User> list();

    User findUserByUsernameAndPassword(String username, String password);
}
