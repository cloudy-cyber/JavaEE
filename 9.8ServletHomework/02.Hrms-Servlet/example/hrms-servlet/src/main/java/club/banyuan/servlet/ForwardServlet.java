package club.banyuan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForwardServlet",  urlPatterns = "/test/forward")
public class ForwardServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 转发到了 contentPath 下
    // request.getRequestDispatcher("").forward(request, response);
    // request.getRequestDispatcher("/").forward(request, response);


    // 转发到 contextPath + /test/other
    request.getRequestDispatcher("other").forward(request, response);

    // 转发到 contextPath + /other 下
    // request.getRequestDispatcher("/other").forward(request, response);


  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
