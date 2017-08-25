package com.example.dell.pandalive.apimanage;

import com.example.dell.pandalive.entity.HomeBean;
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
}
