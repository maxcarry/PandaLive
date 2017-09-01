package com.example.dell.pandalive.ui.livepanda.direct;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * 熊猫直播
 */
public class LiveDirectFragment extends BaseFragment {


    boolean isChanged = false;

    private View view;
    private ImageView live_play_img;
    private TextView live_plau_introduce;
    private RelativeLayout live_play_relative;
    private TabLayout live_plau_tablelayout;
    private ViewPager live_plau_viewpager;



    ArrayList<String> livedirecttag = new ArrayList<String>();
    ArrayList<Fragment> livedirectfraglist = new ArrayList<Fragment>();


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

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_live_direct, null);
//       //找id
//        getid();
//        //箭头图标监听
//        getmonitor();
//        initData();
    }

    private void initData() {

        //设置Tablayout标题
        livedirecttag.add("多视角直播");
        livedirecttag.add("边看边聊");

        //添加Tablayout标题
        live_plau_tablelayout.addTab(live_plau_tablelayout.newTab().setText(livedirecttag.get(0)));
        live_plau_tablelayout.addTab(live_plau_tablelayout.newTab().setText(livedirecttag.get(1)));

        //添加Fragment

        //LookTalkFragment 边看边聊
        livedirectfraglist.add(new MultiAngleFragment());

        //MultiAngleFragment 多视角直播
        livedirectfraglist.add(new LookTalkFragment());

        //viewpager适配器
        MyAdapter adapter = new MyAdapter(getChildFragmentManager());
        live_plau_viewpager.setAdapter(adapter);
        //tablayout关联viewpager
        live_plau_tablelayout.setupWithViewPager(live_plau_viewpager);


    }

    //内部类
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return livedirectfraglist.get(position);
        }

        @Override
        public int getCount() {
            return livedirectfraglist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return livedirecttag.get(position);
        }
    }

    private void getmonitor() {
        live_play_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == live_play_relative) {

                    if (isChanged) {

                        live_play_img.setImageDrawable(getResources().getDrawable(R.mipmap.lpanda_show));

                        live_plau_introduce.setVisibility(View.GONE);
                        //隐藏文字
                    } else {
                        live_play_img.setImageDrawable(getResources().getDrawable(R.mipmap.lpanda_off));
                        //显示文字
                        live_plau_introduce.setVisibility(View.VISIBLE);
                    }
                    isChanged = !isChanged;


                }

                }
        });
    }

    private void getid() {
        //介绍小三角图标
        live_play_img = (ImageView) view.findViewById(R.id.live_play_img);
        //介绍（文字）
        live_plau_introduce = (TextView) view.findViewById(R.id.live_plau_introduce);
        live_play_relative = (RelativeLayout) view.findViewById(R.id.live_play_relative);



        live_plau_tablelayout = (TabLayout) view.findViewById(R.id.live_plau_tablelayout);
        live_plau_viewpager = (ViewPager) view.findViewById(R.id.live_plau_viewpager);


    }
}
