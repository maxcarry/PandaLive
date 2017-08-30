package com.example.dell.pandalive.ui.livechina.presenter;

import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.ui.livechina.IChinaView;
import com.example.dell.pandalive.ui.livechina.model.ChinaModel;

import java.util.List;

/**
 * Created by dell on 2017/8/28.
 */

public class ChinaPresenter implements IChinaPresenter {

    private IChinaView iChinaView;
    private final ChinaModel chinaModel;

    public ChinaPresenter(IChinaView iChinaView) {
        this.iChinaView = iChinaView;
        chinaModel = new ChinaModel();
    }

    @Override
    public void ShowTab() {

        chinaModel.GainChina(this);
    }

    @Override
    public void SendTab(List<ChinaBean.TablistBean> tablist, List<ChinaBean.AlllistBean> alllist) {

        iChinaView.ShowTab(tablist, alllist);
    }
}
