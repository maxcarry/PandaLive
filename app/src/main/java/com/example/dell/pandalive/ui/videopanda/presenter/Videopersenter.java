package com.example.dell.pandalive.ui.videopanda.presenter;

import com.example.dell.pandalive.entity.VideoBanner;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.ui.videopanda.IVideoView;
import com.example.dell.pandalive.ui.videopanda.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public class Videopersenter implements IVideopersenter {

    VideoModel videoModel;
    IVideoView videoView;

    public Videopersenter(IVideoView videoView) {
        this.videoView = videoView;
        videoModel = new VideoModel();
    }

    @Override
    public void videogetbanner() {
        videoModel.videobannershow(this);
    }

    @Override
    public void videoshowbanner(VideoBanner videoBanner) {
        ShowvideowBanner(videoBanner);
    }

    private void ShowvideowBanner(VideoBanner videoBanner) {
        ArrayList<VideoBanner.BigImgBean> bigImg = (ArrayList<VideoBanner.BigImgBean>) videoBanner.getBigImg();
        ArrayList<String> imalist = new ArrayList<String>();
        ArrayList<String> titlelist = new ArrayList<String>();
        ArrayList<String> pathlist = new ArrayList<String>();

        for (VideoBanner.BigImgBean bigimgBean : bigImg) {
            imalist.add(bigimgBean.getImage());
            titlelist.add(bigimgBean.getTitle());
            pathlist.add(bigimgBean.getUrl());
        }
        videoView.ShovideowBanner(imalist, titlelist, pathlist);

    }

    @Override
    public void videoshowrecycler() {
        videoModel.videorecycler(this);
    }

    @Override
    public void videoperrecycler(List<VideoRVBean.ListBean> arrayList) {
        videoView.ShowRecycler(arrayList);
    }
}