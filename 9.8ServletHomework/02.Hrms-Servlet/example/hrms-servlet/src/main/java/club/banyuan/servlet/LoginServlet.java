package club.banyuan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HttpServletMapping httpServletMapping = request.getHttpServletMapping();

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println(username);
    System.out.println(password);

    response.sendRedirect(request.getContextPath() + "/home_page.html");

    // System.out.println(response.getCharacterEncoding());
    // // setCharacterEncoding 设置字符流解析字符串的编码方式
    // response.setCharacterEncoding("utf-8");
    // response.getWriter().println("响应登录");
    //
    // // 告知浏览器按照何种编码解析返回内容中的数据
    // // 这两种方式设置的字符编码，会被 setCharacterEncoding 设置的内容覆盖
    // response.setContentType("text/plain");
    // response.setHeader("Content-Type", "text/plain;charset=UTF-8");
    // System.out.println(response.getCharacterEncoding());
  }
}
