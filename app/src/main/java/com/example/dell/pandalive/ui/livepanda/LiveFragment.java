package com.example.dell.pandalive.ui.livepanda;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.archives.LiveArchivesFragment;
import com.example.dell.pandalive.ui.livepanda.original.LiveOriginalFragment;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.splendid.LiveSplendidFragment;
import com.example.dell.pandalive.ui.livepanda.thing.LiveThingFragment;
import com.example.dell.pandalive.ui.livepanda.top.LiveTOPFragment;
import com.example.dell.pandalive.ui.livepanda.unusual.LiveUnusualFragment;
import com.example.dell.pandalive.ui.livepanda.viewlive.LiveDirectFragment;
import com.example.dell.pandalive.ui.livepanda.yield.LiveYieldFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class LiveFragment extends BaseFragment {

    private View view;
    private ViewPager live_viewpaget;
    private TabLayout live_tablayout;
    private List<String> listTitles;
    private List<Fragment> fragments;
    private List<TextView> listTextViews;
//    private FragmentManager supportFragmentManager;

    //不用管
    @Override
    protected void restartdata() {

    }

    //添加数据
    @Override
    protected void initdata() {
        live_tablayout = (TabLayout) view.findViewById(R.id.live_tablayout);

        live_viewpaget = (ViewPager) view.findViewById(R.id.live_viewpaget);

        listTitles = new ArrayList<>();
        fragments = new ArrayList<>();
        listTextViews = new ArrayList<>();

        listTitles.add("直播");
        listTitles.add("精彩一刻");
        listTitles.add("当熊不让");
        listTitles.add("超萌滚滚秀");
        listTitles.add("熊猫档案");
        listTitles.add("熊猫TOP榜");
        listTitles.add("熊猫那些事");
        listTitles.add("特别节目");
        listTitles.add("原创新闻");
        //直播
        LiveDirectFragment liveDirectFragment=new LiveDirectFragment();
        fragments.add(0,liveDirectFragment);
        //精彩一刻
        LiveSplendidFragment jingcaiFragment=new LiveSplendidFragment();
        fragments.add(1,jingcaiFragment);
        //当熊不让
        LiveYieldFragment liveYieldFragment=new LiveYieldFragment();
        fragments.add(2,liveYieldFragment);
        //超萌滚滚秀
        LivePerformFragment livePerformFragment=new LivePerformFragment();
        fragments.add(3,livePerformFragment);
        //熊猫档案
        LiveArchivesFragment liveArchivesFragment=new LiveArchivesFragment();
        fragments.add(4,liveArchivesFragment);

        //熊猫top榜
        LiveTOPFragment liveTOPFragment=new LiveTOPFragment();
        fragments.add(5,liveTOPFragment);

        //熊猫那些事
        LiveThingFragment liveThingFragment=new LiveThingFragment();
        fragments.add(6,liveThingFragment);
        //特别节目
        LiveUnusualFragment liveUnusualFragment=new LiveUnusualFragment();
        fragments.add(7,liveUnusualFragment);

        //原创新闻
        LiveOriginalFragment liveOriginalFragment=new LiveOriginalFragment();
        fragments.add(8,liveOriginalFragment);

        live_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        for (int i = 9; i < listTitles.size(); i++) {
//            com.example.dell.pandalive.ui.livepanda.viewlive.LiveSplendidFragment fragment = com.example.dell.pandalive.ui.livepanda.viewlive.LiveSplendidFragment.newInstance(listTitles.get(i));
//            fragments.add(fragment);
//        }


//        for (int i = 0; i < listTitles.size(); i++) {
//            live_tablayout.addTab(live_tablayout.newTab().setText(listTitles.get(i)));//添加tab选项
//        }

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {


            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return listTitles.get(position);
            }
        };
        live_viewpaget.setAdapter(mAdapter);

        live_tablayout.setupWithViewPager(live_viewpaget);//将TabLayout和ViewPager关联起来。
        live_tablayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

        //设置不能滑动
        live_viewpaget.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;  //修改为true
            }

        });
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
}
