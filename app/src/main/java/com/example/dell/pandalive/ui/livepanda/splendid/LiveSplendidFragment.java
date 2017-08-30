package com.example.dell.pandalive.ui.livepanda.splendid;


import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.LiveSplendidAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.LiveSplendidBean;
import com.example.dell.pandalive.utils.DialogUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 * 精彩一刻
 *
 */
public class LiveSplendidFragment extends BaseFragment implements ILiveSplendidFragment {

    private View view;

    private XRecyclerView live_splendid_xrecycler;
    LiveSplendidPresenter liveSplendidPresenter;
    private LiveSplendidAdapter liveSplendidAdapter;

    @Override
    protected void restartdata() {

        DialogUtil.instance().Showdialog(Myapp.activity);
        liveSplendidPresenter.ShowSplendid();
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
        liveSplendidPresenter = new LiveSplendidPresenter(this);
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
    public void liveBean(final List<LiveSplendidBean.VideoBean> videoBeen) {


        liveSplendidAdapter = new LiveSplendidAdapter(getActivity(), videoBeen);
        live_splendid_xrecycler.setAdapter(liveSplendidAdapter);

        liveSplendidAdapter.setonclick(new LiveSplendidAdapter.Jiekou() {
            @Override
            public void onclick(int position) {
                Toast.makeText(Myapp.activity, "点击了第" + position + "条数据，目前不能跳转", Toast.LENGTH_LONG).show();
            }
        });
    }

//    @Override
//    public void geturl() {
//        String strurl="\thttp://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";
//
//    }

//    @Override
//    public void geturl(String url) {
//        String strurl="\thttp://api.cntv.cn/video/videolistById?vsid=VSET100167216881&n=7&serviceId=panda&o=desc&of=time&p=1";
//
//    }
}
