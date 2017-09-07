package com.example.dell.pandalive.ui.livepanda.splendid;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.DatabaseReady;
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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * 精彩一刻
 *
 */
public class LiveSplendidFragment extends BaseFragment implements ILivePerformFragment {


    private View view;
    private LiveSplendidPresenter liveOriginalPresenter;
    private ListView live_splendid_customlistview;
    private SmartRefreshLayout live_smartrefreshlayout;
    private List<LivePerformBean.VideoBean> video;

    @Override
    protected void restartdata() {

        geturls();
        //上啦刷新
        live_smartrefreshlayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {

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
    private void geturls() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        liveOriginalPresenter.ShowPerform();
        DialogUtil.instance().Hidedialog();
    }
    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_customlistview, null);
        liveOriginalPresenter = new LiveSplendidPresenter(this);

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

                    DatabaseReady databaseReady=new DatabaseReady();

                    databaseReady.add1(video.get(position).getT(),video.get(position).getPtime(),video.get(position).getLen(),video.get(position).getImg());
                    databaseReady.add2(video.get(position).getT(),video.get(position).getPtime(),video.get(position).getLen(),video.get(position).getImg(),video.get(position).getVid(),"2");


                    Intent live = new Intent(Myapp.activity, PlayActivityUtil.class);
                    live.putExtra("title", video.get(position).getT());
                    live.putExtra("path", video.get(position).getVid());
                    live.putExtra("type", "1");
                    startActivity(live);





                }
            });


        }

    }
}
