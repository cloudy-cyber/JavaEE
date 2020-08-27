import club.banyuan.dao.UserDao;
import club.banyuan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserDao {
    SqlSession session = null;
    UserDao userDao = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        session = sqlSessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

    public void printUser(List<User> userList) {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetUserByUserNameAndPwd() {
        User user = new User();
        user.setLoginName("qwer");
        user.setPassword("123");
        System.out.println(userDao.getUserByUserNameAndPwd(user));
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setLoginName("shctdfhgfdhg3");
        user.setUserName("石欢程");
        user.setPassword("123");
        user.setSex(0);
        user.setIdentityCode("1231");
        user.setEmail("123@456");
        user.setMobile("123123123");
        user.setType(1);

        userDao.addUser(user);
    }

    @Test
    public void testDelUser() {
        userDao.delUser(42);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(37);
        user.setLoginName("fffff");
        user.setUserName("房企豪");
        user.setPassword("45678");
        userDao.updateUser(user);
    }

    @Test
    public void testGetAllUser(){
        printUser(userDao.getAllUser());
    }

    @Test
    public void testCheckLoginName(){
        System.out.println(userDao.checkLoginName("fffff"));
    }
}
