package bean;

public class UserBean {

    String rowIndex = null;
    String username = null;
    String passwd = null;
    String kind = null;

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setTelnum(String username) {
        this.username = username;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getTelnum() {
        return username;
    }
}
