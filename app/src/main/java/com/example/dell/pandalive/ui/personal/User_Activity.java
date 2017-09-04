package com.example.dell.pandalive.ui.personal;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.ui.personal.user.Common_Fragment;
import com.example.dell.pandalive.ui.personal.user.Meet_Fragment;

/**
 * Created by 张凯雅 on 2017/9/3.
 */

class User_Activity extends BaseActivity implements View.OnClickListener {

    private ImageView user_back_imageview;
    private RelativeLayout meet_bt;
    private TextView meet_thread;
    private TextView meet_title;
    private RelativeLayout common_bt;
    private TextView common_thread;
    private TextView common_title;
    private FrameLayout problem_show;
    private Meet_Fragment meet;
    private Common_Fragment common;


    @Override
    protected void initdata() {
        meet_title.setTextColor(Color.BLUE);
        //VISIBLE  显示
        meet_thread.setVisibility(View.VISIBLE);

        meet = new Meet_Fragment();
        common = new Common_Fragment();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.problem_show,meet);
        transaction.commitAllowingStateLoss();

    }

    @Override
    protected void initview() {
        user_back_imageview =(ImageView)findViewById(R.id.user_back_imageview);
        user_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        meet_bt =(RelativeLayout)findViewById(R.id.meet_bt);
        meet_bt.setOnClickListener(this);
        meet_thread=(TextView)findViewById(R.id.meet_thread);
        meet_thread.setOnClickListener(this);
        meet_title =(TextView)findViewById(R.id.meet_title);
        meet_title.setOnClickListener(this);
        common_bt =(RelativeLayout)findViewById(R.id.common_bt);
        common_bt.setOnClickListener(this);
        common_thread =(TextView)findViewById(R.id.common_thread);
        common_thread.setOnClickListener(this);
        common_title =(TextView)findViewById(R.id.common_title);
        common_title.setOnClickListener(this);
        problem_show =(FrameLayout)findViewById(R.id.problem_show);
        problem_show.setOnClickListener(this);


    }

    @Override
    protected int initlayout() {
        return R.layout.user_activity;
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.meet_bt:
                if (meet_thread.getVisibility() == View.INVISIBLE) {

                    meet_title.setTextColor(Color.BLUE);
                    meet_thread.setVisibility(View.VISIBLE);

                    common_thread.setVisibility(View.INVISIBLE);
                    common_title.setTextColor(Color.BLACK);

                    if (meet.isAdded()) {

                        transaction.hide(common);
                        transaction.show(meet);
                        transaction.commitAllowingStateLoss();
                    } else {
                        transaction.hide(common);
                        transaction.add(R.id.register_show, meet);
                        transaction.commitAllowingStateLoss();
                    }
                }
                break;
            case R.id.common_bt:
                if (common_thread.getVisibility() == View.INVISIBLE) {

                    meet_title.setTextColor(Color.BLACK);
                    meet_thread.setVisibility(View.INVISIBLE);

                    common_thread.setVisibility(View.VISIBLE);
                    common_title.setTextColor(Color.BLUE);

                    if (common.isAdded()) {

                        transaction.hide(meet);
                        transaction.show(common);
                        transaction.commitAllowingStateLoss();
                    } else {
                        transaction.hide(meet);
                        transaction.add(R.id.register_show, common);
                        transaction.commitAllowingStateLoss();
                    }
                }
                break;
        }

    }
}
