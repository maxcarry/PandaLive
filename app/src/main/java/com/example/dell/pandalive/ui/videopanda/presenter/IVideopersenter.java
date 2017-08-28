package com.example.dell.pandalive.ui.videopanda.presenter;

import com.example.dell.pandalive.entity.VideoRVBean;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public interface IVideopersenter {



    void videoshowrecycler();
    void videoperrecycler(List<VideoRVBean.ListBean> arrayList);
}
