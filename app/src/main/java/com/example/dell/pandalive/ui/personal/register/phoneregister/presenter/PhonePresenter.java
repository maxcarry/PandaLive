package com.example.dell.pandalive.ui.personal.register.phoneregister.presenter;

import com.example.dell.pandalive.ui.personal.register.phoneregister.IPhoneView;
import com.example.dell.pandalive.ui.personal.register.phoneregister.model.PhoneModel;

import java.util.Map;

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
    public void GetCode(String phoneString,String phoneyanzhengma,String JSESSIONID) {

        phoneModel.GainCode(this,phoneString,phoneyanzhengma,JSESSIONID);
    }

    @Override
    public void SendCode(String msg) {

        iPhoneView.SendCode(msg);
    }

    @Override
    public void Register(Map<String, String> map) {

        phoneModel.GainRegister(map,this);
    }

    @Override
    public void Sendfruit(String msg) {

        iPhoneView.RegisterSuccer(msg);
    }
}
