package com.example.dell.pandalive.ui.personal.register.phoneregister.model;

import com.example.dell.pandalive.ui.personal.register.phoneregister.presenter.IPhonePresenter;

import java.util.Map;

/**
 * Created by dell on 2017/9/4.
 */

public interface IPhoneModel {

    void GainCode(IPhonePresenter iPhonePresenter, String phoneString, String phoneyanzhengma, String JSESSIONID);

    void GainRegister(Map<String, String> map, IPhonePresenter iPhonePresenter);
}
