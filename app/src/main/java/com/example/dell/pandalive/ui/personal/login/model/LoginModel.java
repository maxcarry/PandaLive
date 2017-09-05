package com.example.dell.pandalive.ui.personal.login.model;

import android.util.Log;

import com.example.dell.pandalive.entity.LoginUserBean;
import com.example.dell.pandalive.entity.UserinfoBean;
import com.example.dell.pandalive.ui.personal.login.presenter.ILoginPresenter;
import com.example.dell.pandalive.utils.RetrofitUtil;
import com.example.dell.pandalive.utils.SharedUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/9/3.
 */

public class LoginModel implements ILoginModel {

    public final static String LOGIN_URL = "https://reg.cntv.cn/login/login.action";
    public static final String USER_AGENT = "CNTV_APP_CLIENT_CYNTV_MOBILE";
    private static final int CODE_SUCCEED = 0;

    @Override
    public void GainUser(String userName, String password, final ILoginPresenter iLoginPresenter) {

        Log.e(TAG, "onNext: 开始请求" );
        Map<String, String> map = new HashMap<>();
        map.put("Referer", LOGIN_URL);
        map.put("User-Agent", USER_AGENT);
        map.put("from", LOGIN_URL);
        map.put("service", "client_transaction");
        map.put("username", userName);
        map.put("password", password);

        RetrofitUtil.instance("").Webloginuser(map, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                LoginUserBean bean = (LoginUserBean) value;

                if ("0".equals(bean.getErrType())) {

                    String user_seq_id = bean.getUser_seq_id();

                    getuserinfo(user_seq_id,iLoginPresenter);
                } else {
                    iLoginPresenter.SendUser(bean.getErrMsg());
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

    private void getuserinfo(String user_seq_id, final ILoginPresenter iLoginPresenter) {

        Map<String, String> map = new HashMap<>();
        map.put("client", "ipanda_mobile");
        map.put("method", "user.getNickNameAndFace");
        map.put("userid", user_seq_id);
        RetrofitUtil.instance("").Webuserinfo(map, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                UserinfoBean bean = (UserinfoBean) value;

                if (bean.getCode() == CODE_SUCCEED) {

                    String nickname = bean.getContent().getNickname();
                    String userface = bean.getContent().getUserface();

                    SharedUtil instance = SharedUtil.instance();
                    instance.saveNickName(nickname);
                    instance.saveUserFace(userface);

                    iLoginPresenter.SendUser("成功");
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
