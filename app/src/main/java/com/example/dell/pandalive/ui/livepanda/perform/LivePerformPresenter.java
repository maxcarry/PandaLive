package com.example.dell.pandalive.ui.livepanda.perform;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LivePerformPresenter implements ILivePerformview{

    private LivePerformdModel livePerformdModel;
private ILivePerformFragment iLivePerformFragment;
    public LivePerformPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        livePerformdModel=new LivePerformdModel();
    }


    @Override
    public void ShowPerform() {
//        liveSplendidModel.GainLiveSplendid(this);
        livePerformdModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean.VideoBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
