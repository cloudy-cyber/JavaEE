package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import dao.util.DataSourceUtil;
import org.junit.Test;
import pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class TestUserDao {
    @Test
    public void testGetUserByUsernameAndPwd() throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        UserDao userDao = new UserDaoImpl(conn);

        User user = userDao.getUserByUserNameAndPwd("aaaa", "12345");
        System.out.println(user);

        DataSourceUtil.closeConnection(conn);
    }

    @Test
    public void testAddUser() throws SQLException {
        User user = new User();
        user.setLoginName("ABC");
        user.setUserName("XXXX");
        user.setType(1);
        user.setMobile("234242432");
        user.setEmail("sdf@df.com");
        user.setIdentityCode("2342423423423");
        user.setSex(1);
        user.setPassword("123321");
        Connection conn = DataSourceUtil.openConnection();
        UserDao userDao = new UserDaoImpl(conn);
        User newUser = userDao.AddUser(user);
        System.out.println(newUser);

        DataSourceUtil.closeConnection(conn);
    }

    @Test
    public void testDeleteUser() throws SQLException {
        Connection connection = DataSourceUtil.openConnection();
        UserDao userDao = new UserDaoImpl(connection);
        userDao.deleteUser(25);
        DataSourceUtil.closeConnection(connection);
    }
}
