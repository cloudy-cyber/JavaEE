package jdbc;

import java.sql.*;
import java.util.Date;

public class Test3 {
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
        String sql = "select * from student";
//        执行executeXXX()执行sql
//            如果是非查询sql executeUpdateZ()
//            如果是查询sql executeQuery()
//        ResultSet 看成指针(游标)，指向查询结果集第一行的上面
//                如果要读取结果集中的第一行数据，需要将ResultSet向下移动一行
//                如果要读取第二行，继续向下移动一行，以此类推，直到next()返回值为false
        ResultSet rs =stmt.executeQuery(sql);
        while(rs.next()){
//            取出一行数据中的某个列的值，getXXX(参数);
//            XXX是转换后的java类型，自动类型转换
//                    参数可以写整型，查询结果中列的索引，从1开始
//                        也可以写列名
            int id = rs.getInt(1);
            String name = rs.getString(2);
            boolean sex = rs.getBoolean(3);
//            Date birthday = rs.getDate(4);
            Date birthday = rs.getDate("birthday");

            System.out.println(id+"\t" + name+"\t"+sex+"\t"+birthday);
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
