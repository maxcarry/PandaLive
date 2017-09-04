package com.example.dell.pandalive.ui.livepanda.direct.many;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.direct.directinterface.ILookTalkFragment;

/**
 * Created by Administrator on 2017/8/31.
 *LookTalkModel
 * LookTalkPresenter
 * 多视角直播
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

//        live_direct_gridview = (GridView) view.findViewById(R.id.live_direct_gridview);



    }

    @Override
    public void livedirectBean(LookTalkBean liveDirectbean) {

//        List<LookTalkBean.ListBean> list1=liveDirectbean.getList();
//        LookTalkAdapters lookTalkAdapters=new LookTalkAdapters(getActivity(),list1);
//
//        live_direct_gridview.setAdapter(lookTalkAdapters);
//
//        live_direct_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(),"点击第了"+i+"个直播",Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
