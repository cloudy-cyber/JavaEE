package club.banyuan.dept.controller;

import club.banyuan.common.RespResult;
import club.banyuan.dept.entity.Dept;
import club.banyuan.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @RequestMapping("/list")
    @ResponseBody
    public RespResult getDeptList(String name,int page,int rows){
        List<Dept> deptList =deptService.getDeptList(name,page,rows);
        int total = deptService.getDeptListCount(name);
        return RespResult.success(total,deptList);
    }

    @RequestMapping("/save")
    @ResponseBody
    public RespResult saveDept(Dept dept){
        deptService.saveDept(dept);
        return RespResult.success();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public RespResult deleteDept(int[] ids){
        deptService.deleteDeptByIds(Arrays.stream(ids).boxed().collect(Collectors.toList()));
        return RespResult.success();
    }

    @RequestMapping("/getcombobox")
    @ResponseBody
    public List<Dept> getDeptCombobox() {
        return deptService.getDeptList();
    }



}
