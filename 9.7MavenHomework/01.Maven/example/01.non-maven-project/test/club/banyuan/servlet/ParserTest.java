package club.banyuan.servlet;

import club.banyuan.main.Main;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

  @Test
  public void parserTest() throws Exception {
    try (InputStream resourceAsStream = Main.class.getClassLoader()
        .getResourceAsStream("web.xml");) {
      List<MyServlet> parse = ServletParser.parse(resourceAsStream);
      Assert.assertEquals(parse.size(), 2);

      List<MyServlet> expect = new ArrayList<>();
      expect.add(new MyServlet("twoServlet", "/twoServlet", "club.banyuan.servlet.TwoServlet"));
      expect.add(new MyServlet("oneServlet", "/oneServlet", "club.banyuan.servlet.OneServlet"));
      Assert.assertTrue(expect.containsAll(parse));

      System.out.println(parse);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }
  }
}
