package club.banyuan.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

  private static Properties properties;

  static {
    InputStream in = PropUtil.class.getResourceAsStream("/app.properties");
    properties = new Properties();
    try {
      properties.load(in);
    } catch (IOException e) {
      throw new RuntimeException("加载配置文件失败", e);
    }
  }

  public static String getProp(String key) {
    return properties.getProperty(key);
  }

}
