package com.example.dell.pandalive.eventbus;

import com.example.dell.pandalive.entity.ChinaBean;

import java.util.List;

/**
 * Created by dell on 2017/8/30.
 */

public class ChinaEvent {

    private List<ChinaBean.TablistBean> tablist;
    private List<ChinaBean.AlllistBean> alllist;

    public ChinaEvent(List<ChinaBean.TablistBean> tablist, List<ChinaBean.AlllistBean> alllist) {
        this.tablist = tablist;
        this.alllist = alllist;
    }

    public List<ChinaBean.TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<ChinaBean.TablistBean> tablist) {
        this.tablist = tablist;
    }

    public List<ChinaBean.AlllistBean> getAlllist() {
        return alllist;
    }

    public void setAlllist(List<ChinaBean.AlllistBean> alllist) {
        this.alllist = alllist;
    }
}
