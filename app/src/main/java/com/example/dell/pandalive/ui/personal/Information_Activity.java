package com.example.dell.pandalive.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/9/4.
 */

public class Information_Activity extends BaseActivity implements View.OnClickListener {

    private LinearLayout information_name_linearlayout;
    private ImageView information_back_imageview;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        information_back_imageview =(ImageView)findViewById(R.id.information_back_imageview);
        information_name_linearlayout =(LinearLayout)findViewById(R.id.information_name_linearlayout);

        information_back_imageview.setOnClickListener(this);
        information_name_linearlayout.setOnClickListener(this);

    }

    @Override
    protected int initlayout() {
        return R.layout.information_activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.information_back_imageview:

                finish();

                break;

            case R.id.information_name_linearlayout:

                Intent intent=new Intent(Myapp.activity,Revise_Activity.class);
                startActivity(intent);

                break;
        }
    }
}
