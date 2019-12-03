package bean;

import java.util.List;

public class GoodsBean {
    private List<GoodsBean> goods = null;
    private String Gindex = null;
    private String Gtelnum = null;
    private String Gshopname = null;
    private String Greserve = null;
    private String Gname = null;
    private String Gphotoname = null;
    private String Gprice = null;
    private String Gtransprice = null;
    private String Glocation = null;
    private String Gdate = null;
    private String Gbrand = null;
    private String Gdescribe = null;

    public void setGdescribe(String gdescribe) {
        Gdescribe = gdescribe;
    }

    public String getGdescribe() {
        return Gdescribe;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGindex(String gindex) {
        Gindex = gindex;
    }

    public void setGname(String gname) {
        Gname = gname;
    }

    public void setGphotoname(String gphotoname) {
        Gphotoname = gphotoname;
    }

    public void setGprice(String gprice) {
        Gprice = gprice;
    }

    public void setGreserve(String greserve) {
        Greserve = greserve;
    }

    public void setGshopname(String gshopname) {
        Gshopname = gshopname;
    }

    public void setGtelnum(String gtelnum) {
        Gtelnum = gtelnum;
    }

    public void setGbrand(String gbrand) {
        Gbrand = gbrand;
    }

    public void setGtransprice(String gtransprice) {
        Gtransprice = gtransprice;
    }

    public void setGlocation(String glocation) {
        Glocation = glocation;
    }

    public void setGdate(String gdate) {
        Gdate = gdate;
    }

    public String getGdate() {
        return Gdate;
    }

    public String getGindex() {
        return Gindex;
    }

    public String getGlocation() {
        return Glocation;
    }

    public String getGname() {
        return Gname;
    }

    public String getGphotoname() {
        return Gphotoname;
    }

    public String getGprice() {
        return Gprice;
    }

    public String getGreserve() {
        return Greserve;
    }

    public String getGshopname() {
        return Gshopname;
    }

    public String getGtelnum() {
        return Gtelnum;
    }

    public String getGbrand() {
        return Gbrand;
    }

    public String getGtransprice() {
        return Gtransprice;
    }
}
