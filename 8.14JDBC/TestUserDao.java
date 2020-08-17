public class TestUserDao {
    @Test
    public void testGetUserByUsernameAndPwd() throws Exception {
        Connection conn = DataSourceUtil.openConnection();
        UserDao userDao = new UserDaoImpl(conn);

        User user =userDao.getUserByUserNameAndPwd("aaa","123");
        System.out.println(user);

        DataSourceUtil.closeConnection(conn);
    }
}