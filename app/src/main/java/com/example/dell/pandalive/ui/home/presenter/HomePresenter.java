package com.example.dell.pandalive.ui.home.presenter;

import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;
import com.example.dell.pandalive.ui.home.IHomeView;
import com.example.dell.pandalive.ui.home.model.HomeModel;

import java.util.List;

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
    public void ShowView() {

        homeModel.GainHome(this);
    }

    @Override
    public void SendView(HomeBean homeBean) {

        Showbanner(homeBean);

        Showeye(homeBean);

        Showlive(homeBean);

        Showchina(homeBean);
    }

    private void Showchina(HomeBean homeBean) {

        iHomeView.ShowChina(homeBean.getData().getChinalive().getList());
    }

    @Override
    public void ShowTv() {

        homeModel.GainTv(this);
    }

    @Override
    public void SendTv(List<TvBean.ListBean> tvlist) {

        iHomeView.ShowTv(tvlist);
    }

    @Override
    public void ShowVideo() {

        homeModel.GainVideo(this);
    }

    @Override
    public void SendVideo(List<VideoBean.ListBean> videolist) {

        iHomeView.ShowVideo(videolist);
    }

    private void Showlive(HomeBean homeBean) {

        List<HomeBean.DataBean.PandaliveBean.ListBean> livelist = homeBean.getData().getPandalive().getList();

        iHomeView.ShowLive(livelist);
    }

    private void Showeye(HomeBean homeBean) {

        HomeBean.DataBean.PandaeyeBean pandaeye = homeBean.getData().getPandaeye();
        iHomeView.ShowEye(pandaeye);
    }

    private void Showbanner(HomeBean homeBean) {

        List<HomeBean.DataBean.BigImgBean> bigImg = homeBean.getData().getBigImg();

        iHomeView.ShowBanner(bigImg);
    }
}
