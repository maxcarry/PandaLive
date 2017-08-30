package com.example.dell.pandalive.ui.livechina.model;

import android.util.Log;

import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.ui.livechina.presenter.IChinaPresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/8/28.
 */

public class ChinaModel implements IChinaModel {
    @Override
    public void GainChina(final IChinaPresenter iChinaPresenter) {

        RetrofitUtil.instance("http://www.ipanda.com/").WebChina(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                ChinaBean bean = (ChinaBean) value;
                List<ChinaBean.TablistBean> tablist = bean.getTablist();
                List<ChinaBean.AlllistBean> alllist = bean.getAlllist();
                Log.e(">>>>>>>>>>>>>>>>", "onNext: "+tablist.get(0).getTitle() );

                iChinaPresenter.SendTab(tablist,alllist);
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
