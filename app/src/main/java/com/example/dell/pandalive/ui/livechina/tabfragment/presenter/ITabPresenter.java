package com.example.dell.pandalive.ui.livechina.tabfragment.presenter;

import com.example.dell.pandalive.entity.ColumnBean;

import java.util.List;

/**
 * Created by dell on 2017/8/28.
 */

public interface ITabPresenter {

    void ShowTab(String url);
    void SendTab(List<ColumnBean.LiveBean> live);
}
