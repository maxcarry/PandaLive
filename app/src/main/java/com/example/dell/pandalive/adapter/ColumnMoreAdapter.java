package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.ChinaBean;

import java.util.List;

/**
 * Created by dell on 2017/8/29.
 */

public class ColumnMoreAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<ChinaBean.AlllistBean> list;
    private more_Iface iface;
    public static boolean moretouch = true;

    public void getmore(more_Iface iface) {
        this.iface = iface;
    }

    public ColumnMoreAdapter(Context context, List<ChinaBean.AlllistBean> list) {
        this.context = context;
        this.list = list;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.column_cut_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        final Myholder ho = (Myholder) holder;
        ho.position = position;
        ho.more_te_item.setVisibility(View.VISIBLE);
        ho.more_te_item.setText(list.get(position).getTitle());
        ho.more_te_item.setTextColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myholder extends RecyclerView.ViewHolder {

        TextView more_te_item;
        int position;
        public Myholder(final View itemView) {
            super(itemView);

            more_te_item = (TextView) itemView.findViewById(R.id.cut_te_item);
            more_te_item.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return moretouch;
                }
            });
            more_te_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iface != null) {
                        iface.Onclickmore(itemView,position);

                    }
                }
            });
        }
    }

    public interface more_Iface{

        void Onclickmore(View view,int position);
    }
}
