package com.example.dell.pandalive.ui.livepanda.thing;

import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformPresenter;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 *
 */

public class LiveThingModel implements ILivePerformPresenter{
    @Override
    public void GainLivePerform(final ILivePerformview iLivePerformview) {
        RetrofitUtil.instance("http://api.cntv.cn/").livething(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
//                LivePerformBean livePerformBean= (LivePerformBean) value;
//                List<LivePerformBean.VideoBean> video = livePerformBean.getVideo();
//                iLivePerformview.SendPerform(video);

                LivePerformBean livePerformBean= (LivePerformBean) value;
                List<LivePerformBean> video = new ArrayList<LivePerformBean>();

                video.add(livePerformBean);
                iLivePerformview.SendPerform(video);
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
}
