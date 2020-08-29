package club.banyuan.pojo;

import java.util.Date;

public class UserAddress {
    private Integer id;
    private Integer userId;
    private String address;
    private Date createTime;
    private Integer isDefault;
    private String remark;

    @Override
    public String toString() {
        return "UserAdderss{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", isDefault=" + isDefault +
                ", remark='" + remark + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

}
