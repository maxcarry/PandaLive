package com.example.dell.pandalive.ui.videopanda;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.VideoDetailsTabAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.HD_completeFragment;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.WondfulaspectFragment;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoDetailsActivity extends BaseActivity implements View.OnClickListener {

    TextView title;
    ImageView detailsdownimage, imagebackout, detailsupimage;
    TextView textViewshow;
    TabLayout detailstablayout;
    ViewPager detailsviewpager;
    ImageView imageshare;
    RadioButton imagecollection;

    LinearLayout linearLayout;

    ArrayList<Fragment> mlist = new ArrayList<>();
    private VideoDetailsTabAdapter tabAdapter;
    private HD_completeFragment completeFragment;
    private WondfulaspectFragment wondfulaspectFragment;
    private PopupWindow pw;
    private WebView videodetailswebview;
    private Button detailssharebtncancel;

    private JCVideoPlayerStandard  jcVideoPlayerStandard;
    private String mytitle;
    private String vid;
    private String type;

    @Override
    protected void initdata() {
        Intent intent = getIntent();

        mytitle = intent.getStringExtra("title");
        vid = intent.getStringExtra("path");
        type = intent.getStringExtra("type");
        title.setText(mytitle);

        jcVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, mytitle);

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_video_details;

    }

    @Override
    protected void initview() {
        linearLayout = new LinearLayout(this);
        imagebackout = (ImageView) findViewById(R.id.image_backout);
        imagebackout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jcVideoPlayerStandard= (JCVideoPlayerStandard) findViewById(R.id.video_details_jiecao);
        title = (TextView) findViewById(R.id.videodetails_tv_title);
        detailsupimage = (ImageView) findViewById(R.id.video_details_upimage);
        detailsdownimage = (ImageView) findViewById(R.id.video_details_downimage);
        detailsupimage.setOnClickListener(this);
        detailsdownimage.setOnClickListener(this);
        textViewshow = (TextView) findViewById(R.id.details_content_show);
        detailstablayout = (TabLayout) findViewById(R.id.video_details_tablayout);
        detailsviewpager = (ViewPager) findViewById(R.id.video_details_viewpager);

        imagecollection = (RadioButton) findViewById(R.id.details_image_collection);
        imageshare = (ImageView) findViewById(R.id.details_image_share);
        imagecollection.setOnClickListener(this);


        completeFragment = new HD_completeFragment();
        wondfulaspectFragment = new WondfulaspectFragment();
        mlist.add(completeFragment);
        mlist.add(wondfulaspectFragment);

        detailsviewpager.setOffscreenPageLimit(2);
        tabAdapter = new VideoDetailsTabAdapter(getSupportFragmentManager(), mlist);
        detailsviewpager.setAdapter(tabAdapter);

        detailstablayout.setupWithViewPager(detailsviewpager);
        detailstablayout.setTabMode(TabLayout.MODE_FIXED);


        detailstablayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorBlue));
        detailstablayout.setTabTextColors(ContextCompat.getColor(this, R.color.color_black), ContextCompat.getColor(this, R.color.colorBlue));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_details_downimage:
                detailsdownimage.setVisibility(View.GONE);
                detailsupimage.setVisibility(View.VISIBLE);
                textViewshow.setVisibility(View.VISIBLE);
                break;
            case R.id.video_details_upimage:
                textViewshow.setVisibility(View.GONE);
                detailsupimage.setVisibility(View.GONE);
                detailsdownimage.setVisibility(View.VISIBLE);

                break;
            case R.id.details_image_collection:
                Toast.makeText(this, "已收藏,请到[我的收藏]中查看", Toast.LENGTH_SHORT).show();
//                http://api.cntv.cn/video/videolistById?p=1&serviceId=panda&n=150&vsid=VSET100284428835
                break;

        }
        imageshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(Myapp.activity).inflate(R.layout.video_details_share_layout, null);

                pw = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                pw.setOutsideTouchable(true);
                pw.setBackgroundDrawable(new ColorDrawable());
                pw.showAtLocation(linearLayout, Gravity.BOTTOM, 100, 0);
                detailssharebtncancel = (Button) view.findViewById(R.id.details_share_btn_cancel);
                detailssharebtncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pw.dismiss();
                    }
                });
            }
        });
    }
}