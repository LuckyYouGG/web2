package com.example.webhomework2.controller;

import bean.GoodsBean;
import bean.HistoryOrdersBean;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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



//   http://localhost:8088/historyOrders
    @RequestMapping("/historyOrders")
    public ModelAndView historyOrders(HttpServletRequest request,HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("historyOrders");
        String sql = "select * from has_bought";
        try {
              List<HistoryOrdersBean> historyOrdersBeans = jdbcTemplate.query(sql, new RowMapper<HistoryOrdersBean>() {
                 HistoryOrdersBean tmp = null;
                  @Override
                  public HistoryOrdersBean mapRow(ResultSet resultSet, int i) throws SQLException {
                      tmp = new HistoryOrdersBean();
                      tmp.setIds(resultSet.getString("ids").split(","));
                      tmp.setDataTime(resultSet.getString("dataTime"));
                      return tmp;
                  }
              });
             modelAndView.addObject("names",Common.names);
             modelAndView.addObject("prices",Common.prices);
              modelAndView.addObject("historyOrdersList",historyOrdersBeans);
        }catch (Exception e) {
            e.printStackTrace();
        }
      return modelAndView;
    }

   /*http://localhost:8088/forwordCart*/
    String ids = "";
    @RequestMapping("/forwordCart")
    @ResponseBody
    public ModelAndView forwordCart(HttpServletRequest request,HttpServletResponse response){
            ModelAndView modelAndView = new ModelAndView("cart");
            String sql =String.format("SELECT * FROM goods_list a,cart b where b.id=a.Gindex;");
            ids ="";
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
                        ids += resultSet.getString("Gindex")+",";
                        return com;
                    }
                });
                if(ids.length()>0)
                   ids = ids.substring(0,ids.length()-1);
                System.out.println(ids+"  dasd");
                System.out.println(ids.length());
                modelAndView.addObject("ids",ids);
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

    @RequestMapping("/deleteAllCartGoods")
    public String deleteAllCartGoods(HttpServletRequest request,HttpServletResponse response) {
        String sql = "delete from cart";
        String ids = request.getParameter("ids");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dataTime = df.format(new Date());// new Date()为获取当前系统时间

        String sql1 = "insert into has_bought (ids,dataTime) values(?,?)";
        try{
            jdbcTemplate.update(sql);
            jdbcTemplate.update(sql1,ids,dataTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setStatus(200);
        return "1";
    }


}











