package com.example.dell.pandalive.apimanage;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.entity.LiveSplendidBean;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by dell on 2017/8/22.
 */

public interface RetrofitApi {

    //    http://www.ipanda.com/kehuduan/shouye/index.json
    @GET("kehuduan/shouye/index.json")
    Observable<HomeBean> gethome();

    //    http://www.ipanda.com/kehuduan/video/index.json
    @GET("kehuduan/video/index.json")
    Observable<VideoRVBean> getvideoshowrecycler();

    //    kehuduan/shipinliebieye/jingcaiyike/index.json
    @GET("kehuduan/shipinliebieye/jingcaiyike/index.json")
    Observable<TvBean> gettv();

    //http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json
    @GET("kehuduan/shipinliebieye/video/index.json")
    Observable<VideoRVBean> getbanner();

    //    http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json
    @GET("kehuduan/shipinliebieye/video/index.json")
    Observable<VideoBean> getvideo();

    /**
     * 熊猫播报
     *
     * @return
     */
    //
//http://www.ipanda.com/kehuduan/news/index.json
    @GET("kehuduan/news/index.json")
    Observable<BigImageBean> getbigimage();

    //http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
    @GET("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda")
    Observable<EyeListBean> geteyelist();

    //http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json
    @GET("kehuduan/PAGE14501767715521482/index.json")
    Observable<InteractListViewBean> getinteract();

    /*
    * 熊猫直播
    * */


    //   精彩一刻 "http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LiveSplendidBean> getsplendid();

    //熊猫滚滚秀http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getperform();

    //熊猫档案"http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1";
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getarchives();


}


