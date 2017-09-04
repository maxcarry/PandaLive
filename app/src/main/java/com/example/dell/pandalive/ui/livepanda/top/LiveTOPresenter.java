package com.example.dell.pandalive.ui.livepanda.top;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 */

public class LiveTOPresenter implements ILivePerformview{

    private ILivePerformFragment iLivePerformFragment;
    private LiveTOPModel liveTOPModel;

    public LiveTOPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveTOPModel=new LiveTOPModel();
    }

    @Override
    public void ShowPerform() {
        liveTOPModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
