package club.banyuan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// localhost:8080/my-app/fromtest

// localhost:8080/my-app/test/relative
// redirect => localhost:8080/my-app/test/Form.html
@WebServlet(name = "PathServlet", urlPatterns = "/test/relative")
public class PathServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    // response.getWriter().println("request.getRequestURI():" + request.getRequestURI());
    // response.getWriter().println("request.getContextPath()" + request.getContextPath());
    response.sendRedirect("Form.html");
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
