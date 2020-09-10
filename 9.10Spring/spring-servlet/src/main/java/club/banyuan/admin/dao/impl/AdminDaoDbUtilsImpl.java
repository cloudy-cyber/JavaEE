package club.banyuan.admin.dao.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import club.banyuan.common.ServerException;
import club.banyuan.util.DBUtil;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class AdminDaoDbUtilsImpl implements AdminDao {

  private QueryRunner qr;

  public AdminDaoDbUtilsImpl() {
  }

  public AdminDaoDbUtilsImpl(QueryRunner qr) {
    this.qr = qr;
  }

  public QueryRunner getQr() {
    return qr;
  }

  public void setQr(QueryRunner qr) {
    this.qr = qr;
  }

  @Override
  public List<Admin> getAdminByName(String name) {
    String sql = "SELECT * FROM admin WHERE username=?";
    try {
      return qr.query(sql, new BeanListHandler<>(Admin.class), name);
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public void addAdmin(Admin admin) {
    String sql = "INSERT INTO admin (username, password) VALUES (?,?)";
    try {
      BigInteger id = qr
          .insert(sql, new ScalarHandler<>(), admin.getUsername(), admin.getPassword());
      System.out.println("自增的id主键：" + id);
    } catch (SQLException e) {
      throw new ServerException(e);
    }

  }

  @Override
  public void updateAdmin(Admin admin) {
    String sql = "UPDATE admin SET username=?, password=? WHERE id=?";
    try {
      qr.update(sql, admin.getUsername(), admin.getPassword(), admin.getId());
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public void deleteAdmin(Admin admin) {
    String sql = "DELETE  FROM admin WHERE id=?";
    try {
      qr.update(sql, admin.getId());
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public void deleteAdmin(List<Integer> adminList) {
    String sql = "DELETE  FROM admin WHERE id=?";
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
    String sql = "SELECT * FROM admin";
    try {
      return qr.query(sql, new BeanListHandler<>(Admin.class));
    } catch (SQLException e) {
      throw new ServerException(e);
    }
  }

  @Override
  public List<Admin> getAdminList(String username) {
    Connection conn = DBUtil.open();
    String sql = "SELECT * FROM admin WHERE username LIKE ?";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = conn.prepareStatement(sql);
      DBUtil.prepareStatement(statement, "%" + username + "%");
      resultSet = statement.executeQuery();

      return DBUtil.parseList(resultSet, Admin.class);
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }
  }

  @Override
  public Admin getAdmin(String username, String password) {
    Connection conn = DBUtil.open();
    String sql = "SELECT * FROM admin WHERE username=? AND password=?";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = conn.prepareStatement(sql);
      DBUtil.prepareStatement(statement, username, password);
      resultSet = statement.executeQuery();
      return DBUtil.parse(resultSet, Admin.class);

    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }
  }

  @Override
  public Admin getAdminById(int id) {
    Connection conn = DBUtil.open();
    String sql = "SELECT * FROM admin WHERE id=?";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = conn.prepareStatement(sql);
      DBUtil.prepareStatement(statement, id);
      resultSet = statement.executeQuery();
      return DBUtil.parse(resultSet, Admin.class);

    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }
  }

  @Override
  public List<Admin> getAdminListPage(String name, int page, int row) {

    Connection conn = DBUtil.open();

    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      // 1 5
      // 0条数据开始查询5条
      // 2 5
      // 5条数据开始 查询5条
      // (page - 1) * row
      // limit n  => 查询n条数据，从第0条起始
      // limit n,m => 查询从n条记录开始，查询m条数据
      if (name == null || name.length() == 0) {
        String sql = "SELECT * FROM admin LIMIT  ?, ?";
        statement = conn.prepareStatement(sql);
        DBUtil.prepareStatement(statement, (page - 1) * row, row);
      } else {
        String sql = "SELECT * FROM admin WHERE username LIKE ? LIMIT ?,?";
        statement = conn.prepareStatement(sql);
        DBUtil.prepareStatement(statement, "%" + name + "%", (page - 1) * row, row);
      }

      resultSet = statement.executeQuery();

      return DBUtil.parseList(resultSet, Admin.class);
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }
  }

  @Override
  public int getAdminListPageCount(String name) {

    Connection conn = DBUtil.open();

    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {

      if (name == null || name.length() == 0) {
        String sql = "SELECT count(*) FROM admin";
        statement = conn.prepareStatement(sql);
      } else {
        String sql = "SELECT count(*) FROM admin WHERE username LIKE ?";
        statement = conn.prepareStatement(sql);
        DBUtil.prepareStatement(statement, "%" + name + "%");
      }

      resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt(1);
      }
      return 0;
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }
  }
}
