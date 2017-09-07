package com.example.dell.pandalive.ui.personal.register.emilsregister.presenter;

/**
 * Created by dell on 2017/9/4.
 */

public interface IEmilPresenter {

    void SendEmil(String emailString, String passwordString, String mCaptchaEditTextString, String JSESSIONID);

    void SendSuucer(String msg);
}
