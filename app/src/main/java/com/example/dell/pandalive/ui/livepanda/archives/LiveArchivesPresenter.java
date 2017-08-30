package com.example.dell.pandalive.ui.livepanda.archives;

import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformview;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 */

public class LiveArchivesPresenter implements ILivePerformview{

    private ILivePerformFragment iLivePerformFragment;
    private LiveArchivesModel liveArchivesModel;

    public LiveArchivesPresenter(ILivePerformFragment iLivePerformFragment) {
        this.iLivePerformFragment = iLivePerformFragment;
        liveArchivesModel=new LiveArchivesModel();
    }
    @Override
    public void ShowPerform() {
        liveArchivesModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LivePerformBean.VideoBean> performBeen) {
        iLivePerformFragment.liveperformBean(performBeen);
    }
}
