package com.example.dell.pandalive.ui.livepanda;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.splendid.LiveSplendidFragment;
import com.example.dell.pandalive.ui.livepanda.top.LiveTOPFragment;
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

//    private List<Fragment> list_fragment;  //定义要装fragment的列表
//    private List<String> list_title;
//    private LiveDirectFragment liveDirectFragment;
//    private LiveSplendidFragment liveSplendidFragment;

/////////////////

    //    private LayoutInflater mInflater;
//    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
//    private View view1, view2, view3, view4, view5;//页卡视图
//    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private List<String> listTitles;
    private List<Fragment> fragments;
    private List<TextView> listTextViews;
    private FragmentManager supportFragmentManager;

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

        live_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 6; i < listTitles.size(); i++) {
            com.example.dell.pandalive.ui.livepanda.viewlive.LiveSplendidFragment fragment = com.example.dell.pandalive.ui.livepanda.viewlive.LiveSplendidFragment.newInstance(listTitles.get(i));
            fragments.add(fragment);
        }


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


/*   live_tablayout = (TabLayout) view.findViewById(R.id.live_tablayout);

        live_viewpaget = (ViewPager) view.findViewById(R.id.live_viewpaget);
        //熊猫直播
        liveDirectFragment = new LiveDirectFragment();
        //精彩一刻
        liveSplendidFragment = new LiveSplendidFragment();


        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(liveDirectFragment);
        list_fragment.add(liveSplendidFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用

        list_title = new ArrayList<>();
        list_title.add("直播");
        list_title.add("精彩一刻");


        //设置TabLayout的模式
        live_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //为TabLayout添加tab名称

        for (int i = 0; i < list_title.size(); i++) {
            live_tablayout.addTab(live_tablayout.newTab().setText(list_title.get(i)));
        }


        //设置不能滑动
        live_viewpaget.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;  //修改为true
            }

        });
        LiveDirectAdapter fAdapter = new LiveDirectAdapter(getActivity().getSupportFragmentManager(), list_fragment, list_title);


        //viewpager加载adapter
        live_viewpaget.setAdapter(fAdapter);

        //TabLayout加载viewpager
        live_tablayout.setupWithViewPager(live_viewpaget);
*/


   /* //初始化各fragment
        //原创新闻
        yuanchuang = new YuanChuangFragment();
        //特别节目
        tiebie =new  TieBieFragment();
        //熊猫那些事
        naxieshi = new NaXieShiFragment();
        //熊猫TOP榜
        topbang = new TOPBangFragment();
        //熊猫档案
        dangan = new DangAnFragment();
        //超萌滚滚秀
        chaoMengFragmen = new ChaoMengFragmen();
        //当熊不让
        dangxiong = new DangXiongFragmen();
        //精彩一刻
        jingcai = new JingCaiFragmen();
        //直播
        zhibo = new ZhiBoFragmen();




  //将fragment装进列表中

        list_fragment.add(naxieshi);
        list_fragment.add(topbang);
        list_fragment.add(dangan);
        list_fragment.add(chaoMengFragmen);
        list_fragment.add(dangxiong);
        list_fragment.add(jingcai);
        list_fragment.add(zhibo);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用

        list_title.add("当熊不让");
        list_title.add("超萌滚滚秀");
        list_title.add("熊猫档案");
        list_title.add("熊猫TOP榜");
        list_title.add("熊猫那些事");
        list_title.add("特别节目");
        list_title.add("原创新闻");

      */