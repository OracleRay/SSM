package service;

import domain.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public interface RoleService {

    List<Role> list();

    void save(Role role);
}
