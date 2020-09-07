package club.banyuan.servlet;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServletParser {

  public static List<MyServlet> parse(InputStream inputStream) throws Exception {
    // 调用dom4j 的对象，用来解析 web.xml的流
    SAXReader reader = new SAXReader();
    // 将web.xml的数据，转换为了Document对象，后续获取其中的内容，只需要操作Document对象
    Document document = reader.read(inputStream);
    // 从Document对象中获取根元素，所有的其他元素，都是根元素的子元素
    Element rootElement = document.getRootElement();

    // 使用map存放结果
    Map<String, MyServlet> servletMap = new HashMap<>();

    // name = oneServlet
    // class = club.banyuan.servlet.OneServlet

    // name = twoServlet
    // class = club.banyuan.servlet.TwoServlet
    List<Element> servletList = rootElement.elements("servlet");
    for (Element element : servletList) {
      MyServlet myServlet = new MyServlet();
      String name = element.element("servlet-name").getText();
      String className = element.element("servlet-class").getText();
      myServlet.setClassName(className);
      myServlet.setName(name);
      servletMap.put(myServlet.getName(), myServlet);
      // rlt.add(myServlet);
      System.out.println("name:" + name);
      System.out.println("className:" + className);
    }

    // name = oneServlet
    // url = /oneServlet

    // name = twoServlet
    // url = /twoServlet
    List<Element> mappingList = rootElement.elements("servlet-mapping");
    for (Element element : mappingList) {

      String name = element.element("servlet-name").getText();
      String url = element.element("url-pattern").getText();
      // 这里使用map存放结果，减少遍历获取匹配名字的次数
      MyServlet myServlet = servletMap.get(name);
      if (myServlet == null) {
        throw new RuntimeException("xml文件不合法");
      }

      myServlet.setUrl(url);

      System.out.println("name:" + name);
      System.out.println("url:" + url);
    }

    return new ArrayList<>(servletMap.values());
  }
}
