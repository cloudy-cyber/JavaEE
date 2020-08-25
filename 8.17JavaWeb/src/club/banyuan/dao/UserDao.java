package club.banyuan.dao;

import club.banyuan.pojo.User;

import java.sql.SQLException;

public interface UserDao extends IBaseDao {
    public User getUserByUserNameAndPwd(String username, String password) throws Exception;

    public User addUser(User user);

    public String getAddressByUserId(int id) throws SQLException;

    public User checkLoginName(String loginName) throws Exception;
}
