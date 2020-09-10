package club.banyuan.admin.service;

import club.banyuan.admin.entity.Admin;
import java.util.List;

public interface AdminService {

  Admin login(String username, String password);

  List<Admin> getAdminList(String username);

  void addAdmin(Admin admin);

  void updateAdmin(Admin admin);

  void deleteAdmins(List<String> asList);

  List<Admin> getAdminList(String username, int page, int row);

  int getAdminListCount(String username);
}
