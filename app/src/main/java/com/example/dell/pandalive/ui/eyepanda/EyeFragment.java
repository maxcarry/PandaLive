package com.example.dell.pandalive.ui.eyepanda;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.MyEyeListAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.BigImageBean;
import com.example.dell.pandalive.ui.eyepanda.activity.Interact_Activity;
import com.example.dell.pandalive.ui.eyepanda.presenter.EyePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class EyeFragment extends BaseFragment implements IEyeView, View.OnClickListener {

    private View view;
    private ImageView eyepanda_personal_imageview;
    private EyePresenter eyePresenter;
    private List<BigImageBean.DataBean.BigImgBean> bigImgBeen=new ArrayList<>();
    private ListView eyepanda_listview;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        eyePresenter.ShowBigImg();
    }

    @Override
    protected View initlayout() {


        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.eye_fragment, null);
        eyepanda_personal_imageview = (ImageView) view.findViewById(R.id.eyepanda_personal_imageview);
        eyepanda_listview = (ListView) view.findViewById(R.id.eyepanda_listview);

        eyepanda_personal_imageview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(), Interact_Activity.class);
        startActivity(intent);
    }

    @Override
    public void ShowBigImg(List<BigImageBean.DataBean.BigImgBean> bigImgBeanList) {
        MyEyeListAdapter eyeListAdapter=new MyEyeListAdapter(Myapp.activity,bigImgBeen);
        eyepanda_listview.setAdapter(eyeListAdapter);
    }
}
