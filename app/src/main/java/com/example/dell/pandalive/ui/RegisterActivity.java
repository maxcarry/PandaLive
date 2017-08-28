package com.example.dell.pandalive.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.RegisterPage;
import com.example.dell.pandalive.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/28.
 */

public class RegisterActivity extends BaseActivity {

    private ImageView register_back;
    private TabLayout register_tab;
    private ViewPager register_viewpager;

    @Override
    protected void initdata() {

        ArrayList<Fragment> reglist = new ArrayList<>();

        RegisterPage registerPage = new RegisterPage(getSupportFragmentManager(),reglist);
        register_viewpager.setAdapter(registerPage);

        register_tab.setTabMode(TabLayout.MODE_FIXED);
        register_tab.setupWithViewPager(register_viewpager);

    }

    @Override
    protected void initview() {

        register_back = (ImageView) findViewById(R.id.register_back);
        register_tab = (TabLayout) findViewById(R.id.register_tab);
        register_viewpager = (ViewPager) findViewById(R.id.register_viewpager);
    }

    @Override
    protected int initlayout() {
        return R.layout.register_activity;
    }
}
