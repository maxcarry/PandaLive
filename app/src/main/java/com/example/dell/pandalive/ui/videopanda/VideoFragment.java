package com.example.dell.pandalive.ui.videopanda;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.VideoRecyclerAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.VideoRVBean;
import com.example.dell.pandalive.loaderutils.BannerGlideImageLoader;
import com.example.dell.pandalive.ui.videopanda.presenter.Videopersenter;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.PlayActivityUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class VideoFragment extends BaseFragment implements IVideoView {

    //贾成昆
    private View view;
    private Intent intent = new Intent(Myapp.activity, PlayActivityUtil.class);
    ListView videolistView;
    ScrollView scrollView;



    Videopersenter videopersenter;
    private VideoRecyclerAdapter videoRecyclerAdapter;
    private Banner videobanner;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        videopersenter.videogetbanner();
        videopersenter.videoshowrecycler();

    }

    @Override
    protected View initlayout() {

        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.video_fragment, null);

        videopersenter = new Videopersenter(this);
        videolistView = (ListView) view.findViewById(R.id.video_list_view);
        videobanner = (Banner) view.findViewById(R.id.video_banner);
    }


    @Override
    public void ShovideowBanner(ArrayList<String> bigImgBeen, final ArrayList<String> videotitlelist, final ArrayList<String> videopathlist) {
        //设置banner样式
        videobanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        videobanner.setImageLoader(new BannerGlideImageLoader());
        //设置图片集合
        videobanner.setImages(bigImgBeen);
        //设置banner动画效果
        videobanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        videobanner.setBannerTitles(videotitlelist);
        //设置自动轮播，默认为true
        videobanner.isAutoPlay(true);
        //设置轮播时间
        videobanner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        videobanner.setIndicatorGravity(BannerConfig.CENTER);
        videobanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                intent.putExtra("title", videotitlelist.get(position));
                intent.putExtra("path", videopathlist.get(position));
                startActivity(intent);
            }
        });
        //banner设置方法全部调用完毕时最后调用
        videobanner.start();
    }

    @Override
    public void ShowRecycler(final List<VideoRVBean.ListBean> arrayList) {

//        Toast.makeText(Myapp.activity,""+arrayList.get(0).getTitle(),Toast.LENGTH_SHORT).show();

        videoRecyclerAdapter = new VideoRecyclerAdapter(getActivity(), arrayList);
        videolistView.setAdapter(videoRecyclerAdapter);
        videoRecyclerAdapter.notifyDataSetChanged();
        videolistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailintent=new Intent(getActivity(),VideoDetailsActivity.class);
                detailintent.putExtra("title",arrayList.get(position).getTitle());
                detailintent.putExtra("url",arrayList.get(position).getUrl());
                startActivity(detailintent);
            }
        });
        DialogUtil.instance().Hidedialog();
    }
}