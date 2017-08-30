package com.example.dell.pandalive.ui.videopanda;

import com.example.dell.pandalive.entity.VideoRVBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public interface IVideoView {

    void ShovideowBanner(ArrayList<String> bigImgBeen,ArrayList<String> videotitlelist,ArrayList<String> videopathlist);

    void ShowRecycler(List<VideoRVBean.ListBean> arrayList);

}
