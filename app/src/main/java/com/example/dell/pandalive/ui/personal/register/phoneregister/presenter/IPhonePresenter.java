package com.example.dell.pandalive.ui.personal.register.phoneregister.presenter;

/**
 * Created by dell on 2017/9/4.
 */

public interface IPhonePresenter {

    void GetCode(String phoneString,String phoneyanzhengma);

    void SendCode(String msg);
}
