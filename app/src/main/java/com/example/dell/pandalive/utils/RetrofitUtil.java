package com.example.dell.pandalive.utils;

import com.example.dell.pandalive.apimanage.RetrofitApi;
import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.entity.LiveSplendidBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

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

    public static RetrofitUtil instance(String baseurl) {

        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil(baseurl);
                }
            }
        }

        return retrofitUtil;
    }

    public void Webhome(Observer observer) {

        Observable<HomeBean> getbanner = api.gethome();
        getbanner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webtv(Observer observer) {

        Observable<TvBean> gettv = api.gettv();

        gettv.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webvideo(Observer observer) {

        Observable<VideoBean> getvideo = api.getvideo();
        getvideo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    /**
     * 熊猫播报
     *
     * @param observer
     */
    //
    public void Webbigimage(Observer observer) {

        Observable<BigImageBean> getbigimage = api.getbigimage();
        getbigimage.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webeyelist(Observer observer) {

        Observable<EyeListBean> getrecycler = api.geteyelist();
        getrecycler.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 原创互动
     * @param observer
     */
    public void Webinteract(Observer observer) {

        Observable<InteractListViewBean> getinteract = api.getinteract();
        getinteract.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void videoBanner(Observer observer) {
        Observable<VideoRVBean> videobanner = api.getbanner();
        videobanner.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    public void videorecycler(Observer observer) {
        Observable<VideoRVBean> videoshowrecy = api.getvideoshowrecycler();
        videoshowrecy.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /*
    * 熊猫直播
    * 卢晓昭
    * */


    //精彩一刻
    public void Livesplendid(Observer observer) {

        Observable<LiveSplendidBean> liveSplendidBeanObservable = api.getsplendid();
        liveSplendidBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //熊猫滚滚秀
    public void Liveperform(Observer observer) {
//        getperform
        Observable<LivePerformBean> livePerformBeanObservable = api.getperform();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


    //熊猫档案
    public void livearchives(Observer observer) {
        Observable<LivePerformBean> livePerformBeanObservable = api.getarchives();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    //熊猫TOP榜
    public void livetop(Observer observer) {
        Observable<LivePerformBean> livePerformBeanObservable = api.gettops();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //当熊不让
    public void liveyield(Observer observer) {
        Observable<LivePerformBean> livePerformBeanObservable = api.getyield();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //熊猫那些事
    public void livething(Observer observer){
        Observable<LivePerformBean> livePerformBeanObservable = api.getthing();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    //熊猫特别节目
    public void liveunusual(Observer observer){
        Observable<LivePerformBean> livePerformBeanObservable = api.getunusual();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    //原创新闻
    public void liveoriginal(Observer observer){
        Observable<LivePerformBean> livePerformBeanObservable = api.getoriginal();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public void WebChina(Observer observer) {

        Observable<ChinaBean> getchinalive = api.getchinalive();
        getchinalive.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webcolumn(Observer observer, String url) {

        Observable<ColumnBean> getcolumn = api.getcolumn(url);
        getcolumn.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
