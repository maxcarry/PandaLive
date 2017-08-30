package com.example.dell.pandalive.ui.videopanda.model;

import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.ui.videopanda.presenter.IVideopersenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public class VideoModel implements IVideomodel {



    @Override
    public void videorecycler(final IVideopersenter iVideopersenter) {

        RetrofitUtil.instance("http://www.ipanda.com").videorecycler(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                VideoRVBean videoRVBean= (VideoRVBean) value;
               List<VideoRVBean.ListBean> rvBeen=videoRVBean.getList();
                iVideopersenter.videoperrecycler(rvBeen);

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Myapp.activity, "请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(Myapp.activity, "请求成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}