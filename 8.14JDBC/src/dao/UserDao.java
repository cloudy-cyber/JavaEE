package dao;

import pojo.User;

public interface UserDao extends IBaseDao{
    public User getUserByUserNameAndPwd(String username, String password) throws Exception;
    public User AddUser(User user);
    public void deleteUser(int id);
}
