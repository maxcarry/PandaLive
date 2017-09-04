package com.example.dell.pandalive.ui.livepanda.Livemain;

import com.example.dell.pandalive.ui.livepanda.direct.many.LookTalkBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public interface ILivemultiview {

    void ShowPerform();
    void SendPerform(List<LiveMainBean> performBeen);

    void SentLook();
    void SendLook(List<LookTalkBean> lookTalkBean);
}
