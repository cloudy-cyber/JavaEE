package club.banyuan.dao.impl;

import club.banyuan.dao.OrderDetailDao;
import club.banyuan.pojo.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;

public class OrderDetailDaoImpl extends BaseDaoImpl implements OrderDetailDao {
    public OrderDetailDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        String sql = "insert into order_detail values(?, ?, ?, ?, ?)";
        Object[] param = new Object[5];
        param[0] = null;
        param[1] = orderDetail.getOrderId();
        param[2] = orderDetail.getProductId();
        param[3] = orderDetail.getQuantity();
        param[4] = orderDetail.getCost();
        int id = executeInsert(sql, param);
        orderDetail.setId(id);
        closeResource();
        return orderDetail;
    }

    @Override
    public Object tableToClass(ResultSet rs) throws Exception {
        return null;
    }
}
