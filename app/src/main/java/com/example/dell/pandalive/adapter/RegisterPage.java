package com.example.dell.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/28.
 */

public class RegisterPage extends FragmentPagerAdapter{

    private String[] registname = new String[]{"手机注册,邮箱注册"};
    private ArrayList<Fragment> reglist;
    public RegisterPage(FragmentManager fm, ArrayList<Fragment> reglist) {
        super(fm);
        this.reglist = reglist;
    }

    @Override
    public Fragment getItem(int position) {
        return reglist.get(position);
    }

    @Override
    public int getCount() {
        return reglist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return registname[position];
    }
}
