package club.banyuan.dao.impl;

import club.banyuan.dao.AdminDao;
import club.banyuan.pojo.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl extends BaseDaoImpl implements AdminDao {
    public AdminDaoImpl(Connection conn) {
        super(conn);
    }

    @Override
    public Admin getAdminByUserNameAndPassword(String userName, String password) throws Exception {
        Admin admin = null;
        String sql = "select * from admin where username=? and password=?";
        ResultSet rs = executeQuery(sql, new Object[]{userName, password});
        if (rs.next()) {
            admin = tableToClass(rs);
        }
        this.closeResource(rs);
        return admin;
    }

    @Override
    public Admin tableToClass(ResultSet rs) throws Exception {
        Admin admin = new Admin();
        admin.setId(rs.getInt(1));
        admin.setUserName(rs.getString(2));
        admin.setRoleName(rs.getString(3));
        admin.setPassword(rs.getString(4));
        return admin;
    }
}
