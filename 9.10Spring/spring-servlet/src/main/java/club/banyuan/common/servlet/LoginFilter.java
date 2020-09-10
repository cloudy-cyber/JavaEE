package club.banyuan.common.servlet;

import club.banyuan.admin.entity.Admin;
import club.banyuan.common.Constant;
import club.banyuan.util.AuthUtil;
import club.banyuan.util.ServletUtil;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "F1", urlPatterns = {
    "/dept/*", "/admin/*", "/empl/*", "/position/*"
})
public class LoginFilter implements Filter {

  public void destroy() {

  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setCharacterEncoding("utf-8");

    if (!AuthUtil.isAuth((HttpServletRequest) req)) {
      resp.setContentType("application/json;charset=utf-8");
      ServletUtil.sendFail(resp.getWriter(), "用户未登录");
    } else {
      chain.doFilter(req, resp);
    }
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
