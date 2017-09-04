package com.example.dell.pandalive.ui.eyepanda.presenter;

import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.entity.InteractListViewBean;
import com.example.dell.pandalive.ui.eyepanda.IEyeView;
import com.example.dell.pandalive.ui.eyepanda.model.EyeModel;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */
////
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
    public void SendBigImg(BigImageBean bigImgBean) {

        ShowEyeBanner(bigImgBean);
    }

    @Override
    public void ShowEyeList(String url) {
        eyeModel.GainEyeList(this,url);
    }

    @Override
    public void SendEyeList(List<EyeListBean.ListBean> eyelist) {

//        Log.e(TAG, "SendEyeList: "+eyelist.get(0).getTitle() );
        iEyeView.ShowEyeList(eyelist);
    }

    @Override
    public void ShowInteract() {
        eyeModel.GainInteract(this);
    }

    @Override
    public void SendInteract(List<InteractListViewBean.InteractiveBean> interactBeen) {
        iEyeView.ShowInteract(interactBeen);
    }

    private void ShowEyeBanner(BigImageBean bigImgBean) {
      List<BigImageBean.DataBean.BigImgBean> bigimg=bigImgBean.getData().getBigImg();
        iEyeView.ShowEyeBanner(bigimg);
    }


}
