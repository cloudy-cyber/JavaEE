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
import java.util.List;

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

    @Test
    public void testGetAll() throws IOException {
        List<User> userList = userDao.getAll();
        System.out.println(userList.size());

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setLoginName("房企豪");
        user.setUserName("fqh");
        user.setPassword("12345");
        user.setSex(0);
        user.setEmail("1321@qq.com");
        user.setIdentityCode("32012312312");
        user.setMobile("123123123");
        user.setType(0);

        userDao.addUser(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(28);
        user.setLoginName("asdf");
        user.setUserName("杨坤");
        user.setSex(1);
        user.setEmail("sdfs@dfsdf.com");
        user.setMobile("99898294892");
        user.setIdentityCode("32432423");
        user.setPassword("1111111");
        user.setType(1);

        userDao.updateUser(user);
    }

    @Test
    public void testDelUser() {
        userDao.delUser(32);
    }
}
