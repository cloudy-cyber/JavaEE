package club.banyuan.dao;

import club.banyuan.pojo.Product;
import club.banyuan.vo.PageVO;
import club.banyuan.vo.ProductVO;

import java.util.List;
import java.util.Map;

public interface ProductDao {
    public List<Product> getAll();

    public List<Product> getProductByPrice(Map map);

    public List<Product> getProductByNameOrDesc(String key);

    public List<Product> getProductByParam(ProductVO productVO);

    public int countProductRows();

    public List<PageVO> countLevel1ProductRows();

    public List<Product> getProductByParam2(Map map);
}
