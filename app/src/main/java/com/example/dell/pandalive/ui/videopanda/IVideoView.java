package com.example.dell.pandalive.ui.videopanda;

import com.example.dell.pandalive.entity.VideoBanner;
import com.example.dell.pandalive.entity.VideoRVBean;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public interface IVideoView {

    void ShovideowBanner(List<VideoBanner.BigImgBean> bigImgBeen);

    void ShowRecycler(List<VideoRVBean.ListBean> arrayList);

}
