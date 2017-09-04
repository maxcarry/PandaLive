package com.example.dell.pandalive.ui.livepanda.Livemain;

import com.example.dell.pandalive.ui.livepanda.direct.many.LookTalkBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class LiveDirectPresenter implements ILivemultiview {



    private LiveDirectModel liveDirectModel;
    private ILiveDirectFragment iLiveDirectFragment;

    public LiveDirectPresenter(ILiveDirectFragment iLiveDirectFragment) {
        this.iLiveDirectFragment = iLiveDirectFragment;
        liveDirectModel = new LiveDirectModel();
    }

    @Override
    public void ShowPerform() {
        liveDirectModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(List<LiveMainBean> performBeen) {
        iLiveDirectFragment.livemainBean(performBeen);
    }

    @Override
    public void SentLook() {
        liveDirectModel.GainLookPerform(this);
    }

    @Override
    public void SendLook(List<LookTalkBean> lookTalkBean) {
        iLiveDirectFragment.lookBean(lookTalkBean);
    }
}
