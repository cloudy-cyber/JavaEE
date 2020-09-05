import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {
    @Test
    public void testGetAll(){
        UserService userService = new UserServiceImpl();
        userService.getAll();
    }

    @Test
    public void testGetAllWitSpring(){
//        加载Spring配置文件
//        解析后 ：
//                id   ---  class类名
//                        依据class类名，进行实例化
//                得到：
//                id  ---  class类对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        // getBean：获取容器中id为userService的对象
        UserService userService = (UserService) ctx.getBean("userService");
        userService.getAll();
    }
}
