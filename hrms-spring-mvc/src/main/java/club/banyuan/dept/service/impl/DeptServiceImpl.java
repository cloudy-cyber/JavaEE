package club.banyuan.dept.service.impl;

import club.banyuan.dept.dao.DeptDao;
import club.banyuan.dept.entity.Dept;
import club.banyuan.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> getDeptList(String name, int page, int rows) {
        return deptDao.getDeptListPage(name,(page-1)*rows,rows);
    }

    @Override
    public int getDeptListCount(String name) {
        return deptDao.getDeptListPageCount(name);
    }

    @Override
    public void saveDept(Dept dept) {
        if(dept.getId()==null){
            deptDao.addDept(dept);
        }else {
            deptDao.updateDept(dept);
        }
    }

    @Override
    public void deleteDeptByIds(List<Integer> asList) {
         deptDao.deleteDeptByIds(asList);
    }

    @Override
    public List<Dept> getDeptList() {
        return deptDao.getDeptList();
    }

    @Override
    public List<Dept> getDeptList(String name) {
        return deptDao.getDeptListByName(name);
    }
}
