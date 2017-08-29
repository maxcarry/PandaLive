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
import com.example.dell.pandalive.entity.LiveSplendidBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 *
 * LivePerformAdapter
 */

public class LiveSplendidAdapter extends RecyclerView.Adapter{
    private Jiekou jiekou;
    private List<LiveSplendidBean.VideoBean> splendidlist;
    private Context context;

    public LiveSplendidAdapter( Context context,List<LiveSplendidBean.VideoBean> splendidlist) {
        this.splendidlist = splendidlist;
        this.context = context;
    }



    public void setonclick(Jiekou jiekous){
        this.jiekou=jiekous;
    }

    //接口
    public interface Jiekou{
        void onclick(int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //给Adapter添加布局，bq把这个view传递给HoldView，让HoldView找到空间
        View view= LayoutInflater.from(context).inflate(R.layout.xrecyc_adapter, parent,false);
        HoldView holdView=new HoldView(view);
        return holdView;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //position为Adapter的位置，数据从list里面可以拿出来。
//        String s=list.get(position);
//        ((HoldView)holder).textView.setText(s);
        HoldView holdView= (HoldView) holder;
        Glide.with(context).load(splendidlist.get(position).getImg()).into(holdView.live_xrecy_adapter_img);
        holdView.live_xrecy_adapter_time.setText(splendidlist.get(position).getLen());
        holdView.live_xrecy_adapter_date.setText(splendidlist.get(position).getPtime());
        holdView.live_xrecy_adapter_name.setText(splendidlist.get(position).getT());

        //条目数的接口回调
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jiekou.onclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return splendidlist.size();
    }
    private class HoldView extends RecyclerView.ViewHolder{
        private TextView live_xrecy_adapter_name,live_xrecy_adapter_date,live_xrecy_adapter_time;
        private ImageView live_xrecy_adapter_img;
        public HoldView(View itemView) {
            super(itemView);
            //根据onCreateViewHolder的HoldView所添加的xml布局找到空间
            //名字
            live_xrecy_adapter_name= (TextView) itemView.findViewById(R.id.live_xrecy_adapter_name);
            //日期
            live_xrecy_adapter_date= (TextView) itemView.findViewById(R.id.live_xrecy_adapter_date);
            //播放时间
            live_xrecy_adapter_time= (TextView) itemView.findViewById(R.id.live_xrecy_adapter_time);
            //展示图片
            live_xrecy_adapter_img = (ImageView) itemView.findViewById(R.id.live_xrecy_adapter_img);


        }
    }
}