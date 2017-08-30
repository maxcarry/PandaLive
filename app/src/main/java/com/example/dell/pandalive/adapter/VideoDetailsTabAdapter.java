package com.example.dell.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 贾成昆 on 2017/8/29.
 */

public class VideoDetailsTabAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> list;
    String []str=new String[]{"高清完整","精彩看点"};

    public VideoDetailsTabAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
