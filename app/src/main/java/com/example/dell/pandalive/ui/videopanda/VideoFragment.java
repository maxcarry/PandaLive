package com.example.dell.pandalive.ui.videopanda;

import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;

/**
 * Created by dell on 2017/8/23.
 */

public class VideoFragment extends BaseFragment {

    private View view;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.video_fragment, null);
        
        return view;
    }

    @Override
    protected void initview() {

    }
}
