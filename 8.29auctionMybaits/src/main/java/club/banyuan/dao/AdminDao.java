package club.banyuan.dao;

import club.banyuan.pojo.Admin;

import java.util.List;

public interface AdminDao {
    public int addAdmin(Admin admin);
    public int delAdmin(int id);
    public int updateAdmin(Admin admin);
    public List<Admin> getAll();
}
