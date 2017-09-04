package com.example.dell.pandalive.ui.livepanda.direct.many;

import com.example.dell.pandalive.ui.livepanda.direct.directinterface.ILookTalkFragment;

/**
 * Created by Administrator on 2017/9/3.
 * ILookTalkView
 */

public class LookTalkPresenter implements ILookTalkView{

    private ILookTalkFragment iLookTalkFragment;
    private LookTalkModel lookTalkModel;

    public LookTalkPresenter(ILookTalkPresenter iLookTalkPresenter) {
        this.iLookTalkFragment = iLookTalkFragment;
        lookTalkModel=new LookTalkModel();
    }




    @Override
    public void ShowPerform() {
        lookTalkModel.GainLivePerform(this);
    }

    @Override
    public void SendPerform(LookTalkBean lookTalkBean) {
        iLookTalkFragment.livedirectBean(lookTalkBean);
//                liveperformBean(performBeen);
    }
}
