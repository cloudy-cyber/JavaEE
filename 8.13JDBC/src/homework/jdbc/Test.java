package homework.jdbc;

import homework.pojo.Product;
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
        String sql2 = "select * from product where name like ?";
        PreparedStatement pstm2 =conn.prepareStatement(sql2);
        pstm2.setString(1,"%华为%");
        ResultSet rs2 = pstm2.executeQuery();
        List<Product> productList=new ArrayList<>();
        while (rs2.next()){
            Product product=new Product();
            product.setId(rs2.getInt(1));
            product.setName(rs2.getString(2));
            product.setDescription(rs2.getString(3));
            product.setPrice(rs2.getFloat(4));
            product.setStock(rs2.getInt(5));
            product.setCategoryLevel1Id(rs2.getInt(6));
            product.setCategoryLevel2Id(rs2.getInt(7));
            product.setCategoryLevel3Id(rs2.getInt(8));
            product.setFileName(rs2.getString(9));
            product.setIsDelete(rs2.getInt(10));
            productList.add(product);
        }
        for (Product product : productList) {
            System.out.println(product);
        }
        JdbcUtils.closeConnection(conn,pstm2);
    }
}
