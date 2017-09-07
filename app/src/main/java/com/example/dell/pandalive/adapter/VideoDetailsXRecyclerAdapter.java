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
import com.example.dell.pandalive.entity.VideoDetailsHDBean;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/30.
 */

public class VideoDetailsXRecyclerAdapter extends BaseAdapter {

    Context mContext;
    List<VideoDetailsHDBean.VideoBean> list;

    public VideoDetailsXRecyclerAdapter(Context mContext, List<VideoDetailsHDBean.VideoBean> list) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.videodetails_xrcyclerview_item, null);
            holder.videodetailstvt = (TextView) convertView.findViewById(R.id.video_details_tv_t);
            holder.videodetailstvlen = (TextView) convertView.findViewById(R.id.video_details_tv_len);
            holder.videodetailsivimageview = (ImageView) convertView.findViewById(R.id.video_details_iv_imageview);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        Glide.with(mContext).load(list.get(position).getImg()).into(holder.videodetailsivimageview);
        holder.videodetailstvt.setText(list.get(position).getT());
        holder.videodetailstvlen.setText(list.get(position).getLen()+"");
        return convertView;
    }

    class Holder{
        ImageView videodetailsivimageview;
        TextView videodetailstvlen, videodetailstvt;
    }

//    public VideoDetailsXRecyclerAdapter(Context mContext, List<VideoDetailsHDBean.VideoBean> list) {
//        this.mContext = mContext;
//        this.list = list;
//    }
//
//    class Holder extends RecyclerView.ViewHolder {
//        ImageView videodetailsivimageview;
//        TextView videodetailstvlen, videodetailstvt;
//
//        public Holder(View itemView) {
//            super(itemView);
//            videodetailsivimageview = (ImageView) itemView.findViewById(R.id.video_details_iv_imageview);
//            videodetailstvlen = (TextView) itemView.findViewById(R.id.video_details_tv_len);
//            videodetailstvt = (TextView) itemView.findViewById(R.id.video_details_tv_t);
//        }
//    }
//
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(mContext).inflate(R.layout.videodetails_xrcyclerview_item, null);
//        return new Holder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        Holder holder1 = (Holder) holder;
//        Glide.with(mContext).load(list.get(position).getImg()).into(holder1.videodetailsivimageview);
//        holder1.videodetailstvlen.setText(list.get(position).getLen() + "");
//        holder1.videodetailstvt.setText(list.get(position).getT());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
}