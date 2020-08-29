import club.banyuan.dao.UserAddressDao;
import club.banyuan.dao.UserDao;
import club.banyuan.pojo.UserAddress;
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

public class TestUserAddressDao {
    SqlSession session = null;
    UserAddressDao userAddressDao = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        session = sqlSessionFactory.openSession();
        userAddressDao = session.getMapper(UserAddressDao.class);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

    @Test
    public void testGetAddressByUserId() {
        List<UserAddress> userAddressList = userAddressDao.getAddressByUserId(2);
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress);
        }
    }

}
