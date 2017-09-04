package com.example.dell.pandalive.ui.eyepanda.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;

/**
 * Created by 张凯雅 on 2017/8/27.
 */
////
public class Eye_WebView_Activity extends BaseActivity{

    private WebView eyeweb_webview;
    private ImageView eyeweb_back_imageview;
    private ImageView eyeweb_share_imageview;
    private CheckBox eyeweb_collect_checkbox;
    private LinearLayout linearLayout;
    private PopupWindow popup;
    private ImageView web_popup_facebook;
    private ImageView web_popup_twitter;
    private ImageView web_popup_webo;
    private ImageView web_popup_wechat;
    private ImageView web_popup_friend;
    private Button web_popup_return;


    @Override
    protected void initdata() {
        Intent intent=getIntent();
        String url = intent.getStringExtra("url");
        eyeweb_webview.loadUrl(url);

    }

    @Override
    protected void initview() {
        linearLayout = new LinearLayout(Myapp.activity);

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
        eyeweb_collect_checkbox =(CheckBox)findViewById(R.id.eyeweb_collect_checkbox);

        //收藏
        eyeweb_collect_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eyeweb_collect_checkbox != null){
                    Toast.makeText(Eye_WebView_Activity.this, "已添加，请到[我的收藏]中查看", Toast.LENGTH_SHORT).show();
                }else if (eyeweb_collect_checkbox == null){
                    Toast.makeText(Eye_WebView_Activity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //分享
        eyeweb_share_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view= LayoutInflater.from(Myapp.activity).inflate(R.layout.eyewebview_popupwindow,null);
//                web_popup_facebook =(ImageView)view.findViewById(R.id.web_popup_facebook);
//                web_popup_twitter =(ImageView)view.findViewById(R.id.web_popup_twitter);
//                web_popup_webo =(ImageView)view.findViewById(R.id.web_popup_webo);
//                web_popup_wechat =(ImageView)view.findViewById(R.id.web_popup_wechat);
//                web_popup_friend =(ImageView)view.findViewById(R.id.web_popup_friend);
                web_popup_return=(Button)view.findViewById(R.id.web_popup_return);

                web_popup_return.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popup.dismiss();
                    }
                });
////                ColorDrawable dw = new ColorDrawable(0000000000);
////                popup.setBackgroundDrawable(dw);
//                // 动画效果 从底部弹起
////                popup.setAnimationStyle(R.style.take_popup_anim);

                popup = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
                popup.setOutsideTouchable(true);
                popup.setBackgroundDrawable(new ColorDrawable());
                popup.showAtLocation(linearLayout, Gravity.BOTTOM,0,0);//parent view随意

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
