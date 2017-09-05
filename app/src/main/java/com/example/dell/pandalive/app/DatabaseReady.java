package com.example.dell.pandalive.app;

import com.example.dell.pandalive.greendaoform.HistoryDatabase;
import com.example.dell.pandalive.greendaoutils.DaoMaster;
import com.example.dell.pandalive.greendaoutils.DaoSession;
import com.example.dell.pandalive.greendaoutils.HistoryDatabaseDao;

/**
 * Created by Administrator on 2017/9/5.
 */

public class DatabaseReady {
    private final HistoryDatabaseDao historyDatabaseDao;

    public DatabaseReady() {


        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Myapp.activity, "tushuku.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        historyDatabaseDao = daoSession.getHistoryDatabaseDao();

    }


    public void add(String name,String date,String time,String img){
//HistoryBean historyBean=new HistoryBean(id,name,introduction,time,img);
//HistoryBean dataBean = new HistoryBean("" + i, "上邪", "山无","十一点了","http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120");
//
        HistoryDatabase historyDatabase=new HistoryDatabase();

        historyDatabase.setDname(name);
        historyDatabase.setDimg(img);
        historyDatabase.setDdate(date);
        historyDatabase.setDtime(time);
        historyDatabaseDao.insert(historyDatabase);

    }

}
