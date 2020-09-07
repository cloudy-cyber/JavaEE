package club.banyuan.maven.task3;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

public class Hello {
    public static void main(final String... args) {
        System.out.println(StringUtils.join(Lists.newArrayList("Hello,", "world!"), " "));
        new Hello().verifyJunitNotOnClasspath();
    }

    private void verifyJunitNotOnClasspath() {
        try {
            this.getClass().getClassLoader().loadClass("org.junit.Test");
            throw new RuntimeException("JUnit should not be on main classpath, booh!");
        } catch (ClassNotFoundException e) {
            System.out.println("JUnit not on main classpath, yay!");
        }
    }
}
