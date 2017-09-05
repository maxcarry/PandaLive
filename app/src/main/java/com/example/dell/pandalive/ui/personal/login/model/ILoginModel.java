package com.example.dell.pandalive.ui.personal.login.model;

import com.example.dell.pandalive.ui.personal.login.presenter.ILoginPresenter;

/**
 * Created by dell on 2017/9/3.
 */

public interface ILoginModel {

    void GainUser(String userName, String password, ILoginPresenter iLoginPresenter);
}
