package club.banyuan.main;

import club.banyuan.admin.dao.impl.AdminDaoDbUtilsImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    AdminDaoDbUtilsImpl imp1 = new AdminDaoDbUtilsImpl();

    ApplicationContext context = new ClassPathXmlApplicationContext(
        "spring/applicationContext.xml");
    AdminDaoDbUtilsImpl imp2 = context
        .getBean("adminDaoDbUtilsImpl", AdminDaoDbUtilsImpl.class);

    System.out.println("imp1:" + imp1.getQr());
    System.out.println("imp2:" + imp2.getQr());
  }
}
