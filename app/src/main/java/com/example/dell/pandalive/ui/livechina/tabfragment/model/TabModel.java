package com.example.dell.pandalive.ui.livechina.tabfragment.model;

import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.ui.livechina.tabfragment.presenter.ITabPresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/8/28.
 */

public class TabModel implements ITabModel {

    @Override
    public void GainColumn(final ITabPresenter iTabPresenter, String url) {

        RetrofitUtil.instance("").Webcolumn(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                ColumnBean bean = (ColumnBean) value;
                List<ColumnBean.LiveBean> live = bean.getLive();
                iTabPresenter.SendTab(live);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },url);
    }
}
