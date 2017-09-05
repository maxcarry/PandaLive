package com.example.dell.pandalive.ui.personal.register.phoneregister.model;

import android.util.Log;

import com.example.dell.pandalive.ui.personal.register.phoneregister.presenter.IPhonePresenter;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/9/4.
 */

public class PhoneModel implements IPhoneModel {

    private String JSESSIONID = null;

    @Override
    public void GainCode(final IPhonePresenter iPhonePresenter, String phoneString, String phoneyanzhengma) {

//
//        Map<String, String> map = new HashMap<>();
//        map.put("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
//        map.put("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
//        map.put("Cookie", "JSESSIONID=");
//
//        map.put("method", "getRequestVerifiCodeM");
//        map.put("mobile", phoneString);
//        map.put("verfiCodeType", "1");
//        map.put("verificationCode", phoneyanzhengma);

        String url = "http://reg.cntv.cn/regist/getVerifiCode.action?Referer=http://cbox_mobile.regclientuser.cntv.cn&User-Agent=CNTV_APP_CLIENT_CBOX_MOBILE&Cookie=JSESSIONID=&method=getRequestVerifiCodeM&";

        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url(url+"mobile="+phoneString+"&verfiCodeType=1&verificationCode="+phoneyanzhengma).build();

        Log.e(TAG, "短信验证网址: "+ url+"mobile="+phoneString+"&verfiCodeType=1&verificationCode="+phoneyanzhengma);
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.e(TAG, "短信验证码失败: "+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.e(TAG, "短信验证码: "+response.body().string() );
            }
        });

    }
}
