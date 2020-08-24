package club.banyuan.servlet;

import club.banyuan.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CountServlet",urlPatterns = "/count.do")
public class CountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object object = session.getAttribute("user");
        if(object == null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            Map<Product,Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");
            double sum = 0;
            for(Product product1 : cart.keySet()){
                sum += product1.getPrice() * cart.get(product1);
            }
            request.setAttribute("sum",sum);
            request.getRequestDispatcher("buycar2.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
