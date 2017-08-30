package com.example.dell.pandalive.ui.livepanda.unusual;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.LivePerformAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.PlayActivityUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 * 特别节目
 */

public class LiveUnusualFragment extends BaseFragment implements ILivePerformFragment {

    private View view;
    private XRecyclerView live_splendid_xrecycler;
    private LiveUnusualPresenter liveUnusualPresenter;
    private LivePerformAdapter livePerformAdapter;
    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        liveUnusualPresenter.ShowPerform();
        DialogUtil.instance().Hidedialog();
    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_jingcai, null);
        liveUnusualPresenter = new LiveUnusualPresenter(this);
        live_splendid_xrecycler = (XRecyclerView) view.findViewById(R.id.live_splendid_xrecycler);
        //瀑布流
        live_splendid_xrecycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        live_splendid_xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {



                live_splendid_xrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                live_splendid_xrecycler.refreshComplete();
            }
        });
    }

    @Override
    public void liveperformBean(final List<LivePerformBean.VideoBean> performBeen) {
       livePerformAdapter = new LivePerformAdapter(getActivity(), performBeen);
        live_splendid_xrecycler.setAdapter(livePerformAdapter);
        livePerformAdapter.setonclick(new LivePerformAdapter.Jiekou() {
            @Override
            public void onclick(int position) {
                String livet = performBeen.get(position).getT();
                String liveurl = performBeen.get(position).getUrl();

                Intent intent = new Intent(getActivity(), PlayActivityUtil.class);
                intent.putExtra("title",livet);
                intent.putExtra("path",liveurl);
                startActivity(intent);



//                Toast.makeText(getActivity(), "点击了第" + position + "条目", Toast.LENGTH_LONG).show();
            }
        });

    }
}
