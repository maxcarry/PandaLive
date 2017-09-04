package com.example.dell.pandalive.ui.eyepanda.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/8/25.
 */
//////
public class Interact_WebView_Activity extends BaseActivity {

    private WebView interact_webview;
    private TextView interact_title_textview;
    private ImageView interact_back_imageview;

    @Override
    protected void initdata() {

        Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        interact_title_textview.setText(title);
        interact_webview.loadUrl(url);

        WebSettings webSettings = interact_webview.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setJavaScriptEnabled(true);


    }

    @Override
    protected void initview() {
        interact_back_imageview = (ImageView) findViewById(R.id.interact_back_imageview);
        interact_title_textview = (TextView)findViewById(R.id.interact_title_textview);
        interact_webview = (WebView) findViewById(R.id.interact_webview);
        //自适应屏幕
        interact_webview.getSettings().setUseWideViewPort(true);
        interact_webview.getSettings().setLoadWithOverviewMode(true);

        interact_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_interact_web;
    }
}
