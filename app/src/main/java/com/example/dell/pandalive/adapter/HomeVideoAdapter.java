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
import com.example.dell.pandalive.entity.VideoBean;

import java.util.List;

/**
 * Created by dell on 2017/8/25.
 */

public class HomeVideoAdapter extends BaseAdapter{

    private Context context;
    private List<VideoBean.ListBean> list;

    public HomeVideoAdapter(Context context, List<VideoBean.ListBean> list) {

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
            convertView = LayoutInflater.from(context).inflate(R.layout.home_video_items, null);
            ho.h_video_date = (TextView) convertView.findViewById(R.id.h_video_datess);
            ho.h_video_te_item = (TextView) convertView.findViewById(R.id.h_video_te_itemss);
            ho.look_timess = (TextView) convertView.findViewById(R.id.look_timess);
            ho.look_imgss = (ImageView) convertView.findViewById(R.id.look_imgss);
            convertView.setTag(ho);
        } else {
            ho = (Myholder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getImage()).into(ho.look_imgss);
        ho.look_imgss.setScaleType(ImageView.ScaleType.FIT_XY);
        ho.look_timess.setText(list.get(position).getVideoLength());
        ho.h_video_te_item.setText(list.get(position).getTitle());
        ho.h_video_date.setText(list.get(position).getDaytime());

        return convertView;
    }

    private class Myholder{

        ImageView look_imgss;
        TextView h_video_date
                ,look_timess
                , h_video_te_item;
    }
}
