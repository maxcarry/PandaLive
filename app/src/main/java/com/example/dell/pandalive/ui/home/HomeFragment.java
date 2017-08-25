package com.example.dell.pandalive.ui.home;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/23.
 */

public class HomeFragment extends BaseFragment implements IHomeView {

    private View view;
    private Toolbar home_toolbar;
    private Banner home_banner;

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

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.home_fragment, null);


        home_toolbar = (Toolbar) view.findViewById(R.id.home_toolbar);
        home_banner = (Banner) view.findViewById(R.id.home_banner);
    }

    @Override
    public void Showbanner(ArrayList<String> imalist) {

    }
}
