package com.example.dell.pandalive.ui.eyepanda.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/8/27.
 */

public class Eye_WebView_Activity extends BaseActivity implements View.OnClickListener {

    private WebView eyepanda_webview;
    private ImageView eyepanda_back_imageview;
    private ImageView eyepanda_share_imageview;

    @Override
    protected void initdata() {
        Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        eyepanda_webview.loadUrl(url);

    }

    @Override
    protected void initview() {
        eyepanda_webview = (WebView) findViewById(R.id.eyepanda_webview);
        //自适应屏幕
        eyepanda_webview.getSettings().setUseWideViewPort(true);
        eyepanda_webview.getSettings().setLoadWithOverviewMode(true);

        eyepanda_share_imageview = (ImageView) findViewById(R.id.eyepanda_share_imageview);
        eyepanda_back_imageview = (ImageView) findViewById(R.id.eyepanda_back_imageview);
        eyepanda_share_imageview.setOnClickListener(this);
        eyepanda_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_eye_webview;
    }

    @Override
    public void onClick(View v) {

    }
}
