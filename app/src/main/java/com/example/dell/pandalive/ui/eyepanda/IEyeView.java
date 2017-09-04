package com.example.dell.pandalive.ui.eyepanda;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.InteractListViewBean;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */
//////
public interface IEyeView {

    void ShowEyeBanner(List<BigImageBean.DataBean.BigImgBean> bigImg);

    void ShowEyeList(List<EyeListBean.ListBean> eyelist);

    void ShowInteract(List<InteractListViewBean.InteractiveBean> interactBeen);
}
