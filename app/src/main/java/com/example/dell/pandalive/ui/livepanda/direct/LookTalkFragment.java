package com.example.dell.pandalive.ui.livepanda.direct;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.direct.directinterface.ILookTalkFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */

public class LookTalkFragment extends BaseFragment implements ILookTalkFragment{

    private View view;
    private GridView live_direct_gridview;

    @Override
    protected void restartdata() {

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
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.live_direct_fragment, null);

        live_direct_gridview = (GridView) view.findViewById(R.id.live_direct_gridview);



    }

    @Override
    public void livedirectBean(List<LiveDirectLiveBean> liveDirectbean) {

    }
}
