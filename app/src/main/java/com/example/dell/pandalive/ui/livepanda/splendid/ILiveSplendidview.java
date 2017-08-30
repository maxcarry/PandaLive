package com.example.dell.pandalive.ui.livepanda.splendid;

import com.example.dell.pandalive.entity.LiveSplendidBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 * ILiveyieldview
 *
 */

public interface ILiveSplendidview {

    void ShowSplendid();
    void SendSplendid(List<LiveSplendidBean.VideoBean> videoBeen);

}
