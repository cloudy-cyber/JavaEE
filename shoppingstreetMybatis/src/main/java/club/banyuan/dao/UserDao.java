package club.banyuan.dao;

import club.banyuan.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User getUserByUserNameAndPwd(User user);

    public int addUser(User user);

    public int delUser(int id);

    public int updateUser(User newuser);

    public List<User> getAllUser();

    public User checkLoginName(String name);
}
