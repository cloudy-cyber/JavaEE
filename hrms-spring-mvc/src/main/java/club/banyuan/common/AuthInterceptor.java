package club.banyuan.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {

  // 在controller处理请求之前调用，类似于 filter 中 chain.dofilter 之前的代码内容
  // handler 表示处理请求的controller对象，如果请求的是静态资源，则为ResourceHttpRequestHandler
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    Object attribute = request.getSession().getAttribute(Constant.ADMIN_SESSION);
    if (attribute == null) {
      response.sendRedirect(request.getContextPath() + "/login.html");
      return false;
    }

    // false表示拦截器不会把请求传递给 controller
    return true;
  }

  /**
   * 在controller处理请求之后调用，类似于 filter 中 chain.dofilter 之后的代码内容
   */
  // @Override
  // public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
  //     ModelAndView modelAndView) throws Exception {
  // }


  /**
   * 在所有的拦截器处理完毕后，逐个调用，类似于 filter的doFileter方法执行完毕后，进行调用
   * ex 表示获取到处理请求过程中抛出的异常
   */
  // @Override
  // public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
  //     Object handler, Exception ex) throws Exception {
  // }
}
