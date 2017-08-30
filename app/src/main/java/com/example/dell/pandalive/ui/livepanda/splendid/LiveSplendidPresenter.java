package com.example.dell.pandalive.ui.livepanda.splendid;

import com.example.dell.pandalive.entity.LiveSplendidBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 */

public class LiveSplendidPresenter implements ILiveSplendidview {

    private LiveSplendidModel liveSplendidModel;
    private ILiveSplendidFragment iLiveSplendidModel;

    public LiveSplendidPresenter(ILiveSplendidFragment iLiveSplendidModel) {
        this.iLiveSplendidModel = iLiveSplendidModel;
        liveSplendidModel=new LiveSplendidModel();
    }

    @Override
    public void ShowSplendid() {
        liveSplendidModel.GainLiveSplendid(this);
    }

    @Override
    public void SendSplendid(List<LiveSplendidBean.VideoBean> videoBeen) {
        iLiveSplendidModel.liveBean(videoBeen);
    }
}
