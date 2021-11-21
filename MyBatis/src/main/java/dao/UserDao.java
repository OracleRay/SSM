package dao;

import domain.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    public List<User> findAll() throws IOException;
    public User findById(int id);

    public User findByUser(User user);

    public List<User> findByIds(List<Integer> listUser);
}
