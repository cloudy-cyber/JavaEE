package club.banyuan.util;

import club.banyuan.admin.entity.Admin;
import club.banyuan.common.Constant;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthUtil {

  private static final List<String> whiteList = Arrays.asList("/login.html", "/admin/login");

  public static boolean isAuth(HttpServletRequest request) {

    // 在白名单的请求，需要放行
    // login.html  /admin/login
    if (whiteList.contains(request.getServletPath())) {
      return true;
    } else {
      HttpSession session = request.getSession();
      Admin user = (Admin) session.getAttribute(Constant.ADMIN_SESSION);
      return user != null;
    }
  }
}