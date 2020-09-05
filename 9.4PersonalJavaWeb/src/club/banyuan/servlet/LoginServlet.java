package club.banyuan.servlet;

import club.banyuan.pojo.Admin;
import club.banyuan.service.AdminService;
import club.banyuan.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet" ,urlPatterns = "/admin/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService adminService = new AdminServiceImpl();
        try {
            Admin admin = adminService.login(userName,password);
            if(admin!=null){
                response.sendRedirect("home_page.html");
            }else {
                response.sendRedirect(" login.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
