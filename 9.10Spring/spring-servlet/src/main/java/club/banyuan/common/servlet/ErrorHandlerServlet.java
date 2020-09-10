package club.banyuan.common.servlet;

import club.banyuan.common.ServerException;
import club.banyuan.util.ServletUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ErrorHandlerServlet", urlPatterns = "/error/handler")
public class ErrorHandlerServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("application/json;charset=utf-8");
    Object obj =
        request.getAttribute("javax.servlet.error.exception");

    if (obj instanceof ServerException) {
      ServletUtil.sendFail(response.getWriter(), ((ServerException) obj).getMessage());
    } else {
      ServletUtil.sendFail(response.getWriter(), "服务器内部异常");
    }

  }
}
