package test;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import dao.util.DataSourceUtil;
import org.junit.Test;
import pojo.Product;

import java.sql.Connection;
import java.util.List;

public class TestProductDao {
    @Test
    public void testGetProductByKeyWords() throws Exception {
        Connection connection = DataSourceUtil.openConnection();
        ProductDao productDao = new ProductDaoImpl(connection);
        List<Product>productList=productDao.getProductByKeyWords("华为");
        for (Product product : productList) {
            System.out.println(product);
        }
        DataSourceUtil.closeConnection(connection);
    }
}
