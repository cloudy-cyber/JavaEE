package club.banyuan.admin.service.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import java.util.List;

public class AdminServiceOtherImpl implements AdminService {

  private AdminDao adminDao;

  public AdminDao getAdminDao() {
    return adminDao;
  }

  public void setAdminDao(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  @Override
  public Admin login(String username, String password) {
    return null;
  }

  @Override
  public List<Admin> getAdminList(String username) {
    return null;
  }

  @Override
  public void addAdmin(Admin admin) {

  }

  @Override
  public void updateAdmin(Admin admin) {

  }

  @Override
  public void deleteAdmins(List<String> asList) {

  }

  @Override
  public List<Admin> getAdminList(String username, int page, int row) {
    return null;
  }

  @Override
  public int getAdminListCount(String username) {
    return 0;
  }
}
