package com.example.dell.pandalive.ui;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/9/7.
 */

public class StartActivity extends BaseActivity {
    private ImageView start;

    @Override
    protected void initdata() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Myapp.activity,MainActivity.class));
                finish();
            }
        }, 4000);

    }

    @Override
    protected void initview() {
        start =(ImageView)findViewById(R.id.start);

    }

    @Override
    protected int initlayout() {
        return R.layout.start_activity;
    }
}
