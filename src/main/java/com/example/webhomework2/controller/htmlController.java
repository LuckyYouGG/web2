package com.example.webhomework2.controller;


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

// httpServletResponse.sendRedirect
    @RequestMapping("/login")
    public void longInUser(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("userName");
        String passwd = req.getParameter("passWd");
        String kind = req.getParameter("kind");

        if(checkLogin(username,passwd,kind)){
            res.setStatus(200);
          if(kind.equals("1")){
              try{
                  res.sendRedirect("http://47.93.221.123:8080/webhomework3/index.html");

                //  System.out.println("页面跳转");
                  return;
              }catch (Exception e){
                  e.printStackTrace();
              }
          }else{
              try{
                  res.sendRedirect("http://47.93.221.123:8080/webhomework3/admin.html");
                  return;
              }catch (Exception e){
                  e.printStackTrace();
              }
          }
          System.out.println("用户合法");
        }else {
            System.out.println("用户不合法");
            res.setStatus(201);
        }

    }

    @RequestMapping("/register")
    public void register(HttpServletRequest req, HttpServletResponse res){
        String username = req.getParameter("userName");
        String passwd = req.getParameter("passWd");
        String kind = req.getParameter("kind");
        if(registerUser(username,passwd,kind)){
            try{
                res.sendRedirect("static/index.html");
            }catch (Exception e){
                e.printStackTrace();
            }
            res.setStatus(200);
        }else {
            res.setStatus(0);
        }

    }
    public boolean checkLogin(String username, String passwd,String kind) {
            String sql = "select * from users where username='" + username + "'and passwd=" + "'" + passwd + "' and kind='"+kind+"'";
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
        if(checkLogin(userName,passWd,kind)){
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
