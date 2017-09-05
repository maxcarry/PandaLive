package com.example.dell.pandalive.ui.personal.register.phoneregister.presenter;

import com.example.dell.pandalive.ui.personal.register.phoneregister.IPhoneView;
import com.example.dell.pandalive.ui.personal.register.phoneregister.model.PhoneModel;

/**
 * Created by dell on 2017/9/4.
 */

public class PhonePresenter implements IPhonePresenter {

    private IPhoneView iPhoneView;
    private final PhoneModel phoneModel;

    public PhonePresenter(IPhoneView iPhoneView) {

        this.iPhoneView = iPhoneView;
        phoneModel = new PhoneModel();
    }

    @Override
    public void GetCode(String phoneString,String phoneyanzhengma) {

        phoneModel.GainCode(this,phoneString,phoneyanzhengma);
    }

    @Override
    public void SendCode(String msg) {

        iPhoneView.SendCode(msg);
    }
}
