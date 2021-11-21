package factory;

import dao.Impl.UserDaoImpl;
import dao.UserDao;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
