package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.EyeRecyclerBean;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/26.
 */

public class MyEyeRecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<EyeRecyclerBean.ListBean> recyclerBean;
    private EyeRecyclerViewHolder recyclerViewHolder;

    public MyEyeRecyclerAdapter(Context context, List<EyeRecyclerBean.ListBean> recyclerBean) {
        this.context = context;
        this.recyclerBean = recyclerBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.eye_recyclerview_item,null);
        recyclerViewHolder = new EyeRecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        recyclerViewHolder= (EyeRecyclerViewHolder) holder;
        ((EyeRecyclerViewHolder) holder).eyerecycler_title_textview.setText(recyclerBean.get(position).getTitle());
        Glide.with(context).load(recyclerBean.get(position).getPicurl()).into(((EyeRecyclerViewHolder) holder).eyerecycler_picture_imageview);


    }

    @Override
    public int getItemCount() {
        return recyclerBean.size();
    }

    class EyeRecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView eyerecycler_picture_imageview;
        TextView eyerecycler_title_textview;
        TextView eyerecycler_time_textview;
        public EyeRecyclerViewHolder(View itemView) {
            super(itemView);
            eyerecycler_picture_imageview= (ImageView) itemView.findViewById(R.id.eyerecycler_picture_imageview);
            eyerecycler_title_textview= (TextView) itemView.findViewById(R.id.eyerecycler_title_textview);
            eyerecycler_time_textview= (TextView) itemView.findViewById(R.id.eyerecycler_time_textview);
        }
    }
}
