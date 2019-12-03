package dao;

public interface UserDao {
    public boolean registerUser(String mobile,String passwd);
    public boolean registerMer(String mobile,String passwd,String shopname);
    public boolean checkLogin(String mobile,String passwd,String kind);
}
