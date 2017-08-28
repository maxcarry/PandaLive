package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.VideoRVBean;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public class VideoRecyclerAdapter extends RecyclerView.Adapter {

    public interface OnrecyclerDJ{
        void showrecycler(int pos);
    }

    private OnrecyclerDJ onrecyclerDJ;

    public void setOnrecyclerDJ(OnrecyclerDJ onrecyclerDJ) {
        this.onrecyclerDJ = onrecyclerDJ;
    }

    Context mContext;
    List<VideoRVBean.ListBean> list;


    public VideoRecyclerAdapter(Context mContext, List<VideoRVBean.ListBean> list) {
        this.mContext = mContext;
        this.list = list;

    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView videoimage;
        TextView mylength, mytitle, mybrief;
        int positon;

        public Holder(View itemView) {
            super(itemView);
            videoimage = (ImageView) itemView.findViewById(R.id.video_iv_imageview);
            mylength = (TextView) itemView.findViewById(R.id.video_tv_length);
            mytitle = (TextView) itemView.findViewById(R.id.video_tv_title);
            mybrief = (TextView) itemView.findViewById(R.id.video_tv_brief);

//                    if (onrecyclerDJ != null) {
//                        onrecyclerDJ.showrecycler(positon);
//                    }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.video_recycler_item, null);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Holder holder1 = (Holder) holder;
//        holder1.positon = position;
        Glide.with(mContext).load(list.get(position).getImage()).into(holder1.videoimage);
        holder1.mytitle.setText(list.get(position).getTitle());
        holder1.mylength.setText(list.get(position).getVideoLength() + "");
        holder1.mybrief.setText(list.get(position).getBrief());
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onrecyclerDJ != null) {
                        onrecyclerDJ.showrecycler(position);
                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}