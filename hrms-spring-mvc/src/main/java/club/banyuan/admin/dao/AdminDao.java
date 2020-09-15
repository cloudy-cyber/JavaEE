package club.banyuan.admin.dao;

import club.banyuan.admin.entity.Admin;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    List<Admin> getAdminByName(String name);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(Admin admin);
    // [1,2,3,4,5] => delete from t_admin where id in (1,2,3,4,5)
    void deleteAdminByIds(List<Integer> adminList);

    List<Admin> getAdminList();

    List<Admin> getAdminListByName(@Param("username") String username);

    Admin getAdmin(@Param("username") String username, @Param("password")String password);

    Admin getAdminById(int id);

    List<Admin> getAdminListPage(@Param("name") String name, @Param("page") int page, @Param("row") int row);

    int getAdminListPageCount(@Param("name") String name);


}
