package com.example.dell.pandalive.app;

import com.example.dell.pandalive.greendaoform.HistoryDatabase;
import com.example.dell.pandalive.greendaoform.LiveDatabase;
import com.example.dell.pandalive.greendaoform.MyDatabases;
import com.example.dell.pandalive.greendaoutils.DaoMaster;
import com.example.dell.pandalive.greendaoutils.DaoSession;
import com.example.dell.pandalive.greendaoutils.HistoryDatabaseDao;
import com.example.dell.pandalive.greendaoutils.LiveDatabaseDao;
import com.example.dell.pandalive.greendaoutils.MyDatabasesDao;

/**
 * Created by Administrator on 2017/9/5.
 */

public class DatabaseReady {
    private final HistoryDatabaseDao historyDatabaseDao;
    private final MyDatabasesDao myDatabasesDao;
    private final LiveDatabaseDao liveDatabaseDao;

    public DatabaseReady() {


        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Myapp.activity, "tushuku.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        historyDatabaseDao = daoSession.getHistoryDatabaseDao();

        myDatabasesDao = daoSession.getMyDatabasesDao();
        liveDatabaseDao = daoSession.getLiveDatabaseDao();
    }


    public void add1(String name, String date, String time, String img) {
//HistoryBean historyBean=new HistoryBean(id,name,introduction,time,img);
//HistoryBean dataBean = new HistoryBean("" + i, "上邪", "山无","十一点了","http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120");
//
        HistoryDatabase historyDatabase = new HistoryDatabase();

        historyDatabase.setDname(name);
        historyDatabase.setDimg(img);
        historyDatabase.setDdate(date);
        historyDatabase.setDtime(time);
        historyDatabaseDao.insert(historyDatabase);

    }


    public void add2(String name, String date, String time, String img, String wangzhi, String panduan) {

        MyDatabases myDatabases = new MyDatabases();
        myDatabases.setDname(name);
        myDatabases.setDimg(img);
        myDatabases.setDdate(date);
        myDatabases.setDtime(time);

        myDatabases.setBofang(wangzhi);
        myDatabases.setPanduan(panduan);
        myDatabasesDao.insert(myDatabases);
    }


    public void Aspect(String name, String date, String time, String img, String wangzhi, String panduan) {
//名字介绍，日期，播放时间，图片，网址，直播还是视频
        LiveDatabase liveDatabase = new LiveDatabase();
        liveDatabase.setLname(name);
        liveDatabase.setLimg(img);
        liveDatabase.setLdate(date);
        liveDatabase.setLtime(time);
        liveDatabase.setLbofang(wangzhi);
        liveDatabase.setLpanduan(panduan);
        liveDatabaseDao.insert(liveDatabase);
    }


}
