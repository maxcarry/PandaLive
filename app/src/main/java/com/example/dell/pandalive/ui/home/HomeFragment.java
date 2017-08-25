package com.example.dell.pandalive.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.MyAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.entity.HomeBean;
import com.example.dell.pandalive.ui.home.presenter.HomePresenter;

import java.util.List;

/**
 * Created by dell on 2017/8/23.
 */

public class HomeFragment extends BaseFragment implements Ihomeview{

    private View view;
    private HomePresenter homePresenter;
    private ListView home_showtimer_listview;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

        homePresenter.getlist();

    }

    @Override
    protected View initlayout() {


        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.home_fragment, null);
        homePresenter = new HomePresenter(this);
        home_showtimer_listview = (ListView) view.findViewById(R.id.home_showtimer_listview);
    }

    @Override
    public void Showlistview(List<HomeBean.DataBean.Ad8Bean> list) {

        MyAdapter myAdapter = new MyAdapter(Myapp.activity,list);
        home_showtimer_listview.setAdapter(myAdapter);
    }
}
