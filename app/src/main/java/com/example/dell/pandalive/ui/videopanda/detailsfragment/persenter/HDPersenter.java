package com.example.dell.pandalive.ui.videopanda.detailsfragment.persenter;

import com.example.dell.pandalive.entity.VideoDetailsHDBean;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.IHDcomView;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.model.HDModel;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/30.
 */

public class HDPersenter implements IHDpersenter{

    HDModel hdModel;
    IHDcomView ihdcomView;

    public HDPersenter(IHDcomView ihdcomView) {
        this.ihdcomView = ihdcomView;
        hdModel=new HDModel();
    }

    @Override
    public void videodetailsshowrecycler() {
        hdModel.videodetailsrecycl(this);
    }

    @Override
    public void videodetailsperrecycler(List<VideoDetailsHDBean.VideoBean> arrayList) {
                ihdcomView.detailsshowrecycler(arrayList);
    }
}
