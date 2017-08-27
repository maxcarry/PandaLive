package com.example.dell.pandalive.ui.eyepanda.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/8/27.
 */

public class Eye_Personal_Activity extends BaseActivity {

    private ImageView personal_back_imageview;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        personal_back_imageview = (ImageView) findViewById(R.id.personal_back_imageview);
        personal_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected int initlayout() {
        return R.layout.eye_personal_activity;
    }
}
