package com.example.dell.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/28.
 */

public class ChinaPage extends FragmentStatePagerAdapter{

    ArrayList<Fragment> fragments;
    ArrayList<String> tabtitle;

    public ChinaPage(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> tabtitle) {
        super(fm);
        this.fragments = fragments;
        this.tabtitle = tabtitle;
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
        return tabtitle.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
