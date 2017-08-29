package com.example.dell.pandalive.ui.livepanda.yield;

import android.util.Log;
import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.ui.livepanda.splendid.ILiveSplendidview;
import com.example.dell.pandalive.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LiveYieldModel implements ILiveYieldPresenter{
    @Override
    public void GainLiveYield(ILiveSplendidview iLiveSplendidPresenter) {


        RetrofitUtil.instance("http://api.cntv.cn/").Livesplendid(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {


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
}
