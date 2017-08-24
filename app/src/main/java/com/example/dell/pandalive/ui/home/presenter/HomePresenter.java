package com.example.dell.pandalive.ui.home.presenter;

import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.ui.home.Ihomeview;
import com.example.dell.pandalive.ui.home.model.HomeMoudel;

import java.util.List;

/**
 * Created by dell on 2017/8/24.
 */

public class HomePresenter implements IHomepresenter{

    private final HomeMoudel homeMoudel;
    private Ihomeview ihomeview;

    public HomePresenter(Ihomeview ihomeview) {

        this.ihomeview = ihomeview;
        homeMoudel = new HomeMoudel();

    }

    @Override
    public void getlist() {

        homeMoudel.Webhoem(this);
    }

    @Override
    public void setlist(List<HomeBean.DataBean.Ad8Bean> list) {

        ihomeview.Showlistview(list);
    }
}
