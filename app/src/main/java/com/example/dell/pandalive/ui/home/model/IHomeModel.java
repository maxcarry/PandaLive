package com.example.dell.pandalive.ui.home.model;

import com.example.dell.pandalive.ui.home.presenter.IHomePresenter;

/**
 * Created by dell on 2017/8/25.
 */

public interface IHomeModel {

    void GainHome(IHomePresenter iHomePresenter);

    void GainTv(IHomePresenter iHomePresenter);

    void GainVideo(IHomePresenter iHomePresenter);
}
