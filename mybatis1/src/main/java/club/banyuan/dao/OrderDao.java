package club.banyuan.dao;

import club.banyuan.pojo.Order;
import club.banyuan.vo.OrderVo;

import java.util.List;

public interface OrderDao {
    public List<OrderVo> getOrderByUserId(int id);

    public List<Order> getOrderByUserId2(int id);
}
