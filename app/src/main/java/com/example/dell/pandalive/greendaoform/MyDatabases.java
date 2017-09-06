package com.example.dell.pandalive.greendaoform;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/6.
 */
@Entity
public class MyDatabases {

    @Id
    Long id;
    @Property
    String dimg;
    String dname;
    String dtime;
    String ddate;

    String bofang;
    String panduan;
    public String getPanduan() {
        return this.panduan;
    }
    public void setPanduan(String panduan) {
        this.panduan = panduan;
    }
    public String getBofang() {
        return this.bofang;
    }
    public void setBofang(String bofang) {
        this.bofang = bofang;
    }
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
    @Generated(hash = 459103398)
    public MyDatabases(Long id, String dimg, String dname, String dtime,
            String ddate, String bofang, String panduan) {
        this.id = id;
        this.dimg = dimg;
        this.dname = dname;
        this.dtime = dtime;
        this.ddate = ddate;
        this.bofang = bofang;
        this.panduan = panduan;
    }
    @Generated(hash = 1816728102)
    public MyDatabases() {
    }

    

}
