package club.banyuan.servlet;

import club.banyuan.pojo.Department;
import club.banyuan.service.DepartmentService;
import club.banyuan.service.impl.DepartmentServiceImpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchDeptServlet", urlPatterns = "/dept/list")
public class SearchDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentServiceImpl();
        response.setContentType("text/html; charset=UTF-8");
        try {
            List<Department> departmentList = departmentService.getDepartment();
            System.out.println(departmentList);
            Map<String, Object> map = new HashMap<>();
            map.put("total", departmentList.size());
            map.put("code", 0);
            map.put("rows", departmentList);
            String string = JSONObject.toJSONString(map);
            PrintWriter writer = response.getWriter();
            writer.print(string);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
