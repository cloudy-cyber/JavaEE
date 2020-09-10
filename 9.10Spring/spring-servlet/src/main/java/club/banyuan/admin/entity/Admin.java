package club.banyuan.admin.entity;

import club.banyuan.common.DBOrder;

public class Admin {

  @DBOrder(1)
  private int id;
  @DBOrder(2)
  private String username;
  @DBOrder(3)
  private String password;
  @DBOrder(4)
  private String rolename;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }
}
