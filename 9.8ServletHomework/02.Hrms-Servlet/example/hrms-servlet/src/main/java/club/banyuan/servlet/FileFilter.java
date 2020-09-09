package club.banyuan.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "FileFilter", urlPatterns = {
    "*.html", "*.css", "*.js", "*.jpg", "*.png", "*.gif"
})
public class FileFilter implements Filter {

  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    req.getRequestDispatcher("/static" + httpServletRequest.getServletPath()).forward(req, resp);
    // chain.doFilter(req, resp);
  }

  public void init(FilterConfig config) throws ServletException {

  }

}
