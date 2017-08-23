package com.example.dell.pandalive.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2017/8/11.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initview();

        initdata();
        
        return initlayout();
    }

    @Override
    public void onResume() {
        super.onResume();

        restartdata();
    }

    protected abstract void restartdata();

    protected abstract void initdata();

    protected abstract View initlayout();

    protected abstract void initview();

}
