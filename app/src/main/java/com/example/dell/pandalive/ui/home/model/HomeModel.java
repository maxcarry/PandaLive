package com.example.dell.pandalive.ui.home.model;


import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;
import com.example.dell.pandalive.ui.home.presenter.IHomePresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/8/25.
 */

public class HomeModel implements IHomeModel {

    @Override
    public void GainHome(final IHomePresenter iHomePresenter) {
        RetrofitUtil.instance("http://www.ipanda.com/").Webhome(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                HomeBean bean = (HomeBean) value;

                iHomePresenter.SendView(bean);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void GainTv(final IHomePresenter iHomePresenter) {

        RetrofitUtil.instance("http://www.ipanda.com/").Webtv(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                TvBean bean = (TvBean) value;

                iHomePresenter.SendTv(bean.getList());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void GainVideo(final IHomePresenter iHomePresenter) {

        RetrofitUtil.instance("http://www.ipanda.com/").Webvideo(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                VideoBean bean = (VideoBean) value;
                iHomePresenter.SendVideo(bean.getList());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
