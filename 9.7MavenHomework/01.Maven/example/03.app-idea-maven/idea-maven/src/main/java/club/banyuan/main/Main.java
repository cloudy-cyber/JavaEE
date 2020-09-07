package club.banyuan.main;

import club.banyuan.servlet.MyServlet;
import club.banyuan.servlet.ServletParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Main {

  public static void main(String[] args) throws Exception {
    try (InputStream resourceAsStream = Main.class.getClassLoader()
        .getResourceAsStream("web.xml");) {
      List<MyServlet> parse = ServletParser.parse(resourceAsStream);
      System.out.println(parse);
    }
  }

  // public static void main(String[] args) throws Exception {
  //   InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("web.xml");
  //
  //   // 调用dom4j 的对象，用来解析 web.xml的流
  //   SAXReader reader = new SAXReader();
  //   // 将web.xml的数据，转换为了Document对象，后续获取其中的内容，只需要操作Document对象
  //   Document document = reader.read(resourceAsStream);
  //   // 从Document对象中获取根元素，所有的其他元素，都是根元素的子元素
  //   Element rootElement = document.getRootElement();
  //
  //   // 保存解析结果的集合
  //   List<MyServlet> rlt = new ArrayList<>();
  //
  //   // name = oneServlet
  //   // class = club.banyuan.servlet.OneServlet
  //
  //   // name = twoServlet
  //   // class = club.banyuan.servlet.TwoServlet
  //   List<Element> servletList = rootElement.elements("servlet");
  //   for (Element element : servletList) {
  //     MyServlet myServlet = new MyServlet();
  //     String name = element.element("servlet-name").getText();
  //     String className = element.element("servlet-class").getText();
  //     myServlet.setClassName(className);
  //     myServlet.setName(name);
  //     rlt.add(myServlet);
  //     System.out.println("name:" + name);
  //     System.out.println("className:" + className);
  //   }
  //
  //   // name = oneServlet
  //   // url = /oneServlet
  //
  //   // name = twoServlet
  //   // url = /twoServlet
  //   List<Element> mappingList = rootElement.elements("servlet-mapping");
  //   for (Element element : mappingList) {
  //
  //     String name = element.element("servlet-name").getText();
  //     String url = element.element("url-pattern").getText();
  //     for (MyServlet myServlet : rlt) {
  //       if (myServlet.getName().equals(name)) {
  //         myServlet.setUrl(url);
  //       }
  //     }
  //     System.out.println("name:" + name);
  //     System.out.println("url:" + url);
  //   }
  //
  //   System.out.println(rlt);
  // }
}
