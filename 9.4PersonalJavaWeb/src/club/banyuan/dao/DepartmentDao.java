package club.banyuan.dao;

import club.banyuan.pojo.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DepartmentDao extends IBaseDao{
    public List<Department> getDeptList() throws Exception;
}
