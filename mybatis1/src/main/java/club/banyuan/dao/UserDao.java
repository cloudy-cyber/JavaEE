package club.banyuan.dao;

import club.banyuan.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public int addUser(User user);
    public int updateUser(User newUser);
    public int delUser(int id);
}
