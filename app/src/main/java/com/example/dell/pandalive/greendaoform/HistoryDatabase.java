package com.example.dell.pandalive.greendaoform;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/5.
 */
@Entity
public class HistoryDatabase {


    @Id
    Long id;
    @Property
    String dimg;
    String dname;
    String dtime;
    String ddate;
    public String getDdate() {
        return this.ddate;
    }
    public void setDdate(String ddate) {
        this.ddate = ddate;
    }
    public String getDtime() {
        return this.dtime;
    }
    public void setDtime(String dtime) {
        this.dtime = dtime;
    }
    public String getDname() {
        return this.dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getDimg() {
        return this.dimg;
    }
    public void setDimg(String dimg) {
        this.dimg = dimg;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1796577616)
    public HistoryDatabase(Long id, String dimg, String dname, String dtime,
            String ddate) {
        this.id = id;
        this.dimg = dimg;
        this.dname = dname;
        this.dtime = dtime;
        this.ddate = ddate;
    }
    @Generated(hash = 1570817937)
    public HistoryDatabase() {
    }



}
