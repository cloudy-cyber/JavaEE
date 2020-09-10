package club.banyuan.admin.service.impl;

import club.banyuan.admin.dao.AdminDao;
import club.banyuan.admin.dao.impl.AdminDaoDbUtilsImpl;
import club.banyuan.admin.dao.impl.AdminDaoImpl;
import club.banyuan.admin.entity.Admin;
import club.banyuan.admin.service.AdminService;
import club.banyuan.common.ServerException;
import club.banyuan.util.CipherUtil;
import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {

  private AdminDao adminDao;

  public AdminServiceImpl() {
  }

  public AdminServiceImpl(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  public AdminDao getAdminDao() {
    return adminDao;
  }

  public void setAdminDao(AdminDao adminDao) {
    this.adminDao = adminDao;
  }

  // private AdminDao adminDao = new AdminDaoDbUtilsImpl();
  // private AdminDao adminDao = new AdminDaoImpl();


  @Override
  public Admin login(String username, String password) {
    String passHash = CipherUtil.hmacSha256(password);
    Admin admin = adminDao.getAdmin(username, passHash);
    return admin;
  }

  @Override
  public List<Admin> getAdminList(String username) {
    if (username == null || username.trim().length() == 0) {
      return adminDao.getAdminList();
    } else {
      return adminDao.getAdminList(username);
    }
  }

  @Override
  public void addAdmin(Admin admin) {
    // 密码经过不可逆加密后保存
    admin.setPassword(CipherUtil.hmacSha256(admin.getPassword()));
    List<Admin> adminByName = adminDao.getAdminByName(admin.getUsername());
    if (adminByName.size() > 0) {
      throw new ServerException("用户名已经存在");
    }
    adminDao.addAdmin(admin);
  }

  @Override
  public void updateAdmin(Admin admin) {
    Admin old = adminDao.getAdminById(admin.getId());
    if (old == null) {
      throw new ServerException("用户id不存在：" + admin.getId());
    }
    admin.setPassword(CipherUtil.hmacSha256(admin.getPassword()));
    adminDao.updateAdmin(admin);
  }

  @Override
  public void deleteAdmins(List<String> adminList) {

    // 把一个String list 转换为 Integer list
    List<Integer> idList = adminList.stream().map(t -> {
      return Integer.parseInt(t);
    }).collect(Collectors.toList());

    // List<Admin> adminList1 = adminList.stream().map(t -> {
    //   Admin admin = new Admin();
    //   admin.setId(Integer.parseInt(t));
    //   return admin;
    // }).collect(Collectors.toList());

    adminDao.deleteAdmin(idList);

    // for (String s : adminList) {
    //   Admin admin = new Admin();
    //   admin.setId(Integer.parseInt(s));
    //   adminDao.deleteAdmin();
    // }
  }

  @Override
  public List<Admin> getAdminList(String username, int page, int row) {
    return adminDao.getAdminListPage(username, page, row);
  }

  @Override
  public int getAdminListCount(String username) {
    return adminDao.getAdminListPageCount(username);
  }
}
