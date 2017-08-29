package com.example.dell.pandalive.ui.livepanda.original;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LiveOriginalPresenter implements ILivePerformview {

    private ILivePerformFragment iLivePerformFragment;
    private LiveOriginalModel liveOriginalModel;

    public LiveOriginalPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveOriginalModel = new LiveOriginalModel();
    }


    @Override
    public void ShowPerform() {
        liveOriginalModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean.VideoBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
