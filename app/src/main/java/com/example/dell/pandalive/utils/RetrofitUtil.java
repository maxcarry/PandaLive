package com.example.dell.pandalive.utils;

import com.example.dell.pandalive.apimanage.RetrofitApi;
import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.entity.ChinaUriBean;
import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.entity.LoginUserBean;
import com.example.dell.pandalive.entity.SendEmilBase;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.UserinfoBean;
import com.example.dell.pandalive.entity.VideoBanner;
import com.example.dell.pandalive.entity.VideoBean;
import com.example.dell.pandalive.entity.VideoDetailsHDBean;
import com.example.dell.pandalive.entity.VideoPlayBean;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.ui.livepanda.Livemain.LiveMainBean;
import com.example.dell.pandalive.ui.livepanda.direct.many.LookTalkBean;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

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
    public String JSESSIONID = null;

    private RetrofitUtil(String baseurl) {

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
                        return chain.proceed(request);
                    }

                })
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

    public void Webeyelist(String url,Observer observer) {

        Observable<EyeListBean> getrecycler = api.geteyelist(url);
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
    //滚滚视频
    public void videobanner(Observer observer){
        Observable<VideoBanner> videoshowrecy=api.getvideobanner();
        videoshowrecy.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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


    //熊猫直播  getlook
    public void Livemainform(Observer observer) {
//        getperform
        Observable<LiveMainBean> livePerformBeanObservable = api.getmain();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    //多视角直播
    public void Lookmainform(Observer observer) {
//        getperform
        Observable<LookTalkBean> livePerformBeanObservable = api.getlook();
        livePerformBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    //精彩一刻
    public void Livesplendid(Observer observer) {

        Observable<LivePerformBean> liveSplendidBeanObservable = api.getsplendid();
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
//    http://36.102.235.55/vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/08/28/32a08c5f6c3f4f34becaf960d5a47538_h264418000nero_aac32.mp4?wshc_tag=0&wsts_tag=59a62116&wsid_tag=73ab217c&wsiphost=ipdbm
    //滚滚视频详情
    public void videodetailsrecycler(Observer observer){
        Observable<VideoDetailsHDBean> videoshowrecy=api.getvideodetailsrecycler();
        videoshowrecy.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webchinaplay(Observer observer,String url){

        Observable<ChinaUriBean> getchinaplay = api.getchinaplay(url);
        getchinaplay.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webvideoplay(String url, Observer observer) {

        Observable<VideoPlayBean> getvideoplay = api.getvideoplay(url);
        getvideoplay.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webloginuser(Map<String, String> map, Observer observer) {

        Observable<LoginUserBean> getloginuser = api.getloginuser(map);
        getloginuser.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void Webuserinfo(Map<String, String> map, Observer observer){

        Observable<UserinfoBean> getuserinfo = api.getuserinfo(map);
        getuserinfo.subscribeOn(Schedulers.io())
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
