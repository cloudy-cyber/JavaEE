import club.banyuan.dao.AdminDao;
import club.banyuan.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestAdminDao {
    SqlSession session = null;
    AdminDao adminDao = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        session = sqlSessionFactory.openSession();
        adminDao = session.getMapper(AdminDao.class);
    }
    @After
    public void destroy(){
        session.commit();
        session.close();
    }

    public void print(List<Admin> adminList){
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
    @Test
    public void testAddAdmin(){
        Admin admin = new Admin();
        admin.setAdminName("方七号");
        admin.setPwd("123");
        Admin admin1 =new Admin();
        admin1.setAdminName("石欢程");
        admin1.setPwd("456");
        adminDao.addAdmin(admin);
        adminDao.addAdmin(admin1);
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        adminList.add(admin1);
        print(adminList);
    }

    @Test
    public void testDelAdmin(){
        adminDao.delAdmin(4);
    }

    @Test
    public void testUpdateAdmin(){
        Admin admin=new Admin();
        admin.setId(5);
        admin.setAdminName("测试2");
        admin.setPwd("1234567");
        adminDao.updateAdmin(admin);
    }
    @Test
    public void testGetAll(){
        print(adminDao.getAll());
    }
}
