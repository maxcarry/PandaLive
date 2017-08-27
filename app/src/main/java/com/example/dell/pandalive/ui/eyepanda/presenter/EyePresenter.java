package com.example.dell.pandalive.ui.eyepanda.presenter;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.ui.eyepanda.IEyeView;
import com.example.dell.pandalive.ui.eyepanda.model.EyeModel;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

public class EyePresenter implements IEyePresenter {
    private EyeModel eyeModel;
    private IEyeView iEyeView;

    public EyePresenter(IEyeView iEyeView) {
        this.iEyeView=iEyeView;
        eyeModel=new EyeModel();
    }

    @Override
    public void ShowBigImg() {
        eyeModel.GainBigImg(this);
    }

    @Override
    public void SendBigImg(List<BigImageBean.DataBean.BigImgBean> bigImgBeanList) {
            iEyeView.ShowBigImg(bigImgBeanList);
    }
}
