package club.banyuan.dao.impl;

import club.banyuan.dao.UserAddressDao;
import club.banyuan.pojo.UserAddress;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAddressDaoImpl extends BaseDaoImpl implements UserAddressDao {
    public UserAddressDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<UserAddress> getUserAddressByUserId(int userId) throws Exception {
        List<UserAddress> userAddressList = new ArrayList<>();
        String sql = "select * from user_address where userId = ?";
        Object[] param = new Object[]{userId};

        ResultSet rs = this.executeQuery(sql, param);
        while (rs.next()) {
            UserAddress userAddress = tableToClass(rs);
            userAddressList.add(userAddress);
        }
        return userAddressList;
    }

    @Override
    public UserAddress tableToClass(ResultSet rs) throws Exception {
        UserAddress userAddress = new UserAddress();
        userAddress.setId(rs.getInt(1));
        userAddress.setUserId(rs.getInt(2));
        userAddress.setAddress(rs.getString(3));
        userAddress.setCreateTime((Date) rs.getObject(4));
        userAddress.setIsDefault(rs.getInt(5));
        userAddress.setRemark(rs.getString(6));

        return userAddress;
    }
}

