package dao;

import domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findUserById(Long id);
}
