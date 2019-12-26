package bean;

public class HistoryOrdersBean {
    String dataTime = null;
    String ids[] = null;

    public String getDataTime() {
        return dataTime;
    }

    public String[] getIds() {
        return ids;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
