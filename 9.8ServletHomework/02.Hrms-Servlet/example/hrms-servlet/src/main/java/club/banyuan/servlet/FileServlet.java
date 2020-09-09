package club.banyuan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login.html"})
public class FileServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // login.html => static/login.html
    System.out.println(req.getRequestURI());
    System.out.println(req.getContextPath());
    System.out.println(req.getServletPath());
    req.getRequestDispatcher("/static/login.html").forward(req
        , resp);
  }
}
