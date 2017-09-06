package com.example.dell.pandalive.greendaoform;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/9/6.
 */
@Entity
public class LiveDatabase {

    @Id
    Long id;
    @Property
    String limg;//图片
    String lname;//名字
    String ltime;//播放时间
    String ldate;//日期

    String lbofang;//播放网址
    String lpanduan;//直播还是视频
    public String getLpanduan() {
        return this.lpanduan;
    }
    public void setLpanduan(String lpanduan) {
        this.lpanduan = lpanduan;
    }
    public String getLbofang() {
        return this.lbofang;
    }
    public void setLbofang(String lbofang) {
        this.lbofang = lbofang;
    }
    public String getLdate() {
        return this.ldate;
    }
    public void setLdate(String ldate) {
        this.ldate = ldate;
    }
    public String getLtime() {
        return this.ltime;
    }
    public void setLtime(String ltime) {
        this.ltime = ltime;
    }
    public String getLname() {
        return this.lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getLimg() {
        return this.limg;
    }
    public void setLimg(String limg) {
        this.limg = limg;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 104283918)
    public LiveDatabase(Long id, String limg, String lname, String ltime,
            String ldate, String lbofang, String lpanduan) {
        this.id = id;
        this.limg = limg;
        this.lname = lname;
        this.ltime = ltime;
        this.ldate = ldate;
        this.lbofang = lbofang;
        this.lpanduan = lpanduan;
    }
    @Generated(hash = 982327997)
    public LiveDatabase() {
    }




}
