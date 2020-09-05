package club.banyuan.service.impl;

import club.banyuan.dao.AdminDao;
import club.banyuan.dao.impl.AdminDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.Admin;
import club.banyuan.service.AdminService;

import java.sql.Connection;

public class AdminServiceImpl implements AdminService {
    @Override
    public Admin login(String userName, String password) throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        AdminDao adminDao = new AdminDaoImpl(conn);
        Admin newAdmin = adminDao.getAdminByUserNameAndPassword(userName, password);
        DataSourceUtil.closeConnection(conn);
        return newAdmin;
    }
}
