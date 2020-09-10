package club.banyuan.admin.dao.impl;

import static org.junit.Assert.*;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AdminDaoImplTest {

  @Test
  public void addAdmin() {
    AdminDao adminDao = new AdminDaoDbUtilsImpl();

    Admin zhangsan = adminDao.getAdmin("张三", "f27ec6559ada79218cb450c03bbbbf7661570e75e7e3cc1d9c63a70ef62ac1ad");
    if (zhangsan != null) {
      adminDao.deleteAdmin(zhangsan);
    }

    Admin admin = new Admin();
    admin.setUsername("张三");
    admin.setPassword("f27ec6559ada79218cb450c03bbbbf7661570e75e7e3cc1d9c63a70ef62ac1ad");
    adminDao.addAdmin(admin);
    zhangsan = adminDao.getAdmin("张三", "f27ec6559ada79218cb450c03bbbbf7661570e75e7e3cc1d9c63a70ef62ac1ad");
    assertNotNull(zhangsan);
    assertEquals("张三", zhangsan.getUsername());
    assertEquals("f27ec6559ada79218cb450c03bbbbf7661570e75e7e3cc1d9c63a70ef62ac1ad", zhangsan.getPassword());

    // List<Admin> adminList = adminDao.getAdminList();
    // assertEquals(2, adminList.size());

    zhangsan.setUsername("李四");
    zhangsan.setPassword("654321");
    adminDao.updateAdmin(zhangsan);

    Admin old = adminDao.getAdmin("张三", "123456");
    assertNull(old);

    zhangsan.setUsername("张三");
    zhangsan.setPassword("123456");
    adminDao.updateAdmin(zhangsan);

    old = adminDao.getAdmin("张三", "123456");
    assertNotNull(old);

    adminDao.deleteAdmin(zhangsan);
    old = adminDao.getAdmin("张三", "123456");
    assertNull(old);

  }
}