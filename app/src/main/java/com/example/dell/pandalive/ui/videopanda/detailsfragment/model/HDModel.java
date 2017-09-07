package com.example.dell.pandalive.ui.videopanda.detailsfragment.model;

import android.widget.Toast;

import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.entity.VideoDetailsHDBean;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.persenter.IHDpersenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 贾成昆 on 2017/8/30.
 */

public class HDModel implements IHDModel {

    @Override
    public void videodetailsrecycl(final IHDpersenter ihDpersenter,String url) {
        RetrofitUtil.instance("").videodetailsrecycler(url,new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                VideoDetailsHDBean detailsHDBean= (VideoDetailsHDBean) value;
//                List<VideoDetailsHDBean.VideoBean> hdbean=detailsHDBean.getVideo();

                ihDpersenter.videodetailsperrecycler(detailsHDBean.getVideo());

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(Myapp.activity,"失败",Toast.LENGTH_SHORT);
            }

            @Override
            public void onComplete() {
                Toast.makeText(Myapp.activity,"成功",Toast.LENGTH_SHORT);

            }
        });
    }


}
