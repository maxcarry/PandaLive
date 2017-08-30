package com.example.dell.pandalive.ui.livepanda.yield;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.LivePerformAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.perform.ILivePerformFragment;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;
import com.example.dell.pandalive.utils.DialogUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 * 当熊不让
 *
 */

public class LiveYieldFragment extends BaseFragment implements ILivePerformFragment{
    private View view;
    private XRecyclerView live_splendid_xrecycler;
    private LiveYieldPresenter liveYieldPresenter;
    private LivePerformAdapter livePerformAdapter;

    @Override
    protected void restartdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        liveYieldPresenter.ShowPerform();
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
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_jingcai, null);
        liveYieldPresenter = new LiveYieldPresenter(this);
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
    public void liveperformBean(List<LivePerformBean.VideoBean> performBeen) {
        //调用Adapter展示数据，这个判断是为了不重复创建MyAdapter的对象
//        if (livePerformAdapter==null){
        livePerformAdapter = new LivePerformAdapter(getActivity(), performBeen);
        live_splendid_xrecycler.setAdapter(livePerformAdapter);
//        }else {
//            livePerformAdapter.notifyDataSetChanged();
//        }

        livePerformAdapter.setonclick(new LivePerformAdapter.Jiekou() {
            @Override
            public void onclick(int position) {
                Toast.makeText(getActivity(), "点击了第" + position + "条目", Toast.LENGTH_LONG).show();
            }
        });
    }
}
