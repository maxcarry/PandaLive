package com.example.dell.pandalive.utils;

import com.example.dell.pandalive.apimanage.RetrofitApi;
import com.example.dell.pandalive.entity.BannerBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2017/8/23.
 */

public class RetrofitUtil {

    private static RetrofitUtil retrofitUtil;
    private static final int MAXTIME = 50;
    private final RetrofitApi api;

    private RetrofitUtil(String baseurl) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME, TimeUnit.SECONDS)
                .writeTimeout(MAXTIME, TimeUnit.SECONDS)
                .build();

        api = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitApi.class);
    }

    public static RetrofitUtil instance(String baseurl){

        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil(baseurl);
                }
            }
        }

        return retrofitUtil;
    }

    public void Webbanner(Observer observer) {

        Observable<BannerBean> getbanner = api.getbanner();
        getbanner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
