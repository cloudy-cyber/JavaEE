package club.banyuan.admin.servlet;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.admin.service.impl.AdminServiceImpl;
import club.banyuan.util.ServletUtil;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(name = "AdminModifyServlet", urlPatterns = "/admin/save")
public class AdminModifyServlet extends HttpServlet {

  private AdminService adminService;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ApplicationContext applicationContext = (ApplicationContext) config.getServletContext()
        .getAttribute("ApplicationContext");
    adminService = applicationContext.getBean(AdminService.class);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Admin admin = new Admin();
    admin.setPassword(password);
    admin.setUsername(username);
    if (id == null) {
      adminService.addAdmin(admin);
    } else {
      admin.setId(Integer.parseInt(id));
      adminService.updateAdmin(admin);
    }

    ServletUtil.sendSuccess(response.getWriter());
  }
}
