package com.example.dell.pandalive.ui.eyepanda.model;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.ui.eyepanda.presenter.IEyePresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 张凯雅 on 2017/8/25.
 */
////
public class EyeModel implements IEyeModel {
    //http://www.ipanda.com/kehuduan/news/index.json
    @Override
    public void GainBigImg(final IEyePresenter iEyePresenter) {
        RetrofitUtil.instance("http://www.ipanda.com/").Webbigimage(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                BigImageBean imageBean= (BigImageBean) value;

                iEyePresenter.SendBigImg(imageBean);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
//http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda

    @Override
    public void GainEyeList(final IEyePresenter iEyePresenter) {

        RetrofitUtil.instance("http://api.cntv.cn/").Webeyelist(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                EyeListBean eyeListBean= (EyeListBean) value;
                iEyePresenter.SendEyeList(eyeListBean.getList());
            }

            @Override
            public void onError(Throwable e) {

//                Log.e(TAG, "onError: 请求失败" +e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

//    @Override
//    public void GainInteract(final IEyePresenter iEyePresenter) {
//
//        RetrofitUtil.instance("http://www.ipanda.com/").Webinteract(new Observer() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Object value) {
//                InteractListViewBean interactListViewBean= (InteractListViewBean) value;
//                iEyePresenter.SendInteract(interactListViewBean.getInteractive());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//    }
}
