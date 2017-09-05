package com.example.dell.pandalive.app;

/**
 * Created by Administrator on 2017/9/5.
 */

public class HistoryBean {


    public String historyid;

    public String historytitle;

    public String historydesc;

    public String historyimg;
    public boolean historyisCheck;

    public String historytimes;


    public String getHistoryid() {
        return historyid;
    }

    public void setHistoryid(String historyid) {
        this.historyid = historyid;
    }

    public String getHistorytitle() {
        return historytitle;
    }

    public void setHistorytitle(String historytitle) {
        this.historytitle = historytitle;
    }

    public String getHistorydesc() {
        return historydesc;
    }

    public void setHistorydesc(String historydesc) {
        this.historydesc = historydesc;
    }

    public String getHistoryimg() {
        return historyimg;
    }

    public void setHistoryimg(String historyimg) {
        this.historyimg = historyimg;
    }

    public boolean isHistoryisCheck() {
        return historyisCheck;
    }

    public void setHistoryisCheck(boolean historyisCheck) {
        this.historyisCheck = historyisCheck;
    }

    public String getHistorytimes() {
        return historytimes;
    }

    public void setHistorytimes(String historytimes) {
        this.historytimes = historytimes;
    }

    public HistoryBean(String historyid, String historytitle, String historydesc, String historytimes, String historyimg) {
            this.historyid = historyid;
            this.historytitle = historytitle;
            this.historydesc = historydesc;
            this.historytimes = historytimes;
            this.historyimg = historyimg;




        }
}
