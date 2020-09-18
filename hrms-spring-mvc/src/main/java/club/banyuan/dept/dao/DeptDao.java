package club.banyuan.dept.dao;

import club.banyuan.dept.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptDao {

    List<Dept> getDeptListPage(@Param("name") String name,@Param("page") int page,@Param("rows") int rows);

    int getDeptListPageCount(String name);

    void addDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDeptByIds(List<Integer> idList);

    List<Dept> getDeptList();

    List<Dept> getDeptListByName(@Param("name") String name);

}
