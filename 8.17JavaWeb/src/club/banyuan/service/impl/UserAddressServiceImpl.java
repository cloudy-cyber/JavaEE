package club.banyuan.service.impl;

import club.banyuan.dao.UserAddressDao;
import club.banyuan.dao.impl.UserAddressDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.UserAddress;
import club.banyuan.service.UserAddressService;

import java.sql.Connection;
import java.util.List;

public class UserAddressServiceImpl implements UserAddressService {
    @Override
    public List<UserAddress> getUserAddressByUserId(int userId) throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        UserAddressDao userAddressDao = new UserAddressDaoImpl(conn);
        List<UserAddress> userAddressList = userAddressDao.getUserAddressByUserId(userId);

        DataSourceUtil.closeConnection(conn);

        return userAddressList;
    }
}
