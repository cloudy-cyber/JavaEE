package club.banyuan.admin.servlet;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.admin.service.impl.AdminServiceImpl;
import club.banyuan.common.Constant;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(name = "LoginServlet", urlPatterns = "/admin/login")
public class LoginServlet extends HttpServlet {

  private AdminService adminService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ApplicationContext applicationContext = (ApplicationContext) config.getServletContext()
        .getAttribute("ApplicationContext");
    adminService = applicationContext.getBean("adminServiceImpl", AdminService.class);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Admin login = adminService.login(username, password);
    if (login == null) {
      response.sendRedirect(request.getContextPath() + "/login.html");
    } else {
      System.out.println(login);
      request.getSession().setAttribute(Constant.ADMIN_SESSION, login);
      response.sendRedirect(request.getContextPath() + "/home_page.html");
    }
  }
}
