import club.banyuan.dao.ProductDao;
import club.banyuan.dao.UserDao;
import club.banyuan.pojo.Product;
import club.banyuan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestProductDao {
    @Test
    public void testGetAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        ProductDao productDao = session.getMapper(ProductDao.class);
        List<Product> productList = productDao.getAll();

        System.out.println(productList.size());

        for (Product product : productList) {
            System.out.println(product);
        }

        session.commit();
        session.close();
    }
}
