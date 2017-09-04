package com.example.dell.pandalive.ui.livepanda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.ui.livepanda.perform.LivePerformBean;

import java.util.List;

import static com.example.dell.pandalive.R.id.h_video_te_item;
import static com.example.dell.pandalive.R.id.look_time;

/**
 * Created by Administrator on 2017/8/31.
 */

public class LiveVideoAdapter extends BaseAdapter {

    private Context context;
    private  List<LivePerformBean.VideoBean> performBeen;

    public LiveVideoAdapter(Context context,  List<LivePerformBean.VideoBean> performBeen) {

        this.context = context;
        this.performBeen = performBeen;
    }

    @Override
    public int getCount() {
        return performBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return performBeen.get(position);
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

            convertView = LayoutInflater.from(context).inflate(R.layout.home_video_item, null);
            ho.h_video_date = (TextView) convertView.findViewById(R.id.h_video_date);
            ho.h_video_te_item = (TextView) convertView.findViewById(h_video_te_item);
            ho.h_video_time_item = (TextView) convertView.findViewById(look_time);
            ho.h_video_ima_item = (ImageView) convertView.findViewById(R.id.look_img);
            convertView.setTag(ho);
        } else {
            ho = (Myholder) convertView.getTag();
        }
        //图片
        Glide.with(context).load(performBeen.get(position).getImg()).into(ho.h_video_ima_item);

        ho.h_video_ima_item.setScaleType(ImageView.ScaleType.FIT_XY);
        //播放时间
        ho.h_video_time_item.setText(performBeen.get(position).getLen());
        //介绍
        ho.h_video_te_item.setText(performBeen.get(position).getT());
        //日期
        ho.h_video_date.setText(performBeen.get(position).getPtime());

        return convertView;
    }

    private class Myholder{

        ImageView h_video_ima_item;
        TextView h_video_date
                ,h_video_time_item
                , h_video_te_item;
    }
}
