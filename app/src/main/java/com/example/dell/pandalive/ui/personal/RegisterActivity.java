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

/**
 * Created by dell on 2017/8/28.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private PhoneRegFragment fphone;
    private EmilsRegistFragment femils;
    private ImageView register_back;
    private TextView phone_thread;
    private TextView phone_title;
    private RelativeLayout phone_bt;
    private TextView emils_thread;
    private TextView emils_title;
    private RelativeLayout emils_bt;
    private FrameLayout register_show;

    @Override
    protected void initdata() {

        phone_title.setTextColor(Color.BLUE);
        phone_thread.setVisibility(View.VISIBLE);
        fphone = new PhoneRegFragment();
        femils = new EmilsRegistFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.register_show, fphone);
        ft.commitAllowingStateLoss();

    }

    @Override
    protected void initview() {

        register_back = (ImageView) findViewById(R.id.register_back);
        register_back.setOnClickListener(this);
        phone_thread = (TextView) findViewById(R.id.phone_thread);
        phone_thread.setOnClickListener(this);
        phone_title = (TextView) findViewById(R.id.phone_title);
        phone_title.setOnClickListener(this);
        phone_bt = (RelativeLayout) findViewById(R.id.phone_bt);
        phone_bt.setOnClickListener(this);
        emils_thread = (TextView) findViewById(R.id.emils_thread);
        emils_thread.setOnClickListener(this);
        emils_title = (TextView) findViewById(R.id.emils_title);
        emils_title.setOnClickListener(this);
        emils_bt = (RelativeLayout) findViewById(R.id.emils_bt);
        emils_bt.setOnClickListener(this);
        register_show = (FrameLayout) findViewById(R.id.register_show);
        register_show.setOnClickListener(this);
    }

    @Override
    protected int initlayout() {
        return R.layout.register_activity;
    }

    @Override
    public void onClick(View v) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (v.getId()) {

            case R.id.phone_bt:

                if (phone_thread.getVisibility() == View.INVISIBLE) {

                    phone_title.setTextColor(Color.BLUE);
                    phone_thread.setVisibility(View.VISIBLE);

                    emils_thread.setVisibility(View.INVISIBLE);
                    emils_title.setTextColor(Color.BLACK);

                    if (fphone.isAdded()) {

                        ft.hide(femils);
                        ft.show(fphone);
                        ft.commitAllowingStateLoss();
                    } else {
                        ft.hide(femils);
                        ft.add(R.id.register_show, fphone);
                        ft.commitAllowingStateLoss();
                    }
                }

                break;

            case R.id.emils_bt:

                if (emils_thread.getVisibility() == View.INVISIBLE) {

                    phone_title.setTextColor(Color.BLACK);
                    phone_thread.setVisibility(View.INVISIBLE);

                    emils_thread.setVisibility(View.VISIBLE);
                    emils_title.setTextColor(Color.BLUE);

                    if (femils.isAdded()) {

                        ft.hide(fphone);
                        ft.show(femils);
                        ft.commitAllowingStateLoss();
                    } else {
                        ft.hide(fphone);
                        ft.add(R.id.register_show, femils);
                        ft.commitAllowingStateLoss();
                    }
                }
                break;

            case R.id.register_back:

                finish();
                break;
        }
    }
}
