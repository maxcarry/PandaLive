package com.example.dell.pandalive.ui.livepanda.viewlive;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * 熊猫直播
 */
public class LiveDirectFragment extends BaseFragment {

    private View view;

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


    }
}
