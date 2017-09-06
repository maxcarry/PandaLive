package com.example.dell.pandalive.ui.personal.collection;

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

import java.util.ArrayList;
import java.util.List;

import static com.example.dell.pandalive.R.id.Collection_viewpaget;

/*
*
* 收藏记录
*
* */
public class Collection_Activity extends BaseFragment {

    private View view;

    private List<String> listTitles11= new ArrayList<>();
    private List<Fragment> fragments11 = new ArrayList<>();
    private NoScrollViewPager collection_viewpaget;
    private TabLayout collection_tablayout;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        getid();
        initData();
        //设置不能滑动
        collection_viewpaget.setNoScroll(true);

    }
    private void getid() {
        collection_tablayout = (TabLayout) view.findViewById(R.id.Collection_tablayout);

        collection_viewpaget = (NoScrollViewPager) view.findViewById(Collection_viewpaget);
    }


    private void initData() {
        //设置Tablayout标题
        listTitles11.add("直播");
        listTitles11.add("精彩看点");

        //添加Tablayout标题

        collection_tablayout.addTab(collection_tablayout.newTab().setText(listTitles11.get(0)));
        collection_tablayout.addTab(collection_tablayout.newTab().setText(listTitles11.get(1)));



        //添加Fragment
//        //直播    CollectionDirectFragment
       fragments11.add(new CollectionDirectFragment());
//        //精彩看点  CollectionWonderfulFragment
        fragments11.add(new CollectionWonderfulFragment());



        //viewpager适配器  getChildFragmentManager  getSupportFragmentManager
        MyAdapter11 adapter = new MyAdapter11(getFragmentManager());
        collection_viewpaget.setAdapter(adapter);
        //tablayout关联viewpager
        collection_tablayout.setupWithViewPager(collection_viewpaget);


    }
    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.activity_collection_, null);
    }


    //内部类
    private class MyAdapter11 extends FragmentPagerAdapter {
        public MyAdapter11(FragmentManager fm) {
            super(fm);
        }

//        public MyAdapter(FragmentManager fm) {
//            super(fm);
//        }

        @Override
        public Fragment getItem(int position) {
            return fragments11.get(position);
        }

        @Override
        public int getCount() {
            return fragments11.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return listTitles11.get(position);
        }
    }

}
