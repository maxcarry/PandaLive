package com.example.dell.pandalive.ui.livepanda.original;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.LiveVideoAdapter;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.PlayActivityUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 * 原创新闻
 * 模范试用版本
 */

public class LiveOriginalFragment extends BaseFragment implements ILivePerformFragment {

    private View view;
    private LiveOriginalPresenter liveOriginalPresenter;
    private ListView live_splendid_customlistview;
    private SmartRefreshLayout live_smartrefreshlayout;
    private List<LivePerformBean.VideoBean> performBeen=new ArrayList<>();
    private List<LivePerformBean.VideoBean> video;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {


        geturls();
        //上啦刷新
        live_smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                performBeen.clear();
                refreshlayout.finishRefresh(2000);
                geturls();

            }
        });
        //下啦加载
        live_smartrefreshlayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                geturls();
                live_smartrefreshlayout.finishLoadmore();
            }
        });
    }

    private void  geturls() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        liveOriginalPresenter.ShowPerform();
        DialogUtil.instance().Hidedialog();
    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_customlistview, null);
        liveOriginalPresenter = new LiveOriginalPresenter(this);
        live_splendid_customlistview = (ListView) view.findViewById(R.id.live_splendid_customlistview);

        live_smartrefreshlayout = (SmartRefreshLayout) view.findViewById(R.id.live_smartrefreshlayout);

        live_smartrefreshlayout.setRefreshHeader(new ClassicsHeader(Myapp.activity));
        live_smartrefreshlayout.setRefreshFooter(new ClassicsFooter(Myapp.activity));

    }

    @Override
    public void liveperformBean(final List<LivePerformBean> performBeen) {
        List<LivePerformBean> livePerformBeen = performBeen;


        for (int i = 0; i < livePerformBeen.size(); i++) {
            video = livePerformBeen.get(i).getVideo();

            //适配器
            LiveVideoAdapter liveVideoAdapter = new LiveVideoAdapter(Myapp.activity, video);
            live_splendid_customlistview.setAdapter(liveVideoAdapter);

            live_splendid_customlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                            //PlayActivityUtil
                    Intent live = new Intent(Myapp.activity, PlayActivityUtil.class);
                    live.putExtra("title", video.get(position).getT());
                    live.putExtra("path", video.get(position).getVsid());
                    live.putExtra("path", "2");
                    startActivity(live);

                    /*play.putExtra("title", chinalist.get(position).getTitle());
                play.putExtra("path",  "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+chinalist.get(position).getId()+"&client=androidapp");
                play.putExtra("type", "1");*/
                }
            });

        }


    }
}
