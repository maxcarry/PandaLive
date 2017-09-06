package com.example.dell.pandalive.ui.personal.user;

//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.dell.pandalive.R;
//
//import java.util.ArrayList;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.pandalive.R;

import java.util.ArrayList;

public class ShouCangActivity extends AppCompatActivity {

    private ImageView shoucang_return111;
    private TextView shoucang_edit;
    private TabLayout shoucang_tablayout;
    private ViewPager shoucang_viewpager;
    ArrayList<String> strlist1234 = new ArrayList<String>();
    ArrayList<Fragment> fraglist1234 = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_cang);
        initView();
        initData();
        //设置不能滑动
        shoucang_viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;  //修改为true
            }

        });


    }

    private void initView() {



        shoucang_return111 = (ImageView) findViewById(R.id.shoucang_return111);
        shoucang_edit = (TextView) findViewById(R.id.shoucang_edit);
        shoucang_tablayout = (TabLayout) findViewById(R.id.shoucang_tablayout);
        shoucang_viewpager = (ViewPager) findViewById(R.id.shoucang_viewpager);


        shoucang_return111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void initData() {
        //设置Tablayout标题
        strlist1234.add("直播");
        strlist1234.add("精彩看点");

        //添加Tablayout标题
        shoucang_tablayout.addTab(shoucang_tablayout.newTab().setText(strlist1234.get(0)));
        shoucang_tablayout.addTab(shoucang_tablayout.newTab().setText(strlist1234.get(1)));

        //添加 Fragment   ShouCangOneFragment ShouCangTwoFragment
        fraglist1234.add(new ShouCangOneFragment());
        fraglist1234.add(new ShouCangTwoFragment());

        //viewpager适配器
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        shoucang_viewpager.setAdapter(adapter);
        //tablayout关联viewpager
        shoucang_tablayout.setupWithViewPager(shoucang_viewpager);


    }

    //内部类
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //        public MyAdapter(FragmentManager fm) {
//            super(fm);
//        }

        @Override
        public Fragment getItem(int position) {
            return fraglist1234.get(position);
        }

        @Override
        public int getCount() {
            return fraglist1234.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strlist1234.get(position);
        }
    }


}
