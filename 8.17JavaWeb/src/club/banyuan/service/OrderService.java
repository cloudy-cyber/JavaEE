package club.banyuan.service;

import club.banyuan.pojo.Order;
import club.banyuan.pojo.OrderDetail;

import java.util.List;

public interface OrderService {
    public Order createOrder(Order order, List<OrderDetail> orderDetailList);
}
