package com.example.dell.pandalive.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.ui.personal.DebarkActivity;

/**
 * Created by 张凯雅 on 2017/8/27.
 */
////
public class Eye_Personal_Activity extends BaseActivity implements View.OnClickListener {

    private ImageView personal_back_imageview;
    private LinearLayout personal_one_linearlayout;
    private LinearLayout personal_two_linearlayout;
    private LinearLayout personal_three_linearlayout;
    private LinearLayout personal_four_linearlayout;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        personal_back_imageview = (ImageView) findViewById(R.id.personal_back_imageview);
        personal_one_linearlayout = (LinearLayout) findViewById(R.id.personal_one_linearlayout);
        personal_two_linearlayout = (LinearLayout) findViewById(R.id.personal_two_linearlayout);
        personal_three_linearlayout = (LinearLayout) findViewById(R.id.personal_three_linearlayout);
        personal_four_linearlayout = (LinearLayout) findViewById(R.id.personal_four_linearlayout);
        personal_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        personal_one_linearlayout.setOnClickListener(this);

    }

    @Override
    protected int initlayout() {
        return R.layout.eye_personal_activity;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.personal_one_linearlayout:

                startActivity(new Intent(Myapp.activity,DebarkActivity.class));
                break;
        }
    }
}
