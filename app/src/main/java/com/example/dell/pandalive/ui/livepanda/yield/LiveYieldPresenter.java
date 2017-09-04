package com.example.dell.pandalive.ui.livepanda.yield;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
//接口：ILiveYieldPresenter
public class LiveYieldPresenter implements ILivePerformview{



    private ILivePerformFragment iLivePerformFragment;
    private LiveYieldModel liveYieldModel;

    public LiveYieldPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveYieldModel=new LiveYieldModel();
    }
    @Override
    public void ShowPerform() {
        liveYieldModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
/*
    @Override
    public void ShowSplendid() {
        liveSplendidModel.GainLiveSplendid(this);

    }
    @Override
    public void SendSplendid(List<LiveSplendidBean.VideoBean> videoBeen) {
//        LiveSplendidAdapter liveSplendidAdapter=new LiveSplendidAdapter(Myapp.activity,videoBeen);

        iLiveSplendidModel.liveBean(videoBeen);

    }*/