package com.example.dell.pandalive.ui.livepanda.viewlive;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * 熊猫直播
 */
public class LiveDirectFragment extends BaseFragment {


    boolean isChanged = false;

    private View view;
    private ImageView live_play_img;
    private TextView live_plau_introduce;

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

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_live_direct, null);
        //介绍小三角图标
        live_play_img = (ImageView) view.findViewById(R.id.live_play_img);
        //介绍（文字）
        live_plau_introduce = (TextView) view.findViewById(R.id.live_plau_introduce);
        live_play_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//lpanda_show
                if (v == live_play_img) {


                    if (isChanged) {

                        live_play_img.setImageDrawable(getResources().getDrawable(R.mipmap.lpanda_show));

                        live_plau_introduce.setVisibility(View.GONE);
                        //隐藏文字
                    } else {
                        live_play_img.setImageDrawable(getResources().getDrawable(R.mipmap.lpanda_off));
                        //显示文字
                        live_plau_introduce.setVisibility(View.VISIBLE);
                    }
                    isChanged = !isChanged;
                }

            }
        });

/*

可见（visible)
XML文件：Android:visibility="visible"
Java代码：view.setVisibility(View.VISIBLE);
隐藏（GONE）
XML文件：android:visibility="gone"
Java代码：view.setVisibility(View.GONE);
                    */

    }
}
