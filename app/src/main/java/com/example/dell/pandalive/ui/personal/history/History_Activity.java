package com.example.dell.pandalive.ui.personal.history;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.HistoryBean;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.greendaoform.HistoryDatabase;
import com.example.dell.pandalive.greendaoutils.DaoMaster;
import com.example.dell.pandalive.greendaoutils.DaoSession;
import com.example.dell.pandalive.greendaoutils.HistoryDatabaseDao;

import java.util.ArrayList;
import java.util.List;

/*
* 观看历史
*
* */
public class History_Activity extends BaseActivity implements View.OnClickListener {


    private ListView listView;

    private List<HistoryBean> mDatas;

    private HistoryAdapters historyAdapters;
    private Button button2;
    private Button button3;
    private Button button5;
    private TextView history_head_edit;
    private LinearLayout history_linearlayout;
    private HistoryDatabaseDao historyDatabaseDao;
    private ImageView history_head_return111;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
//
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Myapp.activity, "tushuku.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        historyDatabaseDao = daoSession.getHistoryDatabaseDao();


        history_head_edit = (TextView) findViewById(R.id.history_head_edit);
        history_linearlayout = (LinearLayout) findViewById(R.id.history_linearlayout);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button5 = (Button) findViewById(R.id.button5);
        listView = (ListView) findViewById(R.id.listView);
        history_head_return111 = (ImageView) findViewById(R.id.history_head_return111);
        history_head_return111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();


        mDatas = new ArrayList<>();

        List<HistoryDatabase> dlist = historyDatabaseDao.queryBuilder().list();

        for (int i = 0; i < dlist.size(); i++) {
            HistoryBean historyBean = new HistoryBean(i + "", dlist.get(i).getDname(), dlist.get(i).getDtime(), dlist.get(i).getDtime(), dlist.get(i).getDimg());
            mDatas.add(historyBean);
        }

        historyAdapters = new HistoryAdapters(this, mDatas);
        listView.setAdapter(historyAdapters);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Myapp.activity, "你点击了" + position + "条目，正在跳转", Toast.LENGTH_LONG).show();


            }
        });

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_history_s;
    }

    /**
     * 编辑、取消编辑
     *
     * @param view
     */
    public void btnEditList(View view) {

        historyAdapters.flage = !historyAdapters.flage;

        if (historyAdapters.flage) {
            history_head_edit.setText("取消");

//显示
            history_linearlayout.setVisibility(View.VISIBLE);


        } else {
            history_head_edit.setText("编辑");
//隐藏

            history_linearlayout.setVisibility(View.GONE);


        }

        historyAdapters.notifyDataSetChanged();
    }

    /**
     * 全选
     *
     * @param view
     */
    public void btnSelectAllList(View view) {


        button3.setVisibility(View.VISIBLE);
        button2.setVisibility(View.GONE);

        if (historyAdapters.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).historyisCheck = true;
            }

            historyAdapters.notifyDataSetChanged();
        }
    }

    /**
     * 全不选
     *
     * @param view
     */
    public void btnNoList(View view) {

        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.GONE);

        if (historyAdapters.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).historyisCheck = false;
            }

            historyAdapters.notifyDataSetChanged();
        }
    }


    /**
     * 获取选中数据
     *
     * @param view
     */
    public void btnOperateList(View view) {

        List<String> ids = new ArrayList<>();

        if (historyAdapters.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).historyisCheck) {
                    ids.add(mDatas.get(i).historyid);
                    String historytimes = mDatas.get(i).getHistorytimes();
                    HistoryDatabase historyDatabase=new HistoryDatabase();
                    historyDatabase.setDtime(historytimes);
                    historyDatabaseDao.delete(historyDatabase);

                }
            }
        }
        btnNoList(view);
        historyAdapters.notifyDataSetChanged();

    }

    private void initView() {

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        //删除
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view1 = View.inflate(Myapp.activity, R.layout.histouy_popupwindow, null);


               final PopupWindow popupWindow = new PopupWindow(view1, 500, 500);

                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

                popupWindow.setOutsideTouchable(true);
                //展示在当前条目的下方
                popupWindow.setFocusable(true);

                Button popupwindow_confirm = (Button) view1.findViewById(R.id.popupwindow_confirm);


                Button popupwindow_cancel = (Button) view1.findViewById(R.id.popupwindow_cancel);

                //确认
                popupwindow_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //获取选中数据
                        btnOperateList(v);

                    }
                });
                popupwindow_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //关闭popupWindow
                        popupWindow.dismiss();


                    }
                });

            }
        });


        history_head_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 Toast.makeText(MainActivity.this,"这是编辑按钮",Toast.LENGTH_LONG).show();
                btnEditList(view);

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.button2:
                //全选
                btnSelectAllList(v);
                break;
            case R.id.button3:
                //全不选
                btnNoList(v);
                break;

        }
    }

}
/*//        for (int i = 0; i < 10; i++) {
//
//            HistoryBean dataBean = new HistoryBean("" + i, "上邪", "山无","十一点了","http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120");
//            mDatas.add(dataBean);
//        }


//        mDatas = historyDatabaseDao.queryBuilder().list();*/