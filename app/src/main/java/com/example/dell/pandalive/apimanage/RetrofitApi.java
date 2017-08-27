package com.example.dell.pandalive.apimanage;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by dell on 2017/8/22.
 */

public interface RetrofitApi {

//    http://www.ipanda.com/kehuduan/shouye/index.json
    @GET("kehuduan/shouye/index.json")
    Observable<HomeBean> gethome();

//    kehuduan/shipinliebieye/jingcaiyike/index.json
    @GET("kehuduan/shipinliebieye/jingcaiyike/index.json")
    Observable<TvBean> gettv();

//    http://www.ipanda.com/kehuduan/shipinliebieye/video/index.json
    @GET("kehuduan/shipinliebieye/video/index.json")
    Observable<VideoBean> getvideo();

//http://www.ipanda.com/kehuduan/news/index.json
    @GET("kehuduan/news/index.json")
    Observable<BigImageBean> getbigimage();

//http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
    @GET("http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda")
    Observable<EyeListBean> geteyelist();

//http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json
    @GET("kehuduan/PAGE14501767715521482/index.json")
    Observable<InteractListViewBean> getinteract();
}
