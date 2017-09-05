package com.example.dell.pandalive.ui.personal.register.emilsregister.model;

import android.util.Log;

import com.example.dell.pandalive.entity.SendEmilBase;
import com.example.dell.pandalive.ui.personal.register.emilsregister.presenter.IEmilPresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/9/4.
 */

public class EmilModel implements IEmilModel {
    @Override
    public void GainEmil(IEmilPresenter iEmilPresenter,String emailString,String passwordString,String mCaptchaEditTextString) {

        try {
            String from = "iPanda.Android";
            String url = "https://reg.cntv.cn/api/register.action" + "?mailAdd="
                    + emailString + "&passWd=" + URLEncoder.encode(passwordString, "UTF-8")
                    + "&verificationCode=" + mCaptchaEditTextString + "&addons="
                    + URLEncoder.encode(from, "UTF-8");

            Log.e(TAG, "GainEmil: "+url );
            RetrofitUtil.instance("").SendEmil(url, new Observer() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Object value) {

                    SendEmilBase base = (SendEmilBase) value;
                    Log.e(TAG, "onNext: "+base.getEmail()+base.getMsg() );
                    Log.e(TAG, "onNext: "+base.getErrtype() );
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
