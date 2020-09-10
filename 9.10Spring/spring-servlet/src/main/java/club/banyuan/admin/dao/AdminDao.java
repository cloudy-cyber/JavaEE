package club.banyuan.admin.dao;

import club.banyuan.admin.entity.Admin;
import java.util.List;

public interface AdminDao {

  List<Admin> getAdminByName(String name);

  void addAdmin(Admin admin);

  void updateAdmin(Admin admin);

  void deleteAdmin(Admin admin);

  void deleteAdmin(List<Integer> adminList);

  List<Admin> getAdminList();

  List<Admin> getAdminList(String username);

  Admin getAdmin(String username, String password);

  Admin getAdminById(int id);

  List<Admin> getAdminListPage(String name, int page, int row);

  int getAdminListPageCount(String name);


}
