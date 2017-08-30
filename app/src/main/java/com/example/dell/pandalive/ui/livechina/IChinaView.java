package com.example.dell.pandalive.ui.livechina;

import com.example.dell.pandalive.entity.ChinaBean;

import java.util.List;

/**
 * Created by dell on 2017/8/28.
 */

public interface IChinaView {

    void ShowTab(List<ChinaBean.TablistBean> tablist, List<ChinaBean.AlllistBean> alllist);
}
