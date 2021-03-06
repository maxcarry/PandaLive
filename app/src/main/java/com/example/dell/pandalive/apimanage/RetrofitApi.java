package com.example.dell.pandalive.apimanage;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.entity.ChinaUriBean;
import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.entity.LoginUserBean;
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

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by dell on 2017/8/22.
 */

public interface RetrofitApi {

    //    http://www.ipanda.com/kehuduan/shouye/index.json
    @GET("kehuduan/shouye/index.json")
    Observable<HomeBean> gethome();

    //滚滚视频
    @GET("kehuduan/video/index.json")
    Observable<VideoBanner> getvideobanner();

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
    @GET
    Observable<EyeListBean> geteyelist(@Url String url);

    //http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json
    /**
     * 原创互动
     * @return
     */
//http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json
    @GET("kehuduan/PAGE14501767715521482/index.json")
    Observable<InteractListViewBean> getinteract();

    /*
    * 熊猫直播
    * */

    //直播 http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json
    @GET("http://www.ipanda.com/kehuduan/PAGE14501769230331752/index.json")
    Observable<LiveMainBean> getmain();

    //多视角直播  http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
// // 多视角直播  http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json

    @GET("http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json")
    Observable<LookTalkBean> getlook();



    //   精彩一刻 "http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getsplendid();

    //熊猫滚滚秀http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100272959126&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getperform();

    //熊猫档案"http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1";
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100340574858&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getarchives();


    //熊猫TOP榜"http://api.cntv.cn/video/videolistById?vsid=VSET100284428835&n=7&serviceId=panda&o=desc&of=time&p=1";
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100284428835&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> gettops();


//当熊不让http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&n=7&serviceId=panda&o=desc&of=time&p=1
     @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100332640004&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getyield();



    //熊猫那些事"http://api.cntv.cn/video/videolistById?vsid=VSET100237714751&n=7&serviceId=panda&o=desc&of=time&p=1";

    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100237714751&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getthing();

    //特别节目"http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p=1";
    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100167308855&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getunusual();


    //(9)原创新闻 "http://api.cntv.cn/video/videolistById?vsid=VSET100219009515&n=7&serviceId=panda&o=desc&of=time&p=1";

    @GET("http://api.cntv.cn/video/videolistById?vsid=VSET100219009515&n=7&serviceId=panda&o=desc&of=time&p=1")
    Observable<LivePerformBean> getoriginal();
    // http://api.cntv.cn/video/videolistById?p=1&serviceId=panda&n=150&vsid=VSET100284428835

    //滚滚视频详情

    @GET
    Observable<VideoDetailsHDBean> getvideodetailsrecycler(@Url String url);
    //直播中国
//    http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json
    @GET("kehuduan/PAGE14501775094142282/index.json")
    Observable<ChinaBean> getchinalive();

    //栏目页面
    @GET
    Observable<ColumnBean> getcolumn(@Url String url);

    //直播中国视频
    @GET
    Observable<ChinaUriBean> getchinaplay(@Url String url);

    //点播视频
    @GET
    Observable<VideoPlayBean> getvideoplay(@Url String url);

    //登录—获取用户ID
    @GET("https://reg.cntv.cn/login/login.action")
    Observable<LoginUserBean> getloginuser(@QueryMap Map<String,String> map);

    //获取用户头像和用户名
    @GET("http://my.cntv.cn/intf/napi/api.php")
    Observable<UserinfoBean> getuserinfo(@QueryMap Map<String,String> map);

    //注册
    @GET("https://reg.cntv.cn/regist/mobileRegist.do")
    Observable<ResponseBody> register(@QueryMap Map<String,String> map);
}