package com.example.dell.pandalive.ui.livepanda.original;

import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformPresenter;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LiveOriginalModel implements ILivePerformPresenter {
    @Override
    public void GainLivePerform(final ILivePerformview iLivePerformview) {

        RetrofitUtil.instance("http://api.cntv.cn/").liveoriginal(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                getrequest((LivePerformBean) value, iLivePerformview);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Myapp.activity, "请求失败"+e.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onComplete() {
                Toast.makeText(Myapp.activity, "请求成功", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getrequest(LivePerformBean value, ILivePerformview iLivePerformview) {
        LivePerformBean livePerformBean= value;
        List<LivePerformBean.VideoBean> video = livePerformBean.getVideo();
        iLivePerformview.SendPerform(video);
    }
}