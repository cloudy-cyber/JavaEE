package club.banyuan.admin.dao.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import club.banyuan.common.ServerException;
import club.banyuan.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

  @Override
  public List<Admin> getAdminByName(String name) {
    Connection conn = DBUtil.open();
    String sql = "SELECT * FROM admin WHERE username=?";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = conn.prepareStatement(sql);
      DBUtil.prepareStatement(statement, name);
      resultSet = statement.executeQuery();

      return DBUtil.parseList(resultSet, Admin.class);
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }
  }

  @Override
  public void addAdmin(Admin admin) {
    Connection conn = DBUtil.open();
    String sql = "INSERT INTO admin (username, password) VALUES (?,?)";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      // 使用这种方式获取插入的记录分配的id主键的值
      statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      DBUtil.prepareStatement(statement, admin.getUsername(), admin.getPassword());

      statement.executeUpdate();
      resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        int anInt = resultSet.getInt(1);
        System.out.println("自增的id主键：" + anInt);
      }
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
    }

  }

  @Override
  public void updateAdmin(Admin admin) {
    Connection conn = DBUtil.open();
    String sql = "UPDATE admin SET username=?, password=? WHERE id=?";
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement(sql);
      DBUtil.prepareStatement(statement, admin.getUsername(), admin.getPassword(), admin.getId());

      statement.executeUpdate();
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(statement, conn);
    }
  }

  @Override
  public void deleteAdmin(Admin admin) {
    Connection conn = DBUtil.open();
    String sql = "DELETE  FROM admin WHERE id=?";
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement(sql);
      DBUtil.prepareStatement(statement, admin.getId());

      statement.executeUpdate();
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(statement, conn);
    }
  }

  @Override
  public void deleteAdmin(List<Integer> adminList) {
    Connection conn = DBUtil.open();
    String sql = "DELETE  FROM admin WHERE id=?";
    PreparedStatement statement = null;
    try {
      statement = conn.prepareStatement(sql);
      for (Integer id : adminList) {
        DBUtil.prepareStatement(statement, id);
        statement.executeUpdate();
      }
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(statement, conn);
    }
  }

  @Override
  public List<Admin> getAdminList() {
    Connection conn = DBUtil.open();
    String sql = "SELECT * FROM admin";
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = conn.prepareStatement(sql);
      resultSet = statement.executeQuery();

      return DBUtil.parseList(resultSet, Admin.class);
    } catch (SQLException e) {
      throw new ServerException(e);
    } finally {
      DBUtil.close(resultSet, statement, conn);
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
