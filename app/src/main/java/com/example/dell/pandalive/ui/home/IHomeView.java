package com.example.dell.pandalive.ui.home;

import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;

import java.util.List;

/**
 * Created by dell on 2017/8/25.
 */

public interface IHomeView {

    void ShowBanner(List<HomeBean.DataBean.BigImgBean> bigImg);
    void ShowEye(HomeBean.DataBean.PandaeyeBean eyebean);
    void ShowLive(List<HomeBean.DataBean.PandaliveBean.ListBean> livelist);
    void ShowTv(List<TvBean.ListBean> tvlist);
    void ShowVideo(List<VideoBean.ListBean> videolist);
    void ShowChina(List<HomeBean.DataBean.ChinaliveBean.ListBeanX> chinalist);
}
