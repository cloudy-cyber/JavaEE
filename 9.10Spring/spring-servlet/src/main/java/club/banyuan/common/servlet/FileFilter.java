package club.banyuan.common.servlet;

import club.banyuan.util.AuthUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url 直接填写  login.html 映射为 static/login.html
@WebFilter(filterName = "F2", urlPatterns = {
    "*.html", "*.css", "*.js", "*.jpg", "*.png", "*.gif"
})
public class FileFilter implements Filter {

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) req;

    // 如果以html结尾，需要判断用户是否登录，如果没有登录，则重定向到login
    if (httpServletRequest.getServletPath().endsWith(".html")) {
      if (!AuthUtil.isAuth(httpServletRequest)) {
        ((HttpServletResponse) resp)
            .sendRedirect(httpServletRequest.getContextPath() + "/login.html");
        return;
      }
    }
    // html以外的资源，直接转发，不需要判断是否登录
    req.getRequestDispatcher("/static" + httpServletRequest.getServletPath()).forward(req, resp);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }
}
