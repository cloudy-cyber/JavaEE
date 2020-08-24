package club.banyuan.dao;

import club.banyuan.pojo.Order;
import club.banyuan.pojo.OrderDetail;

public interface OrderDao extends IBaseDao {
    public Order addOrder(Order order);
}
