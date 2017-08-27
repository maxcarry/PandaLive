package com.example.dell.pandalive.ui.eyepanda.model;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.ui.eyepanda.presenter.IEyePresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

public class EyeModel implements IEyeModel {
    //http://www.ipanda.com/kehuduan/news/index.json
    @Override
    public void GainBigImg(final IEyePresenter iEyePresenter) {
        RetrofitUtil.instance("http://www.ipanda.com/").Webbanner(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                BigImageBean imageBean= (BigImageBean) value;
                List<BigImageBean.DataBean.BigImgBean> bigImg = imageBean.getData().getBigImg();
                iEyePresenter.SendBigImg(bigImg);
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
