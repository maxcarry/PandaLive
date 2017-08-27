package com.example.dell.pandalive.ui.eyepanda.presenter;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

public interface IEyePresenter {

    void ShowBigImg();
    void SendBigImg(BigImageBean bigImgBean);

    void ShowEyeList();
    void SendEyeList(List<EyeListBean.ListBean> eyelist);

//    void ShowInteract();
//    void SendInteract(List<InteractListViewBean.InteractiveBean> interactBeen);
}
