package club.banyuan.util;

import club.banyuan.admin.entity.Admin;
import club.banyuan.common.DBOrder;
import club.banyuan.common.ServerException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUtil {

  private static final String URL = PropUtil.getProp("db.url");
  private static final String DRIVER = PropUtil.getProp("db.driver");
  private static final String USERNAME = PropUtil.getProp("db.username");
  private static final String PASSWORD = PropUtil.getProp("db.password");

  private static ComboPooledDataSource dataSource;

  static {
    // ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    dataSource = new ComboPooledDataSource();
    // dataSource = context.getBean("dataSource", ComboPooledDataSource.class);
    try {
      dataSource.setDriverClass(DRIVER);
      dataSource.setJdbcUrl(URL);
      dataSource.setUser(USERNAME);
      dataSource.setPassword(PASSWORD);
    } catch (PropertyVetoException e) {
      throw new ServerException("数据源初始化失败", e);
    }
  }


  public static DataSource getDataSource() {
    return dataSource;
  }

  /**
   * 开启数据库连接
   *
   * @return
   */
  public static Connection open() {
    try {
      return dataSource.getConnection();
    } catch (SQLException throwables) {
      throw new ServerException("建立数据库连接失败", throwables);
    }

    // Connection connection = null;
    // try {
    //   Class.forName(DRIVER);
    //   connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    //   return connection;
    // } catch (ClassNotFoundException | SQLException e) {
    //   throw new ServerException("建立数据库连接失败", e);
    // }
  }

  public static void prepareStatement(PreparedStatement statement, Object... params)
      throws SQLException {
    // params是可变参数，变量可以看做是数组
    if (params == null || params.length == 0) {
      return;
    }

    for (int i = 0; i < params.length; i++) {
      statement.setObject(i + 1, params[i]);
    }
  }

  public static void close(AutoCloseable... target) {
    if (target == null || target.length == 0) {
      return;
    }

    for (AutoCloseable autoCloseable : target) {
      if (autoCloseable != null) {
        try {
          autoCloseable.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  // 对象.属性名 = 属性值
  // 首先要确定属性对象的访问权限 属性对象.setAccessible(true) 移除属性的访问权限的限制
  // 属性对象.set(对象,属性值)
  public static <T> T parse(ResultSet resultSet, Class<T> cls) {
    // 获取所有需要装填的成员变量列表
    List<Field> dbField = getDbField(cls);
    try {
      // 通过构造方法创建一个实例
      T rlt = cls.getConstructor().newInstance();
      if (resultSet.next()) {
        for (int i = 0; i < dbField.size(); i++) {
          // 取出 resultset中 和 成员变量关联的值
          Field field = dbField.get(i);
          Object value = resultSet.getObject(i + 1);
          // 将 value 值，设置到 rlt 这个对象中的， filed成员变量中
          field.setAccessible(true);
          field.set(rlt, value);
        }
        return rlt;
      }
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SQLException e) {
      throw new ServerException("装载对象失败", e);
    }
    return null;
  }

  public static <T> List<T> parseList(ResultSet resultSet, Class<T> cls) {

    List<T> rlt = new ArrayList<>();
    T one = parse(resultSet, cls);

    while (one != null) {
      rlt.add(one);
      one = parse(resultSet, cls);
    }

    return rlt;
  }


  private static List<Field> getDbField(Class<?> cls) {
    Field[] declaredFields = cls.getDeclaredFields();

    List<Field> fieldWithDbOrder = new ArrayList<>();
    for (Field declaredField : declaredFields) {
      DBOrder dbOrder = declaredField.getDeclaredAnnotation(DBOrder.class);
      if (dbOrder != null) {
        fieldWithDbOrder.add(declaredField);
      }
    }

    fieldWithDbOrder.sort(new Comparator<Field>() {
      @Override
      public int compare(Field o1, Field o2) {
        DBOrder d1 = o1.getDeclaredAnnotation(DBOrder.class);
        DBOrder d2 = o2.getDeclaredAnnotation(DBOrder.class);
        return d1.value() - d2.value();
      }
    });

    return fieldWithDbOrder;
  }
}
