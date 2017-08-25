package com.example.dell.pandalive.ui.home.presenter;

import com.example.dell.pandalive.ui.home.IHomeView;
import com.example.dell.pandalive.ui.home.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/25.
 */

public class HomePresenter implements IHomePresenter {

    private HomeModel homeModel;
    private IHomeView iHomeView;

    public HomePresenter(IHomeView iHomeView) {

        this.iHomeView = iHomeView;
        homeModel = new HomeModel();
    }

    @Override
    public void ShowBanner() {

        homeModel.GainBanner(this);
    }

    @Override
    public void SendBanner(ArrayList<String> imalist, ArrayList<String> titlelist) {

        iHomeView.ShowBanner(imalist,titlelist);
    }
}
