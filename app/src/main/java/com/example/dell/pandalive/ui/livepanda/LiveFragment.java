package com.example.dell.pandalive.ui.livepanda;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.custom_view.NoScrollViewPager;
import com.example.dell.pandalive.ui.livepanda.archives.LiveArchivesFragment;
import com.example.dell.pandalive.ui.livepanda.Livemain.LiveDirectFragment;
import com.example.dell.pandalive.ui.livepanda.original.LiveOriginalFragment;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.splendid.LiveSplendidFragment;
import com.example.dell.pandalive.ui.livepanda.thing.LiveThingFragment;
import com.example.dell.pandalive.ui.livepanda.top.LiveTOPFragment;
import com.example.dell.pandalive.ui.livepanda.unusual.LiveUnusualFragment;
import com.example.dell.pandalive.ui.livepanda.yield.LiveYieldFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class LiveFragment extends BaseFragment {
    private View view;
    private NoScrollViewPager live_viewpaget;
    private TabLayout live_tablayout;
    private List<String> listTitles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    //不用管
    @Override
    protected void restartdata() {

    }

    //添加数据
    @Override
    protected void initdata() {
        getid();
        initData();
        //设置不能滑动
        live_viewpaget.setNoScroll(true);


    }


    private void getid() {
        live_tablayout = (TabLayout) view.findViewById(R.id.live_tablayout);

        live_viewpaget = (NoScrollViewPager) view.findViewById(R.id.live_viewpaget);
    }

    @Override
    protected View initlayout() {

        return view;
    }

    //找布局
    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.live_fragment, null);

    }

    private void initData() {
        //设置Tablayout标题
        listTitles.add("直播");
        listTitles.add("精彩一刻");
        listTitles.add("当熊不让");
        listTitles.add("超萌滚滚秀");
        listTitles.add("熊猫档案");
        listTitles.add("熊猫TOP榜");
        listTitles.add("熊猫那些事");
        listTitles.add("特别节目");
        listTitles.add("原创新闻");
        //添加Tablayout标题

        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(0)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(1)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(2)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(3)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(4)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(5)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(6)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(7)));
        live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(8)));


        //添加Fragment
//        //直播
        fragments.add(new LiveDirectFragment());
//        //精彩一刻LiveSplendidFragment
        fragments.add(new LiveSplendidFragment());
//        //当熊不让
        fragments.add(new LiveYieldFragment());
//        //超萌滚滚秀
        fragments.add(new LivePerformFragment());
        //熊猫档案
        fragments.add(new LiveArchivesFragment());
//        //熊猫top榜
        fragments.add(new LiveTOPFragment());
//        //熊猫那些事
        fragments.add(new LiveThingFragment());
//        //特别节目
        fragments.add(new LiveUnusualFragment());
//        //原创新闻
        fragments.add(new LiveOriginalFragment());


        //viewpager适配器
        MyAdapter adapter = new MyAdapter(getChildFragmentManager());
        live_viewpaget.setAdapter(adapter);
        //tablayout关联viewpager
        live_tablayout.setupWithViewPager(live_viewpaget);


    }

    //内部类
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listTitles.get(position);
        }
    }


}
