package com.example.webhomework2.controller;


import bean.MerchantBean;
import bean.UserBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class htmlController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/login_user.html")
    public String test(){
        return "login_user";
    }
// httpServletResponse.sendRedirect
    @RequestMapping("/login")
    public String longInUser(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("userName");
        String passwd = req.getParameter("passWd");
        String kind = req.getParameter("kind");
        if(checkLogin(username,passwd)){
          if(kind.equals("1")){
              return "index";
          }else{
              return "";
          }
        }else
         return "login_user";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest req, HttpServletResponse res){
        String username = req.getParameter("userName");
        String passwd = req.getParameter("passWd");
        String kind = req.getParameter("kind");
        if(registerUser(username,passwd,kind)){
           return "1";
        }else return "0";

    }
    public boolean checkLogin(String username, String passwd) {
            String sql = "select * from users where username='" + username + "'passwd=" + "'" + passwd + "'";
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
                }else return false;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
    }

    public boolean registerUser(String userName, String passWd,String kind) {
        if(checkLogin(userName,passWd)){
            return false;
        }
        String sql = "insert  into users (userName,passWd,kind) values(?,?,?)";
        try{
            jdbcTemplate.update(sql,userName,passWd,kind);
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

}
