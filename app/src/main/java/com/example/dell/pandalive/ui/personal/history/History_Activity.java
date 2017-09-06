package com.example.dell.pandalive.ui.personal.history;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

import static com.umeng.message.proguard.n.R;

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

        List<String> ids = new ArrayList<>();

        if (mAdapter.flage) {

            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).historyisCheck) {
                    ids.add(mDatas.get(i).historyid);
                }
            }

            Toast.makeText(getApplicationContext(), ids.toString(), Toast.LENGTH_SHORT).show();

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


        btnNoList(view);
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
/*
    List<HistoryDatabase> dlist=new ArrayList<>();
    private ListView listView;

    private List<HistoryBean> mDatas;

    private HistoryAdapters historyAdapters;
    private Button button2;
    private Button button3;
    private Button button5;
    private TextView history_head_edit;
    private LinearLayout history_linearlayout;
//    private HistoryDatabaseDao historyDatabaseDao;
    private ImageView history_head_return111;
    private MyDatabasesDao myDatabasesDao;
    private List<MyDatabases> list;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
//
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
        history_head_return111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list = myDatabasesDao.queryBuilder().list();

        for (int i = 0; i <list.size() ; i++) {


            mDatas
//                HistoryBean historyBean = new HistoryBean(i + "", dlist.get(i).getDname(), dlist.get(i).getDtime(), dlist.get(i).getDtime(), dlist.get(i).getDimg());
//                mDatas.add(historyBean);
//            }
//
//            historyAdapters = new HistoryAdapters(this, mDatas);
//            listView.setAdapter(historyAdapters);

        }


        HistoryAdapters historyAdapters=new HistoryAdapters(Myapp.activity,mDatas);


//         list = benDao.queryBuilder().list();
//                 //list的适配器
//                 Adapters adapters = new Adapters(ShuJuKuActivity.this, list);
//
//                 shujuku_listview.setAdapter(adapters);





        initView();


        getchaxun();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Myapp.activity, "你点击了" + position + "条目，正在跳转", Toast.LENGTH_LONG).show();



                Intent live = new Intent(Myapp.activity, PlayActivityUtil.class);
                live.putExtra("title",   list.get(position).getDname());
                live.putExtra("path", list.get(position).getBofang());
                live.putExtra("type", list.get(position).getPanduan());
                startActivity(live);




            }
        });

    }

    private void getchaxun() {





        mDatas = new ArrayList<>();



        for (int i = 0; i < dlist.size(); i++) {
            HistoryBean historyBean = new HistoryBean(i + "", dlist.get(i).getDname(), dlist.get(i).getDtime(), dlist.get(i).getDtime(), dlist.get(i).getDimg());
            mDatas.add(historyBean);
        }

        historyAdapters = new HistoryAdapters(this, mDatas);
        listView.setAdapter(historyAdapters);
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_history_s;
    }

    *//**
 * 编辑、取消编辑
 *
 * @param view
 * <p>
 * 全选
 * @param view
 * <p>
 * 全不选
 * @param view
 * <p>
 * 获取选中数据
 * @param
 *//*
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

    *//**
 * 全选
 *
 * @param view
 *//*
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

    *//**
 * 全不选
 *
 * @param view
 *//*
    public void btnNoList(View view) {

        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.GONE);
//
        if (historyAdapters.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).historyisCheck = false;
            }

            historyAdapters.notifyDataSetChanged();
        }
    }


    *//**
 * 获取选中数据
 *
 * @param
 *//*
//    public void btnOperateList(View view) {
//
//
//        List<String> ids = new ArrayList<>();
//
//        if (historyAdapters.flage) {
//
//            for (int i = 0; i < ids.size(); i++) {
//                HistoryDatabase entity=dlist.get(i);
//                historyDatabaseDao.delete(entity);
//            }
//            startActivity(new Intent(getApplicationContext(),History_Activity.class));
//
//            btnNoList(view);
//            getchaxun();
//            historyAdapters.notifyDataSetChanged();
//
//
//        }
//
//        btnNoList(view);
////        historyAdapters.notifyDataSetChanged();
// Toast.makeText(getApplicationContext(),"执行完了",Toast.LENGTH_LONG).show();
//    }

    private void initView() {

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        //删除
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //获取选中数据
//                btnOperateList(v);


              *//*

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
*//*
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

}*/
/*//        for (int i = 0; i < 10; i++) {
//
//            HistoryBean dataBean = new HistoryBean("" + i, "上邪", "山无","十一点了","http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120");
//            mDatas.add(dataBean);
//        }


//        mDatas = historyDatabaseDao.queryBuilder().list();*/