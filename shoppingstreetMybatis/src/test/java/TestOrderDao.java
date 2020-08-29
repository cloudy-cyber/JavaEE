import club.banyuan.dao.OrderDao;
import club.banyuan.dao.OrderDetailDao;
import club.banyuan.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestOrderDao {
    SqlSession session = null;
    OrderDao orderDao = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        session = sqlSessionFactory.openSession();
        orderDao = session.getMapper(OrderDao.class);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
//        order.setUserId(28);
//        order.setLoginName("房企豪");
//        order.setUserAddress("花园洋房");
//        order.setCreateTime(new Date());
//        order.setCost(231);
//        order.setSerialNumber("23123");
        orderDao.addOrder(order);
    }
}
