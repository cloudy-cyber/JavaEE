package club.banyuan.dao;

import club.banyuan.pojo.Admin;

import java.sql.SQLException;

public interface AdminDao extends IBaseDao{
    public Admin getAdminByUserNameAndPassword(String userName,String password) throws Exception;
}
