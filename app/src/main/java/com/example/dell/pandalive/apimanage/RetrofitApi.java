package com.example.dell.pandalive.apimanage;

import com.example.dell.pandalive.entity.HomeBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by dell on 2017/8/22.
 */

public interface RetrofitApi {

    @GET("mobile/home")
    Observable<HomeBean> gethome(@QueryMap Map<String,String> map);

}
