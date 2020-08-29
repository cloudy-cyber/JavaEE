import club.banyuan.dao.OrderDetailDao;
import club.banyuan.dao.UserAddressDao;
import club.banyuan.pojo.OrderDetail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestOrderDetailDao {
    SqlSession session = null;
    OrderDetailDao orderDetailDao = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        session = sqlSessionFactory.openSession();
        orderDetailDao = session.getMapper(OrderDetailDao.class);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

    @Test
    public void addOrderDetail() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(10);
        orderDetail.setProductId(789);
        orderDetail.setQuantity(8);
        orderDetail.setCost(999);
        orderDetailDao.addOrderDetail(orderDetail);
    }
}
