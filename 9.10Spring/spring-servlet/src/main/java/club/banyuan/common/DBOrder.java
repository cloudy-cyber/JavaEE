package club.banyuan.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 反射的时候取出注解内容，必须使用runtime
@Retention(RetentionPolicy.RUNTIME)
// 标识注解生效的位置，必须修饰成员变量
@Target(ElementType.FIELD)
public @interface DBOrder {

  // 数据库列的编号
  int value();
}
