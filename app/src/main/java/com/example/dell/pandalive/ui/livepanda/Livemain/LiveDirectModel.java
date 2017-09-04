package com.example.dell.pandalive.ui.livepanda.Livemain;

import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.ui.livepanda.direct.many.LookTalkBean;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/1.
 */

public class LiveDirectModel implements ILiveDirectpresenter {
    @Override
    public void GainLivePerform(final ILivemultiview iLivemultiview) {
        // 直播 http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json
        RetrofitUtil.instance("http://www.ipanda.com/").Livemainform(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                LiveMainBean liveMainBean = (LiveMainBean) value;
//               List<LiveMainBean> liveMainBeann= (List<LiveMainBean>) value;
                List<LiveMainBean> liveMainBean1 = new ArrayList<LiveMainBean>();
                liveMainBean1.add(liveMainBean);
                iLivemultiview.SendPerform(liveMainBean1);

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Myapp.activity, "请求失败" + e.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onComplete() {
//                Toast.makeText(Myapp.activity, "请求成功", Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public void GainLookPerform(final ILivemultiview iLivemultiview) {
        //http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
        RetrofitUtil.instance("http://www.ipanda.com/").Lookmainform(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                LookTalkBean lookTalkBeen = (LookTalkBean) value;
                List<LookTalkBean> looklist = new ArrayList<LookTalkBean>();
                looklist.add(lookTalkBeen);
                iLivemultiview.SendLook(looklist);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Myapp.activity, "请求失败" + e.toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onComplete() {
                Toast.makeText(Myapp.activity, "九宫格请求成功", Toast.LENGTH_LONG).show();

            }
        });
    }

}
