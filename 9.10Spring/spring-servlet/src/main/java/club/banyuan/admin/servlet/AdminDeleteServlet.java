package club.banyuan.admin.servlet;

import club.banyuan.admin.service.AdminService;
import club.banyuan.admin.service.impl.AdminServiceImpl;
import club.banyuan.admin.service.impl.AdminServiceOtherImpl;
import club.banyuan.util.ServletUtil;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(name = "AdminDeleteServlet", urlPatterns = "/admin/delete")
public class AdminDeleteServlet extends HttpServlet {

  private AdminService adminService = new AdminServiceOtherImpl();

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
    String ids = request.getParameter("ids");
    if (ids == null || ids.trim().length() == 0) {
      return;
    }

    String[] split = ids.split(",");

    adminService.deleteAdmins(Arrays.asList(split));
    ServletUtil.sendSuccess(response.getWriter());
  }
}
