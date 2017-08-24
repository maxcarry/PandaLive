package com.example.dell.pandalive.ui.home.presenter;

import com.example.dell.pandalive.entity.HomeBean;

import java.util.List;

/**
 * Created by dell on 2017/8/24.
 */

public interface IHomepresenter {

    void getlist();
    void setlist(List<HomeBean.DataBean.Ad8Bean> list);

}
