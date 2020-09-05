import club.banyuan.dao.OrderDao;
import club.banyuan.dao.ProductDao;
import club.banyuan.pojo.Order;
import club.banyuan.vo.OrderVo;
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

public class TestOrderDao {
    SqlSession session = null;
    OrderDao orderDao = null;

    @Before
    public void init() throws IOException {
        //        获取连接信息（配置在SqlMapConfig.xml）,所以读取配置文件
//        在classpath下找SqlMapConfig.xml，并读取到InputStream流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactory创建管理连接，实例化Factory，将数据库信息传递给它
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        创建Session对象：
//                类似Connection，强大
        session = sqlSessionFactory.openSession();

//        获取dao接口的实现类对象
        orderDao = session.getMapper(OrderDao.class);
    }

    @After
    public void destroy() {
        //事务提交
        session.commit();
//        资源关闭
        session.close();
    }


    @Test
    public void testGetOrderByUserId() {
        List<OrderVo> orderVos = orderDao.getOrderByUserId(18);
        for (OrderVo orderVo : orderVos) {
            System.out.println(orderVo);
        }
    }

    @Test
    public void testGetOrderByUserId2(){
        List<Order> orders = orderDao.getOrderByUserId2(18);
        for (Order order : orders) {
            System.out.println(order);
            System.out.println(order.getUser());
        }
    }
}
