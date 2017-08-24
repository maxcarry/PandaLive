package com.example.dell.pandalive.ui.home.model;

import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.ui.home.presenter.IHomepresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/8/24.
 */

public class HomeMoudel implements IHomeMoudel {


    @Override
    public void Webhoem(final IHomepresenter iHomepresenter) {

        Map<String, String> map = new HashMap<>();
        map.put("random", "84831");
        map.put("encode", "9dd34239798");

        RetrofitUtil.instance().gethome(map, new Observer() {
            //这个是控制是否接受数据
            @Override
            public void onSubscribe(Disposable d) {

            }

            //每条数据,在这里进行数据操作
            @Override
            public void onNext(Object value) {

                HomeBean homeBean = (HomeBean) value;

                List<HomeBean.DataBean.Ad8Bean> ad8 = homeBean.getData().getAd8();

                iHomepresenter.setlist(ad8);

            }

            //请求错误
            @Override
            public void onError(Throwable e) {

            }

            //没有数据队列的时候
            @Override
            public void onComplete() {

            }
        });
    }
}
