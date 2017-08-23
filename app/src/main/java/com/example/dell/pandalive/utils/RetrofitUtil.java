package com.example.dell.pandalive.utils;

import com.example.dell.pandalive.apimanage.RetrofitApi;

import java.util.concurrent.TimeUnit;

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

    private RetrofitUtil() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME, TimeUnit.SECONDS)
                .writeTimeout(MAXTIME, TimeUnit.SECONDS)
                .build();

        api = new Retrofit.Builder()
                .client(client)
                .baseUrl("baseurl")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitApi.class);
    }

    public static RetrofitUtil instance(){

        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }

        return retrofitUtil;
    }
}
