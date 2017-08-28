package com.example.dell.pandalive.ui;

import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;

/**
 * Created by dell on 2017/8/28.
 */

public class PhoneRegFragment extends BaseFragment {
    private View view;
    private View view1;

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

        view1 = LayoutInflater.from(Myapp.activity).inflate(R.layout.phone_register, null);

    }
}
