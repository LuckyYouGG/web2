package com.example.webhomework2.controller;

import bean.GoodsBean;
import bean.MerchantBean;
import bean.UserBean;
import dao.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/homework2")
@ResponseBody
public class mainController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private UserService userService = null;
    public mainController(){
        userService = new UserService(jdbcTemplate);
    }


    public ModelAndView shoppingModel(){
        ModelAndView modelAndView = new ModelAndView("shopping");
        String sql = "select * from goods";
        List<GoodsBean> goods = jdbcTemplate.query(sql, new RowMapper<GoodsBean>() {
            GoodsBean tmp = null;
            @Override
            public GoodsBean mapRow(ResultSet resultSet, int i) throws SQLException {
                tmp = new GoodsBean();

                tmp.setGindex(resultSet.getString("Gindex"));
                tmp.setGtelnum(resultSet.getString("Gtelnum"));
                tmp.setGshopname(resultSet.getString("Gshopname"));
                tmp.setGreserve(resultSet.getString("Greserve"));
                tmp.setGname(resultSet.getString("Gname"));
                tmp.setGphotoname(resultSet.getString("Gphotoname"));
                tmp.setGprice(resultSet.getString("Gprice"));
                tmp.setGtransprice(resultSet.getString("Gtransprice"));
                tmp.setGdescribe(resultSet.getString("Gdescripe"));
                tmp.setGlocation(resultSet.getString("Glocation"));
                tmp.setGdate(resultSet.getString("Gdate"));
                tmp.setGbrand(resultSet.getString("Gbrand"));

                return tmp;
            }
        });
        GoodsBean wc = new GoodsBean();
        wc.setGoods(goods);
        modelAndView.addObject("goods",wc);
        return modelAndView;
    }


}











