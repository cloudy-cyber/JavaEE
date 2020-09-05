package club.banyuan.service.impl;

import club.banyuan.dao.DepartmentDao;
import club.banyuan.dao.impl.DepartmentDaoImpl;
import club.banyuan.dao.util.DataSourceUtil;
import club.banyuan.pojo.Department;
import club.banyuan.service.DepartmentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public List<Department> getDepartment() throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        DepartmentDao departmentDao = new DepartmentDaoImpl(conn);
        List<Department> departmentList = departmentDao.getDeptList();
        DataSourceUtil.closeConnection(conn);
        return departmentList;
    }
}
