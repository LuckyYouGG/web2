package com.example.webhomework2.controller;

import bean.GoodsBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//http://localhost:8088/homework2/login
@RestController
public class mainController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private UserService userService = null;
    public mainController(){
        userService = new UserService(jdbcTemplate);
    }

    @RequestMapping("/addCartGoods")
    public String addCartGoods(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String sql = "insert into cart (id) values(?)";
        try{
            jdbcTemplate.update(sql,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setStatus(200);
        return "1";
    }
    @RequestMapping("/forwordCart")
    @ResponseBody
    public ModelAndView forwordCart(HttpServletRequest request,HttpServletResponse response){
            ModelAndView modelAndView = new ModelAndView("cart");
            String sql =String.format("SELECT * FROM goods_list a,cart b where b.id=a.Gindex;");
            try{
                List<GoodsBean> goodsBeans = jdbcTemplate.query(sql, new RowMapper<GoodsBean>()
                {
                    GoodsBean com = null;
                    @Override
                    public GoodsBean mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        com = new GoodsBean();

                        com.setGindex(resultSet.getString("Gindex"));
                        com.setGname(resultSet.getString("Gname"));
                        com.setGprice(resultSet.getString("Gprice"));
                        return com;
                    }
                });
                modelAndView.addObject("goodsBeans",goodsBeans);
             }catch (Exception e){
              e.printStackTrace();
            }

            return modelAndView;
    }
    @RequestMapping("/deleteCartGoods")
    public String deleleCartGoods(HttpServletRequest request,HttpServletResponse response) {
        String id = request.getParameter("id");
        String sql =String.format("DELETE FROM cart WHERE id=%s",id);

        try{
            jdbcTemplate.update(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setStatus(200);
        return "1";
    }


}











