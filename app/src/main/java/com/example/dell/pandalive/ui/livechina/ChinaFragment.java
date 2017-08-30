package com.example.dell.pandalive.ui.livechina;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.ChinaPage;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.custom_view.NoScrollViewPager;
import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.eventbus.ChinaEvent;
import com.example.dell.pandalive.ui.livechina.presenter.ChinaPresenter;
import com.example.dell.pandalive.ui.livechina.tabfragment.ColumnActivity;
import com.example.dell.pandalive.ui.livechina.tabfragment.ColumnFragment;
import com.example.dell.pandalive.utils.DialogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class ChinaFragment extends BaseFragment implements IChinaView{

    private View view;
    private ImageView china_person;
    private TabLayout china_tab;
    private ImageView china_add_ima;
    private NoScrollViewPager china_viewpager;
    private ChinaPresenter chinaPresenter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> tabtitle = new ArrayList<>();
    private List<ChinaBean.AlllistBean> alllist;
    private List<ChinaBean.TablistBean> tablist;
    private RelativeLayout china_re;
    private ChinaPage chinaPage;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

        DialogUtil.instance().Showdialog(Myapp.activity);
        chinaPresenter.ShowTab();
    }

    @Override
    protected View initlayout() {

        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.china_fragment, null);

        chinaPresenter = new ChinaPresenter(this);

        china_person = (ImageView) view.findViewById(R.id.china_person);
        china_tab = (TabLayout) view.findViewById(R.id.china_tab);
        china_add_ima = (ImageView) view.findViewById(R.id.china_add_ima);
        china_viewpager = (NoScrollViewPager) view.findViewById(R.id.china_viewpager);
        china_re = (RelativeLayout) view.findViewById(R.id.china_re);

        china_add_ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Myapp.activity, ColumnActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("key1", (Serializable) tablist);
                bundle.putSerializable("key2", (Serializable) alllist);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //设置viewpager不可滑动
        china_viewpager.setNoScroll(true);
    }

    @Override
    public void ShowTab(List<ChinaBean.TablistBean> tablist, List<ChinaBean.AlllistBean> alllist) {

        this.alllist = alllist;
        this.tablist = tablist;
        for (ChinaBean.TablistBean tablistBean : tablist) {

            ColumnFragment columnFragment = new ColumnFragment(tablistBean.getUrl());
            fragments.add(columnFragment);
            tabtitle.add(tablistBean.getTitle());

        }

        chinaPage = new ChinaPage(getActivity().getSupportFragmentManager(),fragments,tabtitle);
        china_viewpager.setAdapter(chinaPage);

        china_tab.setupWithViewPager(china_viewpager);

        DialogUtil.instance().Hidedialog();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ChinaEvent event) {

        DialogUtil.instance().Showdialog(Myapp.activity);
        fragments.clear();
        tabtitle.clear();
        tablist = event.getTablist();
        alllist = event.getAlllist();

        for (ChinaBean.TablistBean tablistBean : tablist) {

            ColumnFragment columnFragment = new ColumnFragment(tablistBean.getUrl());
            fragments.add(columnFragment);
            tabtitle.add(tablistBean.getTitle());

        }

        chinaPage.notifyDataSetChanged();

        DialogUtil.instance().Hidedialog();
    }
}
