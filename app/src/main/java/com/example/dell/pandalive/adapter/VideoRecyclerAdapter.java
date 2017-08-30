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
import com.example.dell.pandalive.entity.VideoRVBean;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public class VideoRecyclerAdapter extends BaseAdapter{
    Context mContext;
    List<VideoRVBean.ListBean> list;

    public VideoRecyclerAdapter(Context mContext, List<VideoRVBean.ListBean> list) {
        this.mContext = mContext;
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

        Holder holder;
        if(convertView==null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.video_recycler_item, null);
            holder.videoimage = (ImageView) convertView.findViewById(R.id.video_iv_imageview);
            holder.mylength = (TextView) convertView.findViewById(R.id.video_tv_length);
            holder.mytitle = (TextView) convertView.findViewById(R.id.video_tv_title);
            holder.mybrief = (TextView) convertView.findViewById(R.id.video_tv_brief);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        Glide.with(mContext).load(list.get(position).getImage()).into(holder.videoimage);
        holder.mytitle.setText(list.get(position).getTitle());
        holder.mylength.setText(list.get(position).getVideoLength()+"");
        holder.mybrief.setText(list.get(position).getBrief());
        return convertView;

    }
class Holder{
    ImageView videoimage;
    TextView mylength, mytitle, mybrief;
}

}