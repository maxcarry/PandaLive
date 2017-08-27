package com.example.dell.pandalive.ui.eyepanda.presenter;

import com.example.dell.pandalive.entity.BigImageBean;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

public interface IEyePresenter {
    void ShowBigImg();
    void SendBigImg(List<BigImageBean.DataBean.BigImgBean> bigImgBeanList);
}
