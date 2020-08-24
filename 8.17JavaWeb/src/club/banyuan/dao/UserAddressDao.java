package club.banyuan.dao;

import club.banyuan.pojo.UserAddress;

import java.util.List;

public interface UserAddressDao extends IBaseDao{
    public List<UserAddress> getUserAddressByUserId(int userId) throws Exception;
}
