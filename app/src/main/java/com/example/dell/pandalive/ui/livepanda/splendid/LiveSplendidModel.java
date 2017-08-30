package com.example.dell.pandalive.ui.livepanda.splendid;

import android.util.Log;
import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.entity.LiveSplendidBean;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 * LiveYieldModel
 * LivePerformdModel
 */

public class LiveSplendidModel implements ILiveSplendidPresenter {
    @Override
    public void GainLiveSplendid(final ILiveSplendidview iLiveSplendidPresenter) {
//
//        http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1
        RetrofitUtil.instance("http://api.cntv.cn/")
                .Livesplendid(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                LiveSplendidBean liveSplendidBean = (LiveSplendidBean) value;
                List<LiveSplendidBean.VideoBean> video = liveSplendidBean.getVideo();
                iLiveSplendidPresenter.SendSplendid(video);
            }


            @Override
            public void onError(Throwable e) {
               Log.e("TAG", "onComplete: "+e.toString() );

                Toast.makeText(Myapp.activity, "请求失败"+e.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(Myapp.activity, "请求成功", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void urlpresenter(String purl) {

    }
}
