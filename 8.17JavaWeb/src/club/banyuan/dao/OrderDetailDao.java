package club.banyuan.dao;

import club.banyuan.pojo.OrderDetail;

public interface OrderDetailDao extends IBaseDao {
    public OrderDetail addOrderDetail(OrderDetail orderDetail);
}
