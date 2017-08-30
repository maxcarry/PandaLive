package com.example.dell.pandalive.ui.livechina.tabfragment.presenter;

import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.ui.livechina.tabfragment.ITabView;
import com.example.dell.pandalive.ui.livechina.tabfragment.model.TabModel;

import java.util.List;

/**
 * Created by dell on 2017/8/28.
 */

public class TabPresenter implements ITabPresenter {

    private ITabView iTabView;
    private final TabModel tabModel;

    public TabPresenter(ITabView iTabView) {
        this.iTabView = iTabView;
        tabModel = new TabModel();
    }

    @Override
    public void ShowTab(String url) {

        tabModel.GainColumn(this,url);
    }

    @Override
    public void SendTab(List<ColumnBean.LiveBean> live) {

        iTabView.ShowTab(live);
    }

}
