package club.banyuan.admin.servlet;

import club.banyuan.admin.entity.Admin;
import club.banyuan.util.ServletUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/info")
public class AdminInfoServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Admin admin = (Admin) req.getSession().getAttribute("admin");
    String username = admin.getUsername();
    Map<String, Object> rlt = new HashMap<>();
    rlt.put("username", username);
    ServletUtil.sendSuccess(resp.getWriter(), rlt);
  }
}
