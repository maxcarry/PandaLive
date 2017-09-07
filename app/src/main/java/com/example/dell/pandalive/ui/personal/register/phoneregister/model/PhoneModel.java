package com.example.dell.pandalive.ui.personal.register.phoneregister.model;

import android.util.Log;

import com.example.dell.pandalive.ui.personal.register.phoneregister.presenter.IPhonePresenter;
import com.example.dell.pandalive.utils.LoginorRegister;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/9/4.
 */

public class PhoneModel implements IPhoneModel {

    private static final int MAXTIME = 50;

    @Override
    public void GainCode(final IPhonePresenter iPhonePresenter, String phoneString, String phoneyanzhengma, final String JSESSIONID) {

        Map<String, String> map = new HashMap<>();

        map.put("method", "getRequestVerifiCodeM");
        map.put("mobile", phoneString);
        map.put("verfiCodeType", "1");
        map.put("verificationCode", phoneyanzhengma);

        LoginorRegister.instance(JSESSIONID).WebPhoneCode(map, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                ResponseBody responseBody = (ResponseBody) value;
                try {

                    String msg = responseBody.string();
                    Log.e(TAG, "------------onNext: "+msg );
                    iPhonePresenter.SendCode(msg);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void GainRegister(Map<String, String> map, final IPhonePresenter iPhonePresenter) {

        RetrofitUtil.instance("").Webregister(map, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                ResponseBody responseBody = (ResponseBody) value;
                try {
                    String string = responseBody.string();
                    Log.e(TAG, "onNext: ==================="+string );
                    iPhonePresenter.Sendfruit(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
