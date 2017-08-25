package com.example.dell.pandalive.ui.home.model;

import com.example.dell.pandalive.entity.BannerBean;
import com.example.dell.pandalive.ui.home.presenter.IHomePresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/8/25.
 */

public class HomeModel implements IHomeModel {

    @Override
    public void GainBanner(final IHomePresenter iHomePresenter) {

        RetrofitUtil.instance("http://www.ipanda.com/").Webbanner(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                BannerBean bean = (BannerBean) value;
                List<BannerBean.DataBean.BigImgBean> bigImg = bean.getData().getBigImg();
                ArrayList<String> imalist = new ArrayList<String>();
                ArrayList<String> titlelist = new ArrayList<String>();

                for (BannerBean.DataBean.BigImgBean bigImgBean : bigImg) {
                    imalist.add(bigImgBean.getImage());
                    titlelist.add(bigImgBean.getTitle());
                }

                iHomePresenter.SendBanner(imalist,titlelist);

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
