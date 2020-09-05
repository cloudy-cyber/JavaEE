package club.banyuan.dao.impl;

import club.banyuan.dao.DepartmentDao;
import club.banyuan.pojo.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {
    public DepartmentDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Department> getDeptList() throws Exception {
        List<Department> departmentList = new ArrayList<>();
        String sql = "select * from department";
        Object[] param = new Object[]{};
        ResultSet rs = this.executeQuery(sql, param);
        while (rs.next()){
            Department department = tableToClass(rs);
            departmentList.add(department);
        }
        return departmentList;
    }

    @Override
    public Department tableToClass(ResultSet rs) throws Exception {
        Department department=new Department();
        department.setId(rs.getInt(1));
        department.setName(rs.getString(2));
        department.setDescription(rs.getString(3));
        return department;

    }
}
