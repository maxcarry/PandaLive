package com.example.dell.pandalive.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.HomeChinaAdapter;
import com.example.dell.pandalive.adapter.HomeLiveAdapter;
import com.example.dell.pandalive.adapter.HomeTvAdapter;
import com.example.dell.pandalive.adapter.HomeVideoAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.custom_view.CustomGridview;
import com.example.dell.pandalive.custom_view.CustomListview;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.entity.TvBean;
import com.example.dell.pandalive.entity.VideoBean;
import com.example.dell.pandalive.loaderutils.BannerGlideImageLoader;
import com.example.dell.pandalive.ui.eyepanda.activity.Interact_Activity;
import com.example.dell.pandalive.ui.personal.Eye_Personal_Activity;
import com.example.dell.pandalive.ui.home.presenter.HomePresenter;
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

public class HomeFragment extends BaseFragment implements IHomeView, View.OnClickListener {

    private View view;
    private Banner home_banner;
    private HomePresenter homePresenter;
    private Intent play = new Intent(Myapp.activity, PlayActivityUtil.class);
    private ImageView home_person;
    private ImageView home_eye_logo;
    private TextView home_eye_onetitle;
    private TextView home_eye_onecontent;
    private TextView home_eye_twotitle;
    private TextView home_eye_twocontent;
    private CustomGridview home_live_grid;
    private HomeLiveAdapter homeLiveAdapter;
    private CustomGridview home_tv_grid;
    private CustomListview home_video_list;
    private CustomGridview home_china_grid;
    private ImageView home_bg;
    private ImageView home_interact;


    @Override
    protected void restartdata() {


    }

    @Override
    protected void initdata() {

        DialogUtil.instance().Showdialog(Myapp.activity);
        homePresenter.ShowView();
        homePresenter.ShowTv();
        homePresenter.ShowVideo();
    }

    @Override
    protected View initlayout() {


        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.home_fragment, null);

        homePresenter = new HomePresenter(this);
        home_banner = (Banner) view.findViewById(R.id.home_banner);
        home_person = (ImageView) view.findViewById(R.id.home_person);
        home_eye_logo = (ImageView) view.findViewById(R.id.home_eye_logo);
        home_eye_onetitle = (TextView) view.findViewById(R.id.home_eye_onetitle);
        home_eye_onecontent = (TextView) view.findViewById(R.id.home_eye_onecontent);
        home_eye_twotitle = (TextView) view.findViewById(R.id.home_eye_twotitle);
        home_eye_twocontent = (TextView) view.findViewById(R.id.home_eye_twocontent);
        home_live_grid = (CustomGridview) view.findViewById(R.id.home_live_grid);
        home_tv_grid = (CustomGridview) view.findViewById(R.id.home_tv_grid);
        home_video_list = (CustomListview) view.findViewById(R.id.home_video_list);
        home_china_grid = (CustomGridview) view.findViewById(R.id.home_china_grid);
        home_bg = (ImageView) view.findViewById(R.id.home_bg);
        home_interact = (ImageView) view.findViewById(R.id.home_interact);

        home_person.setOnClickListener(this);
        home_interact.setOnClickListener(this);

    }

    @Override
    public void ShowBanner(ArrayList<String> imalist, final ArrayList<String> titlelist, final ArrayList<String> pathlist) {

        //设置banner样式
        home_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        home_banner.setImageLoader(new BannerGlideImageLoader());
        //设置图片集合
        home_banner.setImages(imalist);
        //设置banner动画效果
        home_banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        home_banner.setBannerTitles(titlelist);
        //设置自动轮播，默认为true
        home_banner.isAutoPlay(true);
        //设置轮播时间
        home_banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        home_banner.setIndicatorGravity(BannerConfig.CENTER);
        home_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                play.putExtra("title", titlelist.get(position));
                play.putExtra("path", pathlist.get(position));
                startActivity(play);
            }
        });
        //banner设置方法全部调用完毕时最后调用
        home_banner.start();

        home_bg.setVisibility(View.GONE);
    }

    @Override
    public void ShowEye(final HomeBean.DataBean.PandaeyeBean eyebean) {

        Glide.with(Myapp.activity).load(eyebean.getPandaeyelogo()).into(home_eye_logo);
        home_eye_onetitle.setText(eyebean.getItems().get(0).getBrief());
        home_eye_onecontent.setText(eyebean.getItems().get(0).getTitle());
        home_eye_onecontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.putExtra("title", eyebean.getItems().get(0).getTitle());
                play.putExtra("path", eyebean.getItems().get(0).getUrl());
                startActivity(play);
            }
        });
        home_eye_twotitle.setText(eyebean.getItems().get(1).getBrief());
        home_eye_twocontent.setText(eyebean.getItems().get(1).getTitle());
        home_eye_twocontent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.putExtra("title", eyebean.getItems().get(1).getTitle());
                play.putExtra("path", eyebean.getItems().get(1).getUrl());
                startActivity(play);
            }
        });
    }

    @Override
    public void ShowLive(List<HomeBean.DataBean.PandaliveBean.ListBean> livelist) {

        home_live_grid.setSelector(new ColorDrawable(Color.TRANSPARENT));
        homeLiveAdapter = new HomeLiveAdapter(Myapp.activity,livelist);
        home_live_grid.setAdapter(homeLiveAdapter);
    }

    @Override
    public void ShowTv(final List<TvBean.ListBean> tvlist) {

        home_tv_grid.setSelector(new ColorDrawable(Color.TRANSPARENT));
        HomeTvAdapter homeTvAdapter = new HomeTvAdapter(Myapp.activity,tvlist);
        home_tv_grid.setAdapter(homeTvAdapter);
        home_tv_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                play.putExtra("title", tvlist.get(position).getTitle());
                play.putExtra("path", tvlist.get(position).getUrl());
                startActivity(play);
            }
        });
    }

    @Override
    public void ShowVideo(final List<VideoBean.ListBean> videolist) {

        home_video_list.setSelector(new ColorDrawable(Color.TRANSPARENT));
        HomeVideoAdapter homeVideoAdapter = new HomeVideoAdapter(Myapp.activity,videolist);
        home_video_list.setAdapter(homeVideoAdapter);
        home_video_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                play.putExtra("title", videolist.get(position).getTitle());
                play.putExtra("path", videolist.get(position).getUrl());
                startActivity(play);
            }
        });
    }

    @Override
    public void ShowChina(final List<HomeBean.DataBean.ChinaliveBean.ListBeanX> chinalist) {

        home_china_grid.setSelector(new ColorDrawable(Color.TRANSPARENT));
        HomeChinaAdapter homeChinaAdapter = new HomeChinaAdapter(Myapp.activity,chinalist);
        home_china_grid.setAdapter(homeChinaAdapter);
        home_china_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                play.putExtra("title", chinalist.get(position).getTitle());
                play.putExtra("path", chinalist.get(position).getUrl());
                startActivity(play);
            }
        });

        DialogUtil.instance().Hidedialog();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_person:

                startActivity(new Intent(Myapp.activity, Eye_Personal_Activity.class));
                break;

            case R.id.home_interact:

                startActivity(new Intent(Myapp.activity, Interact_Activity.class));
                break;
        }
    }
}