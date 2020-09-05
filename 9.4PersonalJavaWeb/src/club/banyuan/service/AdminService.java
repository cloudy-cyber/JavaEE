package club.banyuan.service;

import club.banyuan.pojo.Admin;

public interface AdminService {
    public Admin login(String userName,String password) throws Exception;
}
