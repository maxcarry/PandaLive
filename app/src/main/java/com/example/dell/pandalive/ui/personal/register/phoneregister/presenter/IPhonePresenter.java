package com.example.dell.pandalive.ui.personal.register.phoneregister.presenter;

import java.util.Map;

/**
 * Created by dell on 2017/9/4.
 */

public interface IPhonePresenter {

    void GetCode(String phoneString,String phoneyanzhengma,String JSESSIONID);

    void SendCode(String msg);

    void Register(Map<String,String> map);

    void Sendfruit(String msg);
}
