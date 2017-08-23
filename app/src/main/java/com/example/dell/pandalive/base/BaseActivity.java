package com.example.dell.pandalive.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.dell.pandalive.app.Myapp;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by dell on 2017/8/11.
 */

public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Myapp.activity = this;
        setContentView(initlayout());

        initview();
        initdata();
    }

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract int initlayout();

    @Override
    protected void onResume() {
        super.onResume();
        Myapp.activity = this;
    }
}
