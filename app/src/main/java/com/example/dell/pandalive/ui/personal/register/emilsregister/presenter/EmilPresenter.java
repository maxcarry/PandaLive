package com.example.dell.pandalive.ui.personal.register.emilsregister.presenter;

import com.example.dell.pandalive.ui.personal.register.emilsregister.IEmilView;
import com.example.dell.pandalive.ui.personal.register.emilsregister.model.EmilModel;

/**
 * Created by dell on 2017/9/4.
 */

public class EmilPresenter implements IEmilPresenter {

    private IEmilView iEmilView;
    private final EmilModel emilModel;

    public EmilPresenter(IEmilView iEmilView) {

        this.iEmilView = iEmilView;
        emilModel = new EmilModel();
    }

    @Override
    public void SendEmil(String emailString,String passwordString,String mCaptchaEditTextString, String JSESSIONID) {

        emilModel.GainEmil(this,emailString,passwordString,mCaptchaEditTextString,JSESSIONID);
    }

    @Override
    public void SendSuucer(String msg) {

        iEmilView.SendSuccess(msg);
    }
}
