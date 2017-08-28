package com.example.dell.pandalive.ui.videopanda;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.VideoRecyclerAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.ui.videopanda.presenter.Videopersenter;
import com.example.dell.pandalive.utils.DialogUtil;

import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class VideoFragment extends BaseFragment implements IVideoView, VideoRecyclerAdapter.OnrecyclerDJ {

    //贾成昆
    private View view;

    RecyclerView videorecyclerView;

    Videopersenter videopersenter;

    private VideoRecyclerAdapter videoRecyclerAdapter;
    private LinearLayoutManager manager;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        videopersenter.videoshowrecycler();
        DialogUtil.instance().Hidedialog();

    }

    @Override
    protected View initlayout() {

        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.video_fragment, null);

        videopersenter = new Videopersenter(this);

        videorecyclerView = (RecyclerView) view.findViewById(R.id.video_recycler_view);
    }


    @Override
    public void ShowRecycler(List<VideoRVBean.ListBean> arrayList) {

//        Toast.makeText(Myapp.activity,""+arrayList.get(0).getTitle(),Toast.LENGTH_SHORT).show();

        manager = new LinearLayoutManager(getActivity());
        videoRecyclerAdapter = new VideoRecyclerAdapter(getActivity(), arrayList);

        videorecyclerView.setLayoutManager(manager);
        videoRecyclerAdapter.setOnrecyclerDJ(this);
        videorecyclerView.setAdapter(videoRecyclerAdapter);
        videoRecyclerAdapter.notifyDataSetChanged();

    }

    @Override
    public void showrecycler(int pos) {

        Intent intent = new Intent(getActivity(), VideoDetailsActivity.class);
        startActivity(intent);
    }
}