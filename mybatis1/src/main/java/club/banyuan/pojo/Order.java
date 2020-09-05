package club.banyuan.pojo;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private Integer userId;
    private String userAddress;
    private Date createTime;
    private double cost;
    private String serialNumber;
    private String  loginName;
    private User user;
    private List<Product> productList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", userAddress='" + userAddress + '\'' +
                ", createTime=" + createTime +
                ", cost=" + cost +
                ", serialNumber='" + serialNumber + '\'' +
                ", loginName='" + loginName + '\'' +
                ", user=" + user +
                ", productList=" + productList +
                '}';
    }
}
