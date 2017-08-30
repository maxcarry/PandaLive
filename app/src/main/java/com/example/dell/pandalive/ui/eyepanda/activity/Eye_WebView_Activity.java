package com.example.dell.pandalive.ui.eyepanda.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/8/27.
 */
////
public class Eye_WebView_Activity extends BaseActivity{

    private WebView eyeweb_webview;
    private ImageView eyeweb_back_imageview;
    private ImageView eyeweb_share_imageview;
    private ImageView eyeweb_collect_imageview;

    @Override
    protected void initdata() {
        Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        eyeweb_webview.loadUrl(url);

    }

    @Override
    protected void initview() {
        eyeweb_webview = (WebView) findViewById(R.id.eyeweb_webview);
        //自适应屏幕
//        eyeweb_webview.getSettings().setUseWideViewPort(true);
//        eyeweb_webview.getSettings().setLoadWithOverviewMode(true);
        WebSettings webSettings = eyeweb_webview.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setJavaScriptEnabled(true);

        eyeweb_share_imageview = (ImageView) findViewById(R.id.eyeweb_share_imageview);
        eyeweb_back_imageview = (ImageView) findViewById(R.id.eyeweb_back_imageview);
        eyeweb_collect_imageview = (ImageView) findViewById(R.id.eyeweb_collect_imageview);

        //收藏
        eyeweb_collect_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eyeweb_collect_imageview != null){
                    eyeweb_collect_imageview.setImageResource(R.drawable.collect_yes);
                    Toast.makeText(Eye_WebView_Activity.this, "已添加，请到[我的收藏]中查看", Toast.LENGTH_SHORT).show();
                }else if (eyeweb_collect_imageview ==  null){
                    eyeweb_collect_imageview.setImageResource(R.drawable.collect_no);
                    Toast.makeText(Eye_WebView_Activity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //分享
        eyeweb_share_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //返回键
        eyeweb_back_imageview.setOnClickListener(new View.OnClickListener() {
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


}
