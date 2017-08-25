package com.example.dell.pandalive.apimanage;

import com.example.dell.pandalive.entity.BannerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by dell on 2017/8/22.
 */

public interface RetrofitApi {

//    http://www.ipanda.com/kehuduan/shouye/index.json
    @GET("kehuduan/shouye/index.json")
    Observable<BannerBean> getbanner();

}
