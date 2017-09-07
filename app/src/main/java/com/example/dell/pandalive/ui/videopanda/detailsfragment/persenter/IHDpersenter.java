package com.example.dell.pandalive.ui.videopanda.detailsfragment.persenter;

import com.example.dell.pandalive.entity.VideoDetailsHDBean;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/30.
 */

public interface IHDpersenter {
    void videodetailsshowrecycler(String url);
    void videodetailsperrecycler(List<VideoDetailsHDBean.VideoBean> arrayList);
}
