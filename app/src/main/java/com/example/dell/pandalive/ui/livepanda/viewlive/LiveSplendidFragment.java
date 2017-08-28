package com.example.dell.pandalive.ui.livepanda.viewlive;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * A simple {@link Fragment} subclass.
 * 精彩一刻
 */
public class LiveSplendidFragment extends BaseFragment {

    private View view;
    private TextView tvContent;
    private XRecyclerView live_xrecyclerview;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        tvContent = (TextView) view.findViewById(R.id.tv_content);
        String string = getArguments().getString(KEY);
        tvContent.setText(string);
        tvContent.setTextColor(Color.BLUE);
        tvContent.setTextSize(30);
//LiveXRecyclerViewAdapter

        live_xrecyclerview = (XRecyclerView) view.findViewById(R.id.live_xrecyclerview);






    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_live_splendid, null);
    }


    public static LiveSplendidFragment newInstance(String str) {
        LiveSplendidFragment fragment = new LiveSplendidFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        fragment.setArguments(bundle);
        return fragment;

    }

}
