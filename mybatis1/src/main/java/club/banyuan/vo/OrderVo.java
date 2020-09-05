package club.banyuan.vo;

import club.banyuan.pojo.Order;

public class OrderVo extends Order {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                super.toString() +
                "username='" + username + '\'' +
                '}';
    }
}
