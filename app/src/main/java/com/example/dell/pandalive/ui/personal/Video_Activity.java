package com.example.dell.pandalive.ui.personal;

import android.view.View;
import android.widget.ImageView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/9/4.
 */

public class Video_Activity extends BaseActivity {

    private ImageView video_back_imageview;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        video_back_imageview =(ImageView)findViewById(R.id.video_back_imageview);
        video_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected int initlayout() {
        return R.layout.video_activity;
    }
}
