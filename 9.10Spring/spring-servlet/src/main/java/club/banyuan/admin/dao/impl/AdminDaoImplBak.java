// package club.banyuan.admin.dao.impl;
//
// import club.banyuan.admin.dao.AdminDao;
// import club.banyuan.admin.entity.Admin;
// import club.banyuan.common.ServerException;
// import club.banyuan.util.DBUtil;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
//
// public class AdminDaoImplBak implements AdminDao {
//
//   @Override
//   public void addAdmin(Admin admin) {
//     Connection conn = DBUtil.open();
//     String sql = "INSERT INTO t_admin (username, password) VALUES (?,?)";
//     PreparedStatement statement = null;
//     try {
//       statement = conn.prepareStatement(sql);
//       statement.setObject(1, admin.getUsername());
//       statement.setObject(2, admin.getPassword());
//
//       statement.executeUpdate();
//     } catch (SQLException e) {
//       throw new ServerException(e);
//     } finally {
//       try {
//         statement.close();
//       } catch (SQLException throwables) {
//         throwables.printStackTrace();
//       }
//       try {
//         conn.close();
//       } catch (SQLException throwables) {
//         throwables.printStackTrace();
//       }
//     }
//
//   }
//
//   @Override
//   public void updateAdmin(Admin admin) {
//
//   }
//
//   @Override
//   public void deleteAdmin(Admin admin) {
//
//   }
//
//   @Override
//   public List<Admin> getAdminList() {
//     Connection conn = DBUtil.open();
//     String sql = "SELECT * FROM t_admin";
//     PreparedStatement statement = null;
//     List<Admin> rlt = new ArrayList<>();
//     try {
//       statement = conn.prepareStatement(sql);
//
//       ResultSet resultSet = statement.executeQuery();
//
//       while (resultSet.next()) {
//         Admin admin = new Admin();
//         admin.setId(resultSet.getInt(1));
//         admin.setUsername(resultSet.getString(2));
//         admin.setPassword(resultSet.getString(3));
//         admin.setRoleName(resultSet.getString(4));
//         rlt.add(admin);
//       }
//
//       return rlt;
//     } catch (SQLException e) {
//       throw new ServerException(e);
//     } finally {
//       try {
//         statement.close();
//       } catch (SQLException throwables) {
//         throwables.printStackTrace();
//       }
//       try {
//         conn.close();
//       } catch (SQLException throwables) {
//         throwables.printStackTrace();
//       }
//     }
//   }
//
//   @Override
//   public Admin getAdmin(String username, String password) {
//     Connection conn = DBUtil.open();
//     String sql = "SELECT * FROM t_admin WHERE username=? AND password=?";
//     PreparedStatement statement = null;
//     try {
//       statement = conn.prepareStatement(sql);
//
//       statement.setObject(1, username);
//       statement.setObject(2, password);
//
//       ResultSet resultSet = statement.executeQuery();
//
//       if (resultSet.next()) {
//         Admin admin = new Admin();
//         admin.setId(resultSet.getInt(1));
//         admin.setUsername(resultSet.getString(2));
//         admin.setPassword(resultSet.getString(3));
//         admin.setRoleName(resultSet.getString(4));
//         return admin;
//       }
//
//       return null;
//     } catch (SQLException e) {
//       throw new ServerException(e);
//     } finally {
//       try {
//         statement.close();
//       } catch (SQLException throwables) {
//         throwables.printStackTrace();
//       }
//       try {
//         conn.close();
//       } catch (SQLException throwables) {
//         throwables.printStackTrace();
//       }
//     }
//   }
// }
