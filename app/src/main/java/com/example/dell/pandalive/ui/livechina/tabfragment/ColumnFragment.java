package com.example.dell.pandalive.ui.livechina.tabfragment;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.ColumnAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.ui.livechina.tabfragment.presenter.TabPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by dell on 2017/8/28.
 */

public class ColumnFragment extends BaseFragment implements ITabView {

    private View view;
    private ListView column_listview;
    private String url;
    private TabPresenter tabPresenter;
    private int firstVisible = 0, visibleCount = 0, totalCount = 0;
    private ColumnAdapter columnAdapter;
    private SmartRefreshLayout column_refreshlayout;

    public ColumnFragment(String url) {
        this.url = url;
    }

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

        tabPresenter.ShowTab(url);

        column_refreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

                tabPresenter.ShowTab(url);
                refreshlayout.finishRefresh();
            }
        });
    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.column_fragment, null);

        tabPresenter = new TabPresenter(this);
        column_listview = (ListView) view.findViewById(R.id.column_listview);
        column_refreshlayout = (SmartRefreshLayout) view.findViewById(R.id.column_refreshlayout);

        column_refreshlayout.setRefreshHeader(new ClassicsHeader(Myapp.activity));
        setplay();
    }

    private void setplay() {

        column_listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {

                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:

                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:

                        autoPlayVideo(view);
                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:

                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                // firstVisibleItem   当前第一个可见的item
                // visibleItemCount   当前可见的item个数
                if (firstVisible == firstVisibleItem) {
                    return;
                }
                firstVisible = firstVisibleItem;
                visibleCount = visibleItemCount;
                totalCount = totalItemCount;
            }
        });
    }

    @Override
    public void ShowTab(List<ColumnBean.LiveBean> live) {

        columnAdapter = new ColumnAdapter(Myapp.activity, live);
        column_listview.setAdapter(columnAdapter);
    }

    private void autoPlayVideo(AbsListView view) {
        for (int i = 0; i < visibleCount; i++) {
            if (view != null && view.getChildAt(i) != null && view.getChildAt(i).findViewById(R.id.videoplayer_item) != null) {
                JCVideoPlayerStandard videoPlayerStandard1 = (JCVideoPlayerStandard) view.getChildAt(i).findViewById(R.id.videoplayer_item);
                Rect rect = new Rect();
                videoPlayerStandard1.getLocalVisibleRect(rect);
                int videoheight3 = videoPlayerStandard1.getHeight();
                if (rect.top == 0 && rect.bottom == videoheight3) {

                    JCVideoPlayer.releaseAllVideos();
                    return;
                }

            }
        }
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
