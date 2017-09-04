package com.example.dell.pandalive.ui.livepanda.splendid;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 */

public class LiveSplendidPresenter implements ILivePerformview {

    private LiveSplendidModel liveSplendidModel;
    private ILivePerformFragment iLivePerformFragment;

    public LiveSplendidPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveSplendidModel=new LiveSplendidModel();
    }


    @Override
    public void ShowPerform() {
        liveSplendidModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
