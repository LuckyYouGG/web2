package bean;

public class MerchantBean {

    private String Mindex = null;
    private String Mtelnum = null;
    private String Mpasswd = null;
    private String Mshopname = null;

    public void setMindex(String mindex) {
        Mindex = mindex;
    }

    public void setMpasswd(String mpasswd) {
        Mpasswd = mpasswd;
    }

    public void setMshopname(String mshopname) {
        Mshopname = mshopname;
    }

    public void setMtelnum(String mtelnum) {
        Mtelnum = mtelnum;
    }

    public String getMindex() {
        return Mindex;
    }

    public String getMpasswd() {
        return Mpasswd;
    }

    public String getMshopname() {
        return Mshopname;
    }

    public String getMtelnum() {
        return Mtelnum;
    }
}
