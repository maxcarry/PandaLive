package com.example.dell.pandalive.ui.livepanda.direct.many;

import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/3.
 *
 * ILivePerformPresenter
 * ILookTalkPresenter
 */

public class LookTalkModel implements ILookTalkPresenter{

    @Override
    public void GainLivePerform(final ILookTalkView iLookTalkView) {
        //多视角直播  http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
        RetrofitUtil.instance("http://www.ipanda.com/").Lookmainform(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                LookTalkBean lookTalkBean= (LookTalkBean) value;
//                List<LivePerformBean.VideoBean> video = livePerformBean.getVideo();
                iLookTalkView.SendPerform(lookTalkBean);
//                        livedirectBean(lookTalkBean);
//                        SendPerform(lookTalkBean);
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
/*  @Override
    public void GainLivePerform(final ILookTalkFragment iLookTalkFragment) {

        //多视角直播  http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
        RetrofitUtil.instance("http://www.ipanda.com/").Lookmainform(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                LookTalkBean lookTalkBean= (LookTalkBean) value;
//                List<LivePerformBean.VideoBean> video = livePerformBean.getVideo();
                iLookTalkFragment.livedirectBean(lookTalkBean);
//                        SendPerform(lookTalkBean);
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



       livearchives(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                LivePerformBean livePerformBean= (LivePerformBean) value;
                List<LivePerformBean.VideoBean> video = livePerformBean.getVideo();
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
            */