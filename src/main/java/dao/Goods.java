package dao;

public interface Goods {

    public String addGoods(String GTelnum,String Gshapname,
                           String Greserve,String Gname,
                           String Gphotoname,String Gprice,
                            String Gtransprice,String Gdescription,
                           String Glocation,String Gdate,
                           String Gbrand);
    public String deleteGoods(String Gid);
    public String selectGoods(String merMobile);

}
