package com.example.dell.pandalive.ui.eyepanda;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.MyEyeListAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.EyeListBean;
import com.example.dell.pandalive.loaderutils.BannerGlideImageLoader;
import com.example.dell.pandalive.ui.eyepanda.activity.Eye_Personal_Activity;
import com.example.dell.pandalive.ui.eyepanda.activity.Eye_WebView_Activity;
import com.example.dell.pandalive.ui.eyepanda.presenter.EyePresenter;
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
////
public class EyeFragment extends BaseFragment implements IEyeView, View.OnClickListener {

    private View view;
    private ImageView eyepanda_personal_imageview;
    private EyePresenter eyePresenter;
    private List<EyeListBean.ListBean> listBean = new ArrayList<>();
    private Banner eyepanda_banner;
    private ListView eyepanda_listview;
    private Intent intent = new Intent(Myapp.activity, PlayActivityUtil.class);

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);

        eyePresenter.ShowBigImg();

        eyePresenter.ShowEyeList();
    }

    @Override
    protected View initlayout() {

        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.eye_fragment, null);

        eyePresenter = new EyePresenter(this);
        eyepanda_personal_imageview = (ImageView) view.findViewById(R.id.eyepanda_personal_imageview);
        eyepanda_banner = (Banner) view.findViewById(R.id.eyepanda_banner);
        eyepanda_listview = (ListView) view.findViewById(R.id.eyepanda_listview);
        eyepanda_personal_imageview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(), Eye_Personal_Activity.class);
        startActivity(intent);
    }

    @Override
    public void ShowEyeBanner(ArrayList<String> imalist, final ArrayList<String> titlelist, final ArrayList<String> pathlist) {
        //设置banner样式
        eyepanda_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        eyepanda_banner.setImageLoader(new BannerGlideImageLoader());
        //设置图片集合
        eyepanda_banner.setImages(imalist);
        //设置banner动画效果
        eyepanda_banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        eyepanda_banner.setBannerTitles(titlelist);
        //设置自动轮播，默认为true
        eyepanda_banner.isAutoPlay(true);
        //设置轮播时间
        eyepanda_banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        eyepanda_banner.setIndicatorGravity(BannerConfig.CENTER);
        eyepanda_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

                intent.putExtra("title", titlelist.get(position));
                intent.putExtra("path", pathlist.get(position));
                startActivity(intent);
            }
        });
        //banner设置方法全部调用完毕时最后调用
        eyepanda_banner.start();

    }


    @Override
    public void ShowEyeList(List<EyeListBean.ListBean> eyelist) {

        listBean.addAll(eyelist);
        MyEyeListAdapter listAdapter = new MyEyeListAdapter(Myapp.activity, listBean);
        eyepanda_listview.setAdapter(listAdapter);
        eyepanda_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent webintent=new Intent(Myapp.activity, Eye_WebView_Activity.class);
                webintent.putExtra("url",listBean.get(position).getUrl());
                startActivity(webintent);
            }
        });
        DialogUtil.instance().Hidedialog();
    }

//    @Override
//    public void ShowInteract(List<InteractListViewBean.InteractiveBean> interactBeen) {
//
//
//    }
}
