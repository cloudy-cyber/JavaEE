package club.banyuan.pojo;

public class UserAddress {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
