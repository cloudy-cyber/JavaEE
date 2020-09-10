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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 内存分页
 */
// @WebServlet(name = "AdminListServlet", urlPatterns = "/admin/list")
public class AdminListServletBak extends HttpServlet {

  private AdminService adminService = new AdminServiceImpl();

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    int page = Integer.parseInt(request.getParameter("page"));
    int rows = Integer.parseInt(request.getParameter("rows"));

    List<Admin> adminList = adminService.getAdminList(username);

    // 20
    // 1页  5行  => 0 ~ 4
    // 3页  5行  => 10~ 14
    // n页  m行  => (n - 1) * m ~ n * m - 1
    List<Admin> rlt = null;
    if ((page - 1) * rows > adminList.size()) {
      rlt = new ArrayList<>();
    } else {
      rlt = adminList.subList((page - 1) * rows, Math.min(page * rows, adminList.size()));
    }

    Map<String, Object> rltMap = new HashMap<>();
    rltMap.put("total", adminList.size());
    rltMap.put("rows", rlt);
    ServletUtil.sendSuccess(response.getWriter(), rltMap);

  }
}
