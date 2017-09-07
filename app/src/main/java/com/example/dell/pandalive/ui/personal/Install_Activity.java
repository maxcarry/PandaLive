package com.example.dell.pandalive.ui.personal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.umeng.message.PushAgent;

/**
 * Created by 张凯雅 on 2017/9/3.
 */

public class Install_Activity extends BaseActivity implements View.OnClickListener {

    private ImageView install_back_imageview;
    private LinearLayout install_user_linearlayout;
    private LinearLayout install_video_linearlayout;
    private LinearLayout install_test_linearlayout;
    private LinearLayout install_ping_linearlayout;
    private SharedPreferences pSp;
    private String pushSign;
    private String playSign;
    private ImageView install_push_imageview;
    private ImageView install_play_imageview;
    private LinearLayout install_set_delete_cache_linearlayout;
    private static final int LIST_DATA1 = 1;
    private static final int UPGRADE_APK_CODE = 1;
    private static final int CLEAN_CACHE_CODE = 2;
    private Dialog loadDialog;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        install_back_imageview = (ImageView) findViewById(R.id.install_back_imageview);
        install_user_linearlayout = (LinearLayout) findViewById(R.id.install_user_linearlayout);
        install_video_linearlayout = (LinearLayout) findViewById(R.id.install_video_linearlayout);
        install_test_linearlayout = (LinearLayout) findViewById(R.id.install_test_linearlayout);
        install_ping_linearlayout = (LinearLayout) findViewById(R.id.install_ping_linearlayout);
        install_push_imageview = (ImageView) findViewById(R.id.install_push_imageview);
        install_play_imageview = (ImageView) findViewById(R.id.install_play_imageview);
        install_set_delete_cache_linearlayout = (LinearLayout) findViewById(R.id.install_set_delete_cache_linearlayout);
        install_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        install_user_linearlayout.setOnClickListener(this);
        install_video_linearlayout.setOnClickListener(this);
        install_test_linearlayout.setOnClickListener(this);
        install_ping_linearlayout.setOnClickListener(this);
        install_push_imageview.setOnClickListener(this);
        install_play_imageview.setOnClickListener(this);
        install_set_delete_cache_linearlayout.setOnClickListener(this);

        pSp = getSharedPreferences("set", Activity.MODE_PRIVATE);
        pushSign = pSp.getString("push", "open");
        playSign = pSp.getString("play", "open");

        if ("close".equals(pushSign)) {
            install_push_imageview.setImageResource(R.drawable.switch_close);
            PushAgent.getInstance(Myapp.activity).disable();
        } else {
            install_push_imageview.setImageResource(R.drawable.switch_open);
            PushAgent.getInstance(Myapp.activity).enable();
        }

        if ("close".equals(playSign)) {
            install_play_imageview.setImageResource(R.drawable.switch_close);
        } else {
            install_play_imageview.setImageResource(R.drawable.switch_open);
        }


    }

    @Override
    protected int initlayout() {
        return R.layout.install_activity;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.install_set_delete_cache_linearlayout:

                View viewDialog = (View) LayoutInflater.from(this).inflate(
                        R.layout.update_dialog, null);
                final Dialog dialog = new Dialog(this, R.style.loginDialogTheme);

                TextView login_left_cancel, login_right_sure;
                login_left_cancel = (TextView) viewDialog.findViewById(R.id.login_left_cancel);
                login_right_sure = (TextView) viewDialog.findViewById(R.id.login_right_sure);
                login_left_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                login_right_sure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(CLEAN_CACHE_CODE);
                        dialog.dismiss();
                    }
                });
                dialog.setContentView(viewDialog);
                dialog.show();

                break;
            case R.id.install_user_linearlayout:
                startActivity(new Intent(Myapp.activity, User_Activity.class));
                break;
            case R.id.install_test_linearlayout:

                Toast.makeText(Myapp.activity, "已经是最新版本了！", Toast.LENGTH_SHORT).show();

                break;
            case R.id.install_video_linearlayout:
                startActivity(new Intent(Myapp.activity, Video_Activity.class));
                break;
            case R.id.install_ping_linearlayout:
                Uri uri = Uri.parse("market://details?id=cn.cntv.app.ipanda");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (Exception e) {
                    Toast.makeText(Myapp.activity, "没有找到可用的应用市场",
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.install_push_imageview:
                pSp = getSharedPreferences("set", Activity.MODE_PRIVATE);
                pushSign = pSp.getString("push", "open");

                if ("close".equals(pushSign)) {
//					pushImg.setImageResource(R.drawable.switch_open);
//					pushSign = "open";
//					PushAgent.getInstance(PersonalSetActivity.this).enable();

//					showDialog(-1);
                    install_push_imageview.setImageResource(R.drawable.switch_open);
                    pushSign = "open";
                    PushAgent.getInstance(Myapp.activity).enable();
                    Editor pued = pSp.edit();
                    pued.putString("push", pushSign);
                    pued.commit();

                } else {
                    install_push_imageview.setImageResource(R.drawable.switch_close);
                    pushSign = "close";
                    PushAgent.getInstance(Myapp.activity).disable();
                    SharedPreferences.Editor pued = pSp.edit();
                    pued.putString("push", pushSign);
                    pued.commit();
                }
                break;
            case R.id.install_play_imageview:
                if ("close".equals(playSign)) {
                    install_play_imageview.setImageResource(R.drawable.switch_open);
                    playSign = "open";
                } else {
                    install_play_imageview.setImageResource(R.drawable.switch_close);
                    playSign = "close";
                }

                Editor played = pSp.edit();
                played.putString("play", playSign);
                played.commit();

                break;


        }


    }


}
