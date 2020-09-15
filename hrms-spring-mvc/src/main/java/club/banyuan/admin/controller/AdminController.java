package club.banyuan.admin.controller;

import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.common.Constant;
import club.banyuan.common.RespResult;
import java.util.Arrays;
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
    public RespResult getAdminList(Integer page, Integer rows, String username) {
        List<Admin> adminList = adminService.getAdminList(username, page, rows);
        int total = adminService.getAdminListCount(username);
        return RespResult.success(total, adminList);
    }
//    public RespResult getAdminList(String username){
//        List<Admin> adminList = adminService.getAdminList(username);
//        int total = adminService.getAdminListCount(username);
//        return RespResult.success(total,adminList);
//    }


    @RequestMapping("/info")
    // 让spring将方法返回的对象自动序列化为json
    @ResponseBody
    public RespResult getAdminInfo(HttpSession session) {
        Object attribute = session.getAttribute(Constant.ADMIN_SESSION);
        if (attribute != null) {
            RespResult rlt = RespResult.success();
            rlt.put("username", ((Admin) attribute).getUsername());
            return rlt;
        } else {
            return RespResult.fail("用户未登录");
        }
    }

    @RequestMapping("/save")
    @ResponseBody
    public RespResult modifyAdmin(Integer id, String username, String password) {
        Admin admin = new Admin();
        admin.setPassword(password);
        admin.setUsername(username);
        if (id == null) {
            adminService.addAdmin(admin);
        } else {
            admin.setId(id);
            adminService.updateAdmin(admin);
        }

        return RespResult.success();
    }

    @RequestMapping("/logout")
    public String logoutAdmin(HttpSession session) {
        // session置为失效
        session.invalidate();
        return "redirect:/login.html";
    }


    @RequestMapping("/delete")
    public RespResult deleteAdmin(String ids) {
        adminService.deleteAdmins(Arrays.asList(ids.split(",")));
        return RespResult.success();
    }

}
