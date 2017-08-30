package com.example.dell.pandalive.ui.videopanda.detailsfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.VideoDetailsXRecyclerAdapter;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.VideoDetailsHDBean;
import com.example.dell.pandalive.ui.videopanda.detailsfragment.persenter.HDPersenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/29.
 */

public class HD_completeFragment extends BaseFragment implements IHDcomView{

    private View view;
    private XRecyclerView xRecyclerView;
    private VideoDetailsXRecyclerAdapter xRecyclerAdapter;
    private LinearLayoutManager manager;
    private HDPersenter hdPersenter;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        hdPersenter.videodetailsshowrecycler();
    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hdcomplete,null);

        hdPersenter=new HDPersenter(this);
        xRecyclerView = (XRecyclerView) view.findViewById(R.id.video_hdcomplete_recyclerview);
    }

    @Override
    public void detailsshowrecycler(List<VideoDetailsHDBean.VideoBean> arrayList) {

//        Toast.makeText(Myapp.activity,""+arrayList.get(0).getT(),Toast.LENGTH_SHORT).show();

        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);

        xRecyclerView.setArrowImageView(R.drawable.xlistview_arrow);

        xRecyclerAdapter = new VideoDetailsXRecyclerAdapter(getActivity(),arrayList);
        xRecyclerView.setAdapter(xRecyclerAdapter);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xRecyclerView.loadMoreComplete();
            }
        });
    }
}
