package club.banyuan.admin.servlet;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.admin.service.impl.AdminServiceImpl;
import club.banyuan.util.ServletUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(name = "AdminListServlet", urlPatterns = "/admin/list")
public class AdminListServlet extends HttpServlet {

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

    String username = request.getParameter("username");
    int page = Integer.parseInt(request.getParameter("page"));
    int rows = Integer.parseInt(request.getParameter("rows"));

    List<Admin> rlt = adminService.getAdminList(username, page, rows);
    int count = adminService.getAdminListCount(username);
    Map<String, Object> rltMap = new HashMap<>();
    rltMap.put("total", count);
    rltMap.put("rows", rlt);
    ServletUtil.sendSuccess(response.getWriter(), rltMap);

  }
}
