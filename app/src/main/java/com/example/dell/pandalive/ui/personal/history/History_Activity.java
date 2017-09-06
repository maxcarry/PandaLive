package com.example.dell.pandalive.ui.personal.history;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.HistoryBean;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.greendaoform.MyDatabases;
import com.example.dell.pandalive.greendaoutils.DaoMaster;
import com.example.dell.pandalive.greendaoutils.DaoSession;
import com.example.dell.pandalive.greendaoutils.MyDatabasesDao;
import com.example.dell.pandalive.utils.PlayActivityUtil;

import java.util.ArrayList;
import java.util.List;


/*
* 观看历史
*
* */
public class History_Activity extends BaseActivity implements View.OnClickListener {


    private ListView listView;

    private List<HistoryBean> mDatas;

    private HistoryAdapters mAdapter;
    private Button button2;
    private Button button3;
    private Button button5;
    private TextView history_head_edit;
    private LinearLayout history_linearlayout;
    private MyDatabasesDao myDatabasesDao;
    private ImageView history_head_return111;
    private List<MyDatabases> list;


    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Myapp.activity, "tushuku.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        myDatabasesDao = daoSession.getMyDatabasesDao();


        history_head_edit = (TextView) findViewById(R.id.history_head_edit);
        history_linearlayout = (LinearLayout) findViewById(R.id.history_linearlayout);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button5 = (Button) findViewById(R.id.button5);
        listView = (ListView) findViewById(R.id.listView);
        history_head_return111 = (ImageView) findViewById(R.id.history_head_return111);
        list = myDatabasesDao.queryBuilder().list();

        initView();


        gettianjiashuju();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(getApplicationContext(), "你点击了" + position + "条目，正在跳转", Toast.LENGTH_LONG).show();

                Intent live = new Intent(Myapp.activity, PlayActivityUtil.class);
                live.putExtra("title", list.get(position).getDname());
                live.putExtra("path", list.get(position).getBofang());
                live.putExtra("type", "2");
                startActivity(live);


            }
        });
        history_head_return111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void gettianjiashuju() {


        mDatas = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            HistoryBean dataBean = new HistoryBean("" + i,
                    list.get(i).getDname(),
                    list.get(i).getDdate(),
                    list.get(i).getDtime(),
                    list.get(i).getDimg());
            mDatas.add(dataBean);
        }


        mAdapter = new HistoryAdapters(this, mDatas);
        listView.setAdapter(mAdapter);
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

        mAdapter.flage = !mAdapter.flage;

        if (mAdapter.flage) {
            history_head_edit.setText("取消");

//显示
            history_linearlayout.setVisibility(View.VISIBLE);


        } else {
            history_head_edit.setText("编辑");
//隐藏

            history_linearlayout.setVisibility(View.GONE);


        }

        mAdapter.notifyDataSetChanged();
    }

    /**
     * 全选
     *
     * @param view
     */
    public void btnSelectAllList(View view) {


        button3.setVisibility(View.VISIBLE);
        button2.setVisibility(View.GONE);

        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).historyisCheck = true;
            }




            mAdapter.notifyDataSetChanged();
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

        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).historyisCheck = false;
            }

            mAdapter.notifyDataSetChanged();
        }
    }


    /**
     * 获取选中数据
     *
     * @param view
     */
    public void btnOperateList(View view) {

        btnNoList(view);

        List<String> ids = new ArrayList<>();

        if (mAdapter.flage) {

            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).historyisCheck) {
                    ids.add(mDatas.get(i).historyid);
                }
            }

//            Toast.makeText(getApplicationContext(), ids.toString(), Toast.LENGTH_SHORT).show();

            for (int i = 0; i < ids.size(); i++) {
                String s = ids.get(i);

                mDatas.remove(s);

                for (int j = 0; j <mDatas.size() ; j++) {
                    MyDatabases myDatabases = list.get(j);
                    myDatabasesDao.delete(myDatabases);
                }
            }

            mAdapter.notifyDataSetChanged();

        }


        if (ids != null) {

            for (int i = 0; i < ids.size(); i++) {
                mDatas.remove(i);
            }

        }


        mAdapter.notifyDataSetChanged();


//        mAdapter.notifyDataSetChanged();
    }

    private void initView() {

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button5.setOnClickListener(this);


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

            case R.id.button5:
                //获取选中数据
                btnOperateList(v);
                break;
        }
    }

}
