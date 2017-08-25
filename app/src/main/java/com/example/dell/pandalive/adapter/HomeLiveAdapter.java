package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.HomeBean;

import java.util.List;

/**
 * Created by dell on 2017/8/25.
 */

public class HomeLiveAdapter extends BaseAdapter{
    private Context context;
    private List<HomeBean.DataBean.PandaliveBean.ListBean> list;

    public HomeLiveAdapter(Context context, List<HomeBean.DataBean.PandaliveBean.ListBean> list) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.home_live_item, null);
            ho.h_live_ima_item = (ImageView) convertView.findViewById(R.id.h_live_ima_item);
            ho.h_live_te_item = (TextView) convertView.findViewById(R.id.h_live_te_item);

            convertView.setTag(ho);
        } else {
            ho = (Myholder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getImage()).into(ho.h_live_ima_item);
        ho.h_live_te_item.setText(list.get(position).getTitle());

        return convertView;
    }

    private class Myholder{
        ImageView h_live_ima_item;
        TextView h_live_te_item;
    }
}
