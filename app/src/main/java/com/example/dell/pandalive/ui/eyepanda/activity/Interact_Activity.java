package com.example.dell.pandalive.ui.eyepanda.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.InteractListViewAdapter;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.entity.InteractListViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

public class Interact_Activity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ImageView interact_back_imageview;
    private ListView interact_listview;
    private List<InteractListViewBean.InteractiveBean> listViewBeen=new ArrayList<>();
    @Override
    protected void initdata() {

        InteractListViewAdapter adapter=new InteractListViewAdapter(this,listViewBeen);
        interact_listview.setAdapter(adapter);
    }

    @Override
    protected void initview() {
        interact_back_imageview = (ImageView) findViewById(R.id.interact_back_imageview);
        interact_listview = (ListView) findViewById(R.id.interact_listview);

        interact_back_imageview.setOnClickListener(this);
        interact_listview.setOnItemClickListener(this);


    }

    @Override
    protected int initlayout() {
        return R.layout.activity_interact;
    }

    @Override
    public void onClick(View v) {

            finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent interactintent=new Intent(Interact_Activity.this,Interact_WebView_Activity.class);
        interactintent.putExtra("url",listViewBeen.get(position).getUrl());
        interactintent.putExtra("title",listViewBeen.get(position).getTitle());
        startActivity(interactintent);
    }
}
