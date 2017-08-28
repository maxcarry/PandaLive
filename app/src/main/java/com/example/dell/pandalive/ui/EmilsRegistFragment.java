package com.example.dell.pandalive.ui;

import android.view.LayoutInflater;
import android.view.View;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseFragment;

/**
 * Created by 贾成昆 on 2017/8/28.
 */

public class EmilsRegistFragment extends BaseFragment {

    private View view;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_emilsregist,null);

        return view;
    }

    @Override
    protected void initview() {

    }
}
