package com.example.dell.pandalive.ui.livepanda.thing;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 */

public class LiveThingPresenter implements ILivePerformview {

    private ILivePerformFragment iLivePerformFragment;
    private LiveThingModel liveThingModel;

    public LiveThingPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveThingModel=new LiveThingModel();
    }


    @Override
    public void ShowPerform() {
        liveThingModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
