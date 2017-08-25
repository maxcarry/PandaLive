package com.example.dell.pandalive.ui.home;

import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.loaderutils.BannerGlideImageLoader;
import com.example.dell.pandalive.ui.home.presenter.HomePresenter;
import com.example.dell.pandalive.utils.DialogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * Created by dell on 2017/8/23.
 */

public class HomeFragment extends BaseFragment implements IHomeView{

    private View view;
    private Banner home_banner;
    private HomePresenter homePresenter;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

        DialogUtil.instance().Showdialog(Myapp.activity);
        homePresenter.ShowBanner();
        DialogUtil.instance().Hidedialog();
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

    }

    @Override
    public void ShowBanner(ArrayList<String> imalist, ArrayList<String> titlelist) {

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
        //banner设置方法全部调用完毕时最后调用
        home_banner.start();

    }
}
