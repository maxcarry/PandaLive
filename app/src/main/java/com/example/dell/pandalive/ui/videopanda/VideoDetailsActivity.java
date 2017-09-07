package com.example.dell.pandalive.ui.videopanda;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.VideoDetailsXRecyclerAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.entity.VideoDetailsHDBean;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.IHDcomView;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.persenter.HDPersenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoDetailsActivity extends BaseActivity implements View.OnClickListener, WbShareCallback,IHDcomView {
    String url="http://api.cntv.cn/video/videolistById?p=1&serviceId=panda&n=150&vsid=VSET100284428835&page=";

    TextView title;
    ImageView detailsdownimage, imagebackout, detailsupimage;
    TextView textViewshow;
    ImageView imageshare;
    CheckBox imagecollection;
    LinearLayout linearLayout;
    private PopupWindow pw;

    private int page=1;
    String string=url+page;

    private Button detailssharebtncancel;

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private String mytitle;
    private String vid;
    private String type;

    ListView listView;
    private VideoDetailsXRecyclerAdapter xRecyclerAdapter;
    private HDPersenter hdPersenter;
    private SmartRefreshLayout smartRefreshLayout;

    private WbShareHandler shareHandler;
    private ImageView detailsweibo;
    private SsoHandler mSsoHandler;
    private WeiboMultiMessage weiboMessage;

    @Override
    protected void initdata() {




        Intent intent = getIntent();

        mytitle = intent.getStringExtra("title");
        vid = intent.getStringExtra("path");
        type = intent.getStringExtra("type");
        title.setText(mytitle);

        jcVideoPlayerStandard.setUp("http://cntv.vod.cdn.myqcloud.com/flash/mp4video61/TMS/2017/09/04/3138164066cf49ad88b8a236545996fb_h264418000nero_aac32.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, mytitle);

        refreshLayout();

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                smartRefreshLayout.finishRefresh(2000);
                refreshLayout();
            }
        });

        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshLayout();
                refreshlayout.finishLoadmore();
            }
        });


    }

    private void refreshLayout() {
        hdPersenter.videodetailsshowrecycler(url+page);

        page++;
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

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.video_details_jiecao);
        title = (TextView) findViewById(R.id.videodetails_tv_title);
        detailsupimage = (ImageView) findViewById(R.id.video_details_upimage);
        detailsdownimage = (ImageView) findViewById(R.id.video_details_downimage);
        detailsupimage.setOnClickListener(this);
        detailsdownimage.setOnClickListener(this);
        textViewshow = (TextView) findViewById(R.id.details_content_show);


        hdPersenter=new HDPersenter(this);
        smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.hdrefrelayout);
        listView = (ListView) findViewById(R.id.video_hdcomplete_recyclerview);

        //下拉刷新
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(Myapp.activity));
        //上拉加载
        smartRefreshLayout.setRefreshFooter(new BallPulseFooter(Myapp.activity));

        imagecollection = (CheckBox) findViewById(R.id.details_checkbox_collection);
        imageshare = (ImageView) findViewById(R.id.details_image_share);
        imagecollection.setOnClickListener(this);


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
            case R.id.details_checkbox_collection:
                if (imagecollection != null) {
                    Toast.makeText(this, "已收藏,请到[我的收藏]中查看", Toast.LENGTH_SHORT).show();
                } else if (imagecollection == null) {
                    Toast.makeText(this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }
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
                detailsweibo = (ImageView) view.findViewById(R.id.details_share_weibo);

                detailsweibo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        WbSdk.install(Myapp.activity, new AuthInfo(Myapp.activity, Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE));
                        shareHandler = new WbShareHandler(VideoDetailsActivity.this);
                        shareHandler.registerApp();
                        weiboMessage = new WeiboMultiMessage();
                        weiboMessage.imageObject = getImageObj();
                        shareHandler.shareMessage(weiboMessage, false);
                    }
                });
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        shareHandler.doResultIntent(intent, this);
    }

    /**
     * 创建图片消息对象。
     *
     * @return 图片消息对象。
     */
    private ImageObject getImageObj() {
        ImageObject imageObject = new ImageObject();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable._tw);
        imageObject.setImageObject(bitmap);
        return imageObject;
    }


    @Override
    public void onWbShareSuccess() {
        Toast.makeText(this, "分享成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onWbShareCancel() {
        Toast.makeText(this,
                getString(R.string.weibosdk_demo_toast_share_failed) + "Error Message: ",
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onWbShareFail() {
        Toast.makeText(this, "取消分享", Toast.LENGTH_LONG).show();
    }

    @Override
    public void detailsshowrecycler(List<VideoDetailsHDBean.VideoBean> arrayList) {

        xRecyclerAdapter = new VideoDetailsXRecyclerAdapter(Myapp.activity,arrayList);
        listView.setAdapter(xRecyclerAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });
    }
}