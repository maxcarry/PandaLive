package com.example.dell.pandalive.ui.personal.login.presenter;

import com.example.dell.pandalive.ui.personal.login.ILoginView;
import com.example.dell.pandalive.ui.personal.login.model.LoginModel;

/**
 * Created by dell on 2017/9/3.
 */

public class LoginPresenter implements ILoginPresenter {

    private final LoginModel loginModel;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {

        this.iLoginView = iLoginView;
        loginModel = new LoginModel();
    }

    @Override
    public void GetUser(String userName,String password) {

        loginModel.GainUser(userName,password,this);
    }

    @Override
    public void SendUser(String msg) {

        if (msg.equals("成功")) {
            iLoginView.LoginSuccess();
        } else {
            iLoginView.LoginError(msg);
        }
    }
}
