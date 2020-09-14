package club.banyuan.admin.dao.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import club.banyuan.common.ServerException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
public class AdminDaoDbUtilsImpl implements AdminDao {

    @Autowired
    private QueryRunner qr;

    @Override
    public List<Admin> getAdminByName(String name) {
        String sql = "select * from admin where username = ?";
        try {
            return qr.query(sql, new BeanListHandler<>(Admin.class), name);
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        String sql = "insert into admin (username,password) values(?,?)";
        try {
            BigInteger id = qr.insert(sql, new ScalarHandler<>(1), admin.getUsername(), admin.getPassword());
        } catch (SQLException e) {
            throw new ServerException(e);
        }

    }

    @Override
    public void updateAdmin(Admin admin) {
        String sql = "update admin set username = ?,password = ? where id = ?";
        try {
            qr.update(sql, admin.getUsername(), admin.getPassword(), admin.getId());
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public void deleteAdmin(Admin admin) {
        String sql = "delete from admin where id = ?";
        try {
            qr.update(sql, admin.getId());
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public void deleteAdmin(List<Integer> adminList) {
        String sql = "DELETE  FROM t_admin WHERE id=?";
        try {
            // [40, 41] =>  [[40], [41]]
            Object[][] params = new Object[adminList.size()][1];
            for (int i = 0; i < adminList.size(); i++) {
                params[i][0] = adminList.get(i);
            }
            qr.batch(sql, params);
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public List<Admin> getAdminList() {
        String sql = "select * from admin";
        try {
            return qr.query(sql,new BeanListHandler<>(Admin.class));
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public List<Admin> getAdminList(String username) {
        String sql = "select * from admin where username like ?";
        try {
            return qr.query(sql,new BeanListHandler<>(Admin.class),"%"+username+"%");
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public Admin getAdmin(String username, String password) {
        String sql = "select * from admin where username = ? and password = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Admin.class),username,password);
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public Admin getAdminById(int id) {
        String sql = "select * from admin where id = ?";
        try {
            return qr.query(sql,new BeanHandler<>(Admin.class),id);
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public List<Admin> getAdminListPage(String name, int page, int row) {
        try {
            if (name == null || name.length() == 0) {
                String sql = "SELECT * FROM t_admin LIMIT  ?, ?";
                return qr.query(sql, new BeanListHandler<>(Admin.class), (page - 1) * row, row);
            } else {
                String sql = "SELECT * FROM t_admin WHERE username LIKE ? LIMIT ?,?";
                return qr.query(sql, new BeanListHandler<>(Admin.class), "%" + name + "%", (page - 1) * row,
                        row);
            }
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }

    @Override
    public int getAdminListPageCount(String name) {
        try {
            ScalarHandler<Long> rsh = new ScalarHandler<>();
            if (name == null || name.length() == 0) {
                String sql = "SELECT count(*) FROM t_admin";
                return qr.query(sql, rsh).intValue();
            } else {
                String sql = "SELECT count(*) FROM t_admin WHERE username LIKE ?";
                return qr.query(sql, rsh, "%" + name + "%").intValue();
            }
        } catch (SQLException e) {
            throw new ServerException(e);
        }
    }
}
