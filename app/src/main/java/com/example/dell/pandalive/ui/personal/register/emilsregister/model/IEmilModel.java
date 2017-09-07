package com.example.dell.pandalive.ui.personal.register.emilsregister.model;

import com.example.dell.pandalive.ui.personal.register.emilsregister.presenter.IEmilPresenter;

/**
 * Created by dell on 2017/9/4.
 */

public interface IEmilModel {

    void GainEmil(IEmilPresenter iEmilPresenter,String emailString,String passwordString,String mCaptchaEditTextString, String JSESSIONID);
}
