package com.example.dell.pandalive.ui.home.presenter;

import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;

import java.util.List;

/**
 * Created by dell on 2017/8/25.
 */

public interface IHomePresenter {

    void ShowView();
    void SendView(HomeBean homeBean);

    void ShowTv();
    void SendTv(List<TvBean.ListBean> tvlist);

    void ShowVideo();
    void SendVideo(List<VideoBean.ListBean> videolist);
}
