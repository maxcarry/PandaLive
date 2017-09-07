package com.example.dell.pandalive.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.custom_view.CustomMediaController;
import com.example.dell.pandalive.entity.ChinaUriBean;
import com.example.dell.pandalive.entity.VideoPlayBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

/**
 * Vitamio视频播放框架
 */
public class PlayActivityUtil extends AppCompatActivity implements MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener{
    //视频地址
    private String path = "";
    private Uri uri;
    private String title;
    private ProgressBar pb;
    private TextView downloadRateView, loadRateView;
    private CustomMediaController mCustomMediaController;
    private VideoView mVideoView;
    private ImageView loding_bg;
    private Netwoke netwoke;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = getIntent().getStringExtra("title");
        path = getIntent().getStringExtra("path");
        type = getIntent().getStringExtra("type");

        if (type.equals("2")) {

            VideoPlay();
        } else {
            WebPlay();
        }

        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得当前窗体对象
        Window window = PlayActivityUtil.this.getWindow();
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
//        设置视频解码监听
//        if (!LibsChecker.checkVitamioLibs(this)) {
//            return;
//        }
        setContentView(R.layout.videoplayview);

    }

    private void VideoPlay() {

        Log.e("点播地址", "VideoPlay: "+ "http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do?pid=" + path);
        RetrofitUtil.instance("").Webvideoplay("http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do?pid=" + path, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(Object value) {

                VideoPlayBean bean = (VideoPlayBean) value;
                path = bean.getHls_url();

                getnetwoke();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private void WebPlay() {

        RetrofitUtil.instance("").Webchinaplay(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                ChinaUriBean bean = (ChinaUriBean) value;
                path = bean.getHls_url().getHls1();
                getnetwoke();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },path);
    }

    //初始化控件
    private void initView() {
        mVideoView = (VideoView) findViewById(R.id.buffer);
        mCustomMediaController=new CustomMediaController(this,mVideoView,this);
        mCustomMediaController.setVideoName(title);
        pb = (ProgressBar) findViewById(R.id.probar);
        downloadRateView = (TextView) findViewById(R.id.download_rate);
        loadRateView = (TextView) findViewById(R.id.load_rate);
        loding_bg = (ImageView) findViewById(R.id.loding_bg);
    }

    //初始化数据
    private void initData() {
        uri = Uri.parse(path);
        mVideoView.setVideoURI(uri);//设置视频播放地址
        Log.e("------------",uri.toString());
        mCustomMediaController.show(5000);
        mVideoView.setMediaController(mCustomMediaController);
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);//高画质
        mVideoView.requestFocus();
        mVideoView.setOnInfoListener(this);
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                    pb.setVisibility(View.VISIBLE);
                    downloadRateView.setText("");
                    loadRateView.setText("");
                    downloadRateView.setVisibility(View.VISIBLE);
                    loadRateView.setVisibility(View.VISIBLE);

                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                loding_bg.setVisibility(View.GONE);
                mVideoView.start();
                pb.setVisibility(View.GONE);
                downloadRateView.setVisibility(View.GONE);
                loadRateView.setVisibility(View.GONE);

                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                downloadRateView.setText("" + extra + "kb/s" + "  ");
                break;
        }
        return true;
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        loadRateView.setText(percent + "%");
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        //屏幕切换时，设置全屏
        if (mVideoView != null){
            mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        }
        super.onConfigurationChanged(newConfig);
    }

    //判断网络状态
    private void getnetwoke() {


        if (netwoke == null) {
            netwoke = new Netwoke();
        }

        String getnetwoke = netwoke.getnetwoke(this);

        Toast.makeText(this, getnetwoke, Toast.LENGTH_SHORT).show();

        if (!getnetwoke.equals("您现在的网络状态是WIFI")) {

            setNetwork();

        }
    }

    private void setNetwork() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(false);

        builder.setMessage("您正在使用移动数据网络,所产生的流量费由当地运营商收取,是否继续?");

        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                finish();
            }

        });

        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                initView();
                initData();
            }

        });

        builder.create();

        builder.show();
    }
}
