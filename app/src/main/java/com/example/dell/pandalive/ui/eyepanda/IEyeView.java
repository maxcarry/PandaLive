package com.example.dell.pandalive.ui.eyepanda;

import com.example.dell.pandalive.entity.EyeListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

public interface IEyeView {

    void ShowEyeBanner(ArrayList<String> imalist, ArrayList<String> titlelist, ArrayList<String> pathlist);

    void ShowEyeList(List<EyeListBean.ListBean> eyelist);

//    void ShowInteract(List<InteractListViewBean.InteractiveBean> interactBeen);
}
