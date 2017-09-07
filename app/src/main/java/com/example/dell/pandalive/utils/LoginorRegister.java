package com.example.dell.pandalive.utils;

import android.util.Log;

import com.example.dell.pandalive.apimanage.UserApi;
import com.example.dell.pandalive.entity.SendEmilBase;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2017/9/5.
 */

public class LoginorRegister {

    private static LoginorRegister loginorRegister;
    private static final int MAXTIME = 50;
    private final UserApi api;

    //构造函数
    private LoginorRegister(final String JSESSIONID) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME, TimeUnit.SECONDS)
                .writeTimeout(MAXTIME, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Referer", URLEncoder.encode("iPanda.Android", "UTF-8"))
                                .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"))
                                .addHeader("Cookie", "JSESSIONID=" + JSESSIONID)
                                .build();

                        Log.e("-------","请求头配置的参数---"+JSESSIONID);


                        return chain.proceed(request);
                    }

                })
                .build();

        api = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://reg.cntv.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserApi.class);
    }

    //单例方法
    public static LoginorRegister instance(String JSESSIONID){

        if (loginorRegister == null) {
            synchronized (LoginorRegister.class) {
                if (loginorRegister == null) {
                    loginorRegister = new LoginorRegister(JSESSIONID);
                }
            }
        }
        return loginorRegister;
    }


    //以下是网络请求方法
    public void WebPhoneCode(Map<String, String> map, Observer observer) {

        Observable<ResponseBody> sendphonecode = api.sendphonecode(map);

        sendphonecode.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void SendEmil(String url, Observer observer) {

        Observable<SendEmilBase> sendemils = api.sendemils(url);
        sendemils.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
