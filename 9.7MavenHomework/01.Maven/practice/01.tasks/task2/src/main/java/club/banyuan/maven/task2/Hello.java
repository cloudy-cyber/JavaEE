package club.banyuan.maven.task2;


import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

//不要修改这个类
public class Hello {

  public static void main(final String... args) {
    System.out.println(StringUtils.join(Lists.newArrayList("Hello,", "world!"), " "));
  }
}
