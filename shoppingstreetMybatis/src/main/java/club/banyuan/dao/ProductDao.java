package club.banyuan.dao;

import club.banyuan.pojo.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProductByKeyWords(String keyWords);

    public Product getProductById(int id);
}
