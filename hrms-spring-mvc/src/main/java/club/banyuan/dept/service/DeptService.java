package club.banyuan.dept.service;

import club.banyuan.dept.entity.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> getDeptList(String name,int page,int rows);

    int getDeptListCount(String name);

    void saveDept(Dept dept);

    void deleteDeptByIds(List<Integer> asList);

    List<Dept> getDeptList();

    List<Dept> getDeptList(String name);
}
