package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestProperties {
    @org.junit.Test
    public void testProp() throws IOException, ClassNotFoundException, SQLException {
        InputStream inputStream =
                TestProperties.class.getClassLoader()
                        .getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println(url);
        System.out.println(driver);
        System.out.println(username);
        System.out.println(password);

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        System.out.println(conn);
    }
}