package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        jdbc driver class name
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
//        数据库连接字符串
        //连接协议，mysql的ip，端口，数据库名
        String url="jdbc:mysql://localhost:3306/db3?&useSSL=false&serverTimezone=UTC";
        // 登录mysql用户名
        String udername = "root";
        // 登录mysql密码
        String password = "12345678";

//        加载jdbc驱动类
        Class.forName(jdbcDriver);
//        创建数据库连接
        Connection conn = DriverManager.getConnection(url,udername,password);
//        创建Statement对象，用于执行sql语句
        Statement stmt = conn.createStatement();
        String sql = "insert into student(name,gender,birthday)\n" +
                "values ('ccc',false,'1999-3-2');";
//        执行executeXXX()执行sql
//            如果是非查询sql executeUpdateZ()
//            如果是查询sql executeQuery()
        int count = stmt.executeUpdate(sql);
        System.out.println(count);

        stmt.close();
        conn.close();
    }
}
