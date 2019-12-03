package db;

import bean.GoodsBean;
import bean.MerchantBean;
import bean.UserBean;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@RestController
@ResponseBody
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public boolean registerUser(String mobile, String passwd) {

        String sql = "insert  into users (telnum,passwd) values(?,?)";

        try{ System.out.println(mobile+passwd+"奥术大师多");

            jdbcTemplate.update(sql,mobile,passwd);
        }catch (Exception e){
            e.printStackTrace();
        }

       return true;
    }

    @Override
    public boolean registerMer(String mobile, String passwd, String shopname) {
        String sql = "Insert into merchants (Mtelnum,Mpasswd,Mshopname) values(?,?,?)";
        jdbcTemplate.update(sql,mobile,passwd,shopname);
        return false;
    }

    @Override
    public boolean checkLogin(String mobile, String passwd, String kind) {
      //  if(kind == "1")
        {
            String sql = "select * from merchants where Mtelnum='"+mobile+"'";
            System.out.println(sql);
            try{
                List<MerchantBean> Merchants = jdbcTemplate.query(sql, new RowMapper<MerchantBean>() {
                    MerchantBean merchantBean = null;

                    @Override
                    public MerchantBean mapRow(ResultSet resultSet, int i) throws SQLException {
                        merchantBean = new MerchantBean();
                        merchantBean.setMindex(resultSet.getString("Mindex"));
                        return merchantBean;
                    }

                });
                if(Merchants.size() > 0) return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        if(kind.equals("2"))
        {
            String sql = "select * from users where telnum='"+mobile+"'";
            try{
                List<UserBean> Users = jdbcTemplate.query(sql, new RowMapper<UserBean>() {
                    UserBean tmp = null;

                    @Override
                    public UserBean mapRow(ResultSet resultSet, int i) throws SQLException {
                        tmp = new UserBean();
                        tmp.setRowIndex(resultSet.getString("rowIndex"));
                        return tmp;
                    }
                });
                if(Users.size() > 0){
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
