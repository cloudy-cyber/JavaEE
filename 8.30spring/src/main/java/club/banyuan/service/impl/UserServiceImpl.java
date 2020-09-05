package club.banyuan.service.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getAll() {
        System.out.println("UserServiceImpl --- getAll()");
        userDao.getAll();
    }
}
