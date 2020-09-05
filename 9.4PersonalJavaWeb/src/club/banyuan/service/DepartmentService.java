package club.banyuan.service;

import club.banyuan.pojo.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {
    public List<Department> getDepartment() throws Exception;
}
