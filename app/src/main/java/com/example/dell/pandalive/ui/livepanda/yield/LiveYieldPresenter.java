package com.example.dell.pandalive.ui.livepanda.yield;

import com.example.dell.pandalive.entity.LiveSplendidBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
//接口：ILiveYieldPresenter
public class LiveYieldPresenter implements ILiveyieldview{



    private LiveYieldModel liveYieldModel;
    private ILiveYieldFragment iLiveYieldFragment;
    public LiveYieldPresenter(ILiveYieldFragment iLiveYieldFragment) {
        this.iLiveYieldFragment = iLiveYieldFragment;
        liveYieldModel=new LiveYieldModel();
    }
    @Override
    public void Showyield() {

    }

    @Override
    public void Sendyield(List<LiveSplendidBean.VideoBean> videoBeen) {

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