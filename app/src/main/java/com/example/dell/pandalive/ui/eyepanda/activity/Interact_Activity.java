package com.example.dell.pandalive.ui.eyepanda.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.InteractListViewAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.ui.eyepanda.IEyeView;
import com.example.dell.pandalive.ui.eyepanda.presenter.EyePresenter;
import com.example.dell.pandalive.utils.DialogUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */
////////
public class Interact_Activity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener ,IEyeView{

    private ImageView interact_back_imageview;
    private ListView interact_listview;
    private List<InteractListViewBean.InteractiveBean> listViewBeen=new ArrayList<>();
    private SmartRefreshLayout interact_refreshlayout;

    @Override
    protected void initdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);

        interact_refreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);

            }
        });

    }


    @Override
    protected void initview() {
        interact_refreshlayout = (SmartRefreshLayout) findViewById(R.id.interact_refreshlayout);
        interact_back_imageview = (ImageView) findViewById(R.id.interact_back_imageview);
        interact_listview = (ListView) findViewById(R.id.interact_listview);
        EyePresenter eyePresenter = new EyePresenter(this);
        eyePresenter.ShowInteract();

        //下拉刷新
        interact_refreshlayout.setRefreshHeader(new ClassicsHeader(Myapp.activity));

        interact_back_imageview.setOnClickListener(this);

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_interact;
    }

    @Override
    public void onClick(View v) {

            finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent interactintent=new Intent(Interact_Activity.this,Interact_WebView_Activity.class);
        interactintent.putExtra("url",listViewBeen.get(position).getUrl());
        interactintent.putExtra("title",listViewBeen.get(position).getTitle());
        startActivity(interactintent);
    }

    @Override
    public void ShowEyeBanner(List<BigImageBean.DataBean.BigImgBean> bigImg) {

    }

    @Override
    public void ShowEyeList(List<EyeListBean.ListBean> eyelist) {

    }

    @Override
    public void ShowInteract(List<InteractListViewBean.InteractiveBean> interactBeen) {
        listViewBeen.addAll(interactBeen);
        InteractListViewAdapter adapter=new InteractListViewAdapter(this,listViewBeen);
        interact_listview.setAdapter(adapter);
        interact_listview.setOnItemClickListener(this);

        DialogUtil.instance().Hidedialog();
    }
}
