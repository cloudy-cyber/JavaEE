package club.banyuan.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class User {
    private Integer userId;
    private String username;
    private String password;
    private Date birth;
    private List<UserAddress> userAddresses;
    private Map<String,UserAddress> userAdrMap;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public Map<String, UserAddress> getUserAdrMap() {
        return userAdrMap;
    }

    public void setUserAdrMap(Map<String, UserAddress> userAdrMap) {
        this.userAdrMap = userAdrMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth +
                ", userAddresses=" + userAddresses +
                ", userAdrMap=" + userAdrMap +
                '}';
    }
}
