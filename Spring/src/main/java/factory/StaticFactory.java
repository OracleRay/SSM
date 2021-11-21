package factory;

import dao.Impl.UserDaoImpl;
import dao.UserDao;

public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
