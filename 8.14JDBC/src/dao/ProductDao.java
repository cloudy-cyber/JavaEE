package dao;

import pojo.Product;

import java.util.List;

public interface ProductDao extends IBaseDao {
    public List<Product> getProductByKeyWords(String keyWords) throws Exception;
}
