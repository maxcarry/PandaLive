package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.ChinaBean;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/8/29.
 */

public class ColumnCutAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<ChinaBean.TablistBean> list;
    private cut_Iface cutiface;
    public boolean imafly = true;

    public void getIface(cut_Iface cutiface) {
        this.cutiface = cutiface;
    }

    public ColumnCutAdapter(Context context, List<ChinaBean.TablistBean> list) {
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.e(TAG, "onBindViewHolder: "+list.get(position).getTitle() );
        final Myholder ho = (Myholder) holder;
        ho.position = position;
        ho.cut_te_item.setText(list.get(position).getTitle());
        ho.cut_te_item.setTextColor(Color.BLACK);

        ho.cut_te_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (cutiface != null) {
                    cutiface.LongCheck(ho);
                }

                return true;
            }
        });

        if (imafly) {
            ho.cut_ima_item.setVisibility(View.GONE);
        } else {
            ho.cut_ima_item.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myholder extends RecyclerView.ViewHolder {

        TextView cut_te_item;
        ImageView cut_ima_item;
        int position;
        public Myholder(final View itemView) {
            super(itemView);

            cut_te_item = (TextView) itemView.findViewById(R.id.cut_te_item);
            cut_ima_item = (ImageView) itemView.findViewById(R.id.cut_ima_item);

            cut_te_item.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return imafly;
                }
            });

            cut_te_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (list.size() <= 4) {
                        Toast.makeText(context, "栏目区不能小于四个频道", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (cutiface != null) {
                        cutiface.CutonClick(itemView,position);
                    }
                }
            });
        }
    }

    public interface cut_Iface{

        void LongCheck(RecyclerView.ViewHolder vh);

        void CutonClick(View view,int position);
    }

}
