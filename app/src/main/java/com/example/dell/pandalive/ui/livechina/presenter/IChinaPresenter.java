package com.example.dell.pandalive.ui.livechina.presenter;

import com.example.dell.pandalive.entity.ChinaBean;

import java.util.List;

/**
 * Created by dell on 2017/8/28.
 */

public interface IChinaPresenter {

    void ShowTab();
    void SendTab(List<ChinaBean.TablistBean> tablist,List<ChinaBean.AlllistBean> alllist);
}
