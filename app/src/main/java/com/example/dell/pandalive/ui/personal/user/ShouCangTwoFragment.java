package com.example.dell.pandalive.ui.personal.user;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.HistoryBean;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.greendaoform.LiveDatabase;
import com.example.dell.pandalive.greendaoutils.DaoMaster;
import com.example.dell.pandalive.greendaoutils.DaoSession;
import com.example.dell.pandalive.greendaoutils.LiveDatabaseDao;
import com.example.dell.pandalive.ui.eyepanda.activity.Eye_WebView_Activity;
import com.example.dell.pandalive.ui.personal.history.HistoryAdapters;
import com.example.dell.pandalive.utils.PlayActivityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */


public class ShouCangTwoFragment extends BaseFragment {

    private View view;
    private ListView shoucang_listview;
    private LinearLayout shoucang_linearlayout;
    private Button shoucang_button2;
    private Button shoucang_button3;
    private Button shoucang_button5;
    private LiveDatabaseDao liveDatabaseDao;
    private List<LiveDatabase> listshuju;

    private List<HistoryBean> liveshumDatas;
    private HistoryAdapters mmmAdapter;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_shou_cang_one, null);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Myapp.activity, "collection", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        liveDatabaseDao = daoSession.getLiveDatabaseDao();
        listshuju = liveDatabaseDao.queryBuilder().list();

        getid();
        getmonitor();
        getshuju();
        shoucang_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "你点击了" + position + "条目，正在跳转", Toast.LENGTH_LONG).show();

//名字介绍，日期，播放时间，图片，网址，直播还是视频
                for (int i = 0; i < listshuju.size(); i++) {
                    String ltime = listshuju.get(i).getLtime();

                    if (ltime.equals("")) {
                        Intent intent = new Intent(Myapp.activity, Eye_WebView_Activity.class);
                        intent.putExtra("url", listshuju.get(position).getLbofang());
                        startActivity(intent);
                    } else {

                        Intent live = new Intent(Myapp.activity, PlayActivityUtil.class);
                        live.putExtra("title", listshuju.get(position).getLname());
                        live.putExtra("path", listshuju.get(position).getLbofang());
                        live.putExtra("type", "2");
                        startActivity(live);
                    }
                }
            }
        });
    }

    private void getid() {
        shoucang_listview = (ListView) view.findViewById(R.id.shoucang_listview);

        shoucang_linearlayout = (LinearLayout) view.findViewById(R.id.shoucang_linearlayout);
        //全选
        shoucang_button2 = (Button) view.findViewById(R.id.shoucang_button2);
        //取消全选
        shoucang_button3 = (Button) view.findViewById(R.id.shoucang_button3);
        //删除
        shoucang_button5 = (Button) view.findViewById(R.id.shoucang_button5);
    }


    public void getmonitor() {
        //                 setOnClickListener
        shoucang_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //全选
                btnSelectAllList(v);
            }
        });
        shoucang_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //全不选
                btnNoList(v);
            }
        });
        shoucang_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取选中数据
                btnOperateList(v);
            }
        });

    }

    /**
     * 全选
     *
     * @param view
     */
    public void btnSelectAllList(View view) {


        shoucang_button3.setVisibility(View.VISIBLE);
        shoucang_button2.setVisibility(View.GONE);

        if (mmmAdapter.flage) {
            for (int i = 0; i < liveshumDatas.size(); i++) {
                liveshumDatas.get(i).historyisCheck = true;
            }


            mmmAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 全不选
     *
     * @param view
     */
    public void btnNoList(View view) {

        shoucang_button2.setVisibility(View.VISIBLE);
        shoucang_button3.setVisibility(View.GONE);

        if (mmmAdapter.flage) {
            for (int i = 0; i < liveshumDatas.size(); i++) {
                liveshumDatas.get(i).historyisCheck = false;
            }

            mmmAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 编辑、取消编辑
     *
     * @param view
     */
    public void btnEditList(View view) {

        mmmAdapter.flage = !mmmAdapter.flage;

        mmmAdapter.notifyDataSetChanged();
    }


    /**
     * 获取选中数据
     *
     * @param view
     */
    public void btnOperateList(View view) {

        btnNoList(view);

        List<String> ids = new ArrayList<>();

        if (mmmAdapter.flage) {

            for (int i = 0; i < liveshumDatas.size(); i++) {
                if (liveshumDatas.get(i).historyisCheck) {
                    ids.add(liveshumDatas.get(i).historyid);
                }
            }

//            Toast.makeText(getApplicationContext(), ids.toString(), Toast.LENGTH_SHORT).show();

            for (int i = 0; i < ids.size(); i++) {
                String s = ids.get(i);

                liveshumDatas.remove(s);

                for (int j = 0; j < liveshumDatas.size(); j++) {
                    LiveDatabase liveDatabase = listshuju.get(j);
                    liveDatabaseDao.delete(liveDatabase);
                }
            }
            mmmAdapter.notifyDataSetChanged();
        }


        if (ids != null) {

            for (int i = 0; i < ids.size(); i++) {
                liveshumDatas.remove(i);
            }

        }

        mmmAdapter.notifyDataSetChanged();

    }


    public void getshuju() {
        liveshumDatas = new ArrayList<>();
        for (int i = 0; i < listshuju.size(); i++) {
            HistoryBean dataBean = new HistoryBean("" + i,
                    listshuju.get(i).getLname(),
                    listshuju.get(i).getLdate(),
                    listshuju.get(i).getLtime(),
                    listshuju.get(i).getLimg());
            liveshumDatas.add(dataBean);

            mmmAdapter = new HistoryAdapters(getActivity(), liveshumDatas);
            shoucang_listview.setAdapter(mmmAdapter);


        }


    }
}
