package service;

import dao.UserDao;
import db.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDao {
    @Autowired
    private UserDao userDao ;

    public UserService(JdbcTemplate jdbcTemplate){
        userDao = new UserDaoImpl(jdbcTemplate);
    }


    @Override
    public boolean registerUser(String mobile, String passwd) {
        return userDao.registerUser(mobile, passwd);
    }

    @Override
    public boolean registerMer(String mobile, String passwd, String shopname) {
        return userDao.registerMer(mobile, passwd, shopname);
    }

    @Override
    public boolean checkLogin(String mobile, String passwd,String kind) {
        return userDao.checkLogin(mobile,passwd,kind);
    }
}
