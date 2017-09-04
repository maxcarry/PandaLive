package com.example.dell.pandalive.ui.personal;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.utils.DialogUtil;

/**
 * Created by 张凯雅 on 2017/9/3.
 */

public class Install_Activity extends BaseActivity implements View.OnClickListener {

    private ImageView install_back_imageview;
    private LinearLayout install_user_linearlayout;
    private LinearLayout install_video_linearlayout;
    private LinearLayout install_test_linearlayout;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        install_back_imageview = (ImageView) findViewById(R.id.install_back_imageview);
        install_user_linearlayout =(LinearLayout)findViewById(R.id.install_user_linearlayout);
        install_video_linearlayout =(LinearLayout)findViewById(R.id.install_video_linearlayout);
        install_test_linearlayout =(LinearLayout)findViewById(R.id.install_test_linearlayout);
        install_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        install_user_linearlayout.setOnClickListener(this);
        install_video_linearlayout.setOnClickListener(this);
        install_test_linearlayout.setOnClickListener(this);

    }

    @Override
    protected int initlayout() {
        return R.layout.install_activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.install_user_linearlayout:
                startActivity(new Intent(Myapp.activity,User_Activity.class));
                break;
            case R.id.install_test_linearlayout:
                DialogUtil.instance().Showdialog(Myapp.activity);
                DialogUtil.instance().Hidedialog();
                Toast.makeText(Myapp.activity, "已经是最新版本了！", Toast.LENGTH_SHORT).show();

                break;
            case R.id.install_video_linearlayout:
                startActivity(new Intent(Myapp.activity,Video_Activity.class));
                break;
        }


    }
}
