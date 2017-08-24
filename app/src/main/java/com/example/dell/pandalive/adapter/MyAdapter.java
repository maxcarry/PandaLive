package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.HomeBean;

import java.util.List;

/**
 * Created by dell on 2017/8/24.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    List<HomeBean.DataBean.Ad8Bean> list;

    public MyAdapter(Context context, List<HomeBean.DataBean.Ad8Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Myholder ho;

        if (convertView == null) {

            ho = new Myholder();
            convertView = LayoutInflater.from(context).inflate(R.layout.hoem_show_item, null);
            ho.show_ima_item = (ImageView) convertView.findViewById(R.id.show_ima_item);
            convertView.setTag(ho);
        } else {
            ho = (Myholder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getImage()).into(ho.show_ima_item);

        return convertView;
    }

    class Myholder{

        ImageView show_ima_item;
    }
}
