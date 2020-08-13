package homework.jdbc;

import homework.pojo.User;
import pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection conn = JdbcUtils.getConnection();
        //注册
        String sql = "insert into user (loginName,password) values(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, "aaaa");
        pstm.setString(2, "12345");
//        pstm.executeUpdate();
        JdbcUtils.closeConnection(conn, pstm);

        //登录
        conn = JdbcUtils.getConnection();
        String sql1 = "select * from user where loginName = ? and password = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1);
        pstm1.setString(1, "aaaa");
        pstm1.setString(2, "12345");
        ResultSet rs = pstm1.executeQuery();

        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setLoginName(rs.getString(2));
            user.setUserName(rs.getString(3));
            user.setPassword(rs.getString(4));
            user.setSex(rs.getInt(5));
            user.setIdentityCode(rs.getString(6));
            user.setEmail(rs.getString(7));
            user.setMobile(rs.getString(8));
            user.setType(rs.getInt(9));

            userList.add(user);
        }
        for (User user : userList) {
            System.out.println(user);
        }
        JdbcUtils.closeConnection(conn,pstm1);
        //查华为
        conn = JdbcUtils.getConnection();
        String sql2 = "select * from product where name like %?%";
        PreparedStatement pstm2 =conn.prepareStatement(sql2);

    }
}
