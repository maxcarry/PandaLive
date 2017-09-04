package com.example.dell.pandalive.ui.livepanda.unusual;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LiveUnusualPresenter implements ILivePerformview {

    private ILivePerformFragment iLivePerformFragment;
    private LiveUnusualModel liveUnusualModel;

    public LiveUnusualPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveUnusualModel=new LiveUnusualModel();
    }

    @Override
    public void ShowPerform() {
        liveUnusualModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
