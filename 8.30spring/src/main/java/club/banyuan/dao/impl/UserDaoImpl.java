package club.banyuan.dao.impl;

import club.banyuan.dao.UserDao;
import club.banyuan.pojo.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public List<User> getAll() {
        System.out.println("UserDaoImpl  --- getAll()");
        return null;
    }
}
