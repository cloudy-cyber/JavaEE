package club.banyuan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// localhost:8080/my-app/test/absolute
// redirect => localhost:8080/Form.html
@WebServlet(name = "PathTwoServlet", value = "/test/absolute")
public class PathTwoServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    // response.getWriter().println("request.getRequestURI():" + request.getRequestURI());
    // response.getWriter().println("request.getContextPath()" + request.getContextPath());
    response.sendRedirect("/Form.html");

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
