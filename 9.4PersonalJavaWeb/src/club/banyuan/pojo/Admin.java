package club.banyuan.pojo;

public class Admin {
    private Integer id;
    private String userName;
    private String roleName;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "admin{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
