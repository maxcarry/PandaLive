package com.example.dell.pandalive.ui.livepanda.modellive;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.pandalive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

public class LiveXRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Jiekou jiekou;
    private List<LiveBean> list = new ArrayList<>();
    private Context context;

    public LiveXRecyclerViewAdapter(Context context, List<LiveBean> list) {
        this.list = list;
        this.context = context;
    }

    public void setonclick(Jiekou jiekous) {
        this.jiekou = jiekous;
    }

    //接口
    public interface Jiekou {
        void onclick(int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //给Adapter添加布局，bq把这个view传递给HoldView，让HoldView找到空间
        View view = LayoutInflater.from(context).inflate(R.layout.live_xrecycler_adapter, parent, false);
        HoldView holdView = new HoldView(view);
        return holdView;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //position为Adapter的位置，数据从list里面可以拿出来。
//        String s = list.get(position);
            HoldView holdView= (HoldView) holder;
//        holdView.live_adapter_time
//        ((HoldView)holder).textView.setText(s);
        //setOnClickListener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jiekou.onclick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class HoldView extends RecyclerView.ViewHolder {
        //        private TextView textView;
        ImageView live_adapter_img;
        private final TextView live_adapter_time,
                                live_adapter_name,
                                live_adapter_date;

        public HoldView(View itemView) {
            super(itemView);
            //根据onCreateViewHolder的HoldView所添加的xml布局找到空间
//            textView= (TextView) itemView.findViewById(R.id.xrecyc_text);
            //视频图片
            live_adapter_img = (ImageView) itemView.findViewById(R.id.live_adapter_img);
            //播放时间
            live_adapter_time = (TextView) itemView.findViewById(R.id.live_adapter_time);
            //简介
            live_adapter_name = (TextView) itemView.findViewById(R.id.live_adapter_name);
            //日期
            live_adapter_date= (TextView) itemView.findViewById(R.id.live_adapter_date);

        }


    }


}
