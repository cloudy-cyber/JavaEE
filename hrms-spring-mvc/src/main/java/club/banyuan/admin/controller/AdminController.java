package club.banyuan.admin.controller;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.common.Constant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // spring mvc自动解析浏览器发送的数据
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        System.out.println("admin/login");
        System.out.println(username);
        System.out.println(password);
        Admin login = adminService.login(username, password);
        if (login == null) {
            return "redirect:/login.html";
        } else {
            session.setAttribute(Constant.ADMIN_SESSION, login);
            return "redirect:/home_page.html";
        }
    }

    @RequestMapping("/list")
    // 让spring将方法返回的对象自动序列化为json
    @ResponseBody
    public Map<String, Object> getAdminList( Integer page, Integer rows, String username) {
        List<Admin> adminList = adminService.getAdminList(username, page, rows);
        int total = adminService.getAdminListCount(username);
        Map<String, Object> rlt = new HashMap<>();
        rlt.put("rows", adminList);
        rlt.put("total", total);
        rlt.put("code", 0);
        rlt.put("message", "");
        return rlt;
    }


    @RequestMapping("/info")
    // 让spring将方法返回的对象自动序列化为json
    @ResponseBody
    public Map<String, Object> getAdminInfo(HttpSession session) {
        Map<String, Object> rlt = new HashMap<>();
        Object attribute = session.getAttribute(Constant.ADMIN_SESSION);
        if (attribute != null) {
            rlt.put("username", ((Admin) attribute).getUsername());
            rlt.put("code", 0);
            rlt.put("message", "");
        } else {
            rlt.put("code", 1);
            rlt.put("message", "用户未登录");
        }
        return rlt;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> modifyAdmin(Integer id, String username, String password) {
        Admin admin = new Admin();
        admin.setPassword(password);
        admin.setUsername(username);
        if (id == null) {
            adminService.addAdmin(admin);
        } else {
            admin.setId(id);
            adminService.updateAdmin(admin);
        }

        Map<String, Object> rlt = new HashMap<>();
        rlt.put("code", 0);
        rlt.put("message", "");
        return rlt;
    }

}
