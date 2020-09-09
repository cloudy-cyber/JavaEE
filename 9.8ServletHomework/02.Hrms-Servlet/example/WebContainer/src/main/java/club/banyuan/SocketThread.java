package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SocketThread extends Thread {

  private Socket socket;

  public SocketThread(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {

      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      HttpServletRequestImpl request = new HttpServletRequestImpl();

      String line = reader.readLine();

      if (line == null || line.trim().length() == 0) {
        System.out.println("请求不合法");
        return;
      }

      String[] split = line.split("\\s+");
      request.contentPath = "/my-app";
      request.url = split[1];

      while (line != null && line.length() > 0) {
        System.out.println(line);
        line = reader.readLine();
      }

      String servletPath = request.url.replaceFirst("/my-app", "");

      String servletClass = getServletByPath(servletPath);

      File file = new File(
          "/Users/liyi/works/repos/banyuan/javaee-2041/02.Hrms-Servlet/example/WebContainer/target/classes/webapp/myservlet/");
      URL url = null;
      url = file.toURL();
      System.out.println("url--" + url.getPath());
      URL[] urls = {url};
      URLClassLoader classLoader = new URLClassLoader(urls);
      Class aClass = classLoader.loadClass(servletClass);

      // Class<?> aClass = Class.forName(servletClass);
      Object o = aClass.getConstructor().newInstance();
      HttpServlet httpServlet = (HttpServlet) o;

      httpServlet.service(request, new HttpServletResponseImpl());


    } catch (IOException | ClassNotFoundException | NoSuchMethodException | ServletException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }


  }

  private String getServletByPath(String servletPath) throws Exception {

    if (servletPath.endsWith("/")) {
      servletPath = servletPath.substring(0, servletPath.length() - 1);
    }
    System.out.println("=======================");
    System.out.println(SocketThread.class.getResource("/web.xml").getPath());
    List<MyServlet> parse = ServletParser.parse(

        SocketThread.class.getResourceAsStream("/web.xml"));
    for (MyServlet myServlet : parse) {
      if (myServlet.getUrl().equals(servletPath)) {
        return myServlet.getClassName();
      }
    }

    throw new RuntimeException("没有找到servlet:" + servletPath);
  }
}
