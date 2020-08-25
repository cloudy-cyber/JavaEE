package club.banyuan.servlet;

import club.banyuan.pojo.Order;
import club.banyuan.pojo.OrderDetail;
import club.banyuan.pojo.Product;
import club.banyuan.pojo.User;
import club.banyuan.service.OrderService;
import club.banyuan.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ConfirmOrderServlet",urlPatterns = "/confirm.do")
public class ConfirmOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Product,Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        // 查询用户默认地址

        Order order = new Order();
        order.setUserId(user.getId());
        order.setLoginName(user.getLoginName());
        order.setCreateTime(new Date());
        order.setUserAddress("");
        order.setSerialNumber("XXXXXX11111");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        double sum = 0;
        for(Product product1 : cart.keySet()){
            sum += product1.getPrice() * cart.get(product1);
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCost(product1.getPrice());
            orderDetail.setProductId(product1.getId());
            orderDetail.setQuantity(cart.get(product1));
            orderDetailList.add(orderDetail);
        }

        order.setCost(sum);

        OrderService orderService = new OrderServiceImpl();

        orderService.createOrder(order,orderDetailList);

        request.getRequestDispatcher("BuyCar_Three.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
