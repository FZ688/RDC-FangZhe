package week3.service;

import week3.dao.UserDao;
import week3.entity.User;

/**
 * @author fz
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public boolean register(User user){
        return userDao.register(user);
    }

    public User login(String name, String password){
        return userDao.login(name,password);
    }

    public User findUserByName(String name){
        return userDao.findUserByName(name);
    }
}
