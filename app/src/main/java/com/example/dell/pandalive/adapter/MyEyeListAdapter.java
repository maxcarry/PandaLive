package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.EyeListBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/26.
 */

public class MyEyeListAdapter extends BaseAdapter {
    private Context context;
    private List<EyeListBean.ListBean> listBean;

    public MyEyeListAdapter(Context context, List<EyeListBean.ListBean> listBean) {
        this.context = context;
        this.listBean = listBean;
    }

    @Override
    public int getCount() {
        return listBean.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EyeListViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.eye_listview_item,null);
            viewHolder=new EyeListViewHolder();
            viewHolder.eyelist_picture_imageview= (ImageView) convertView.findViewById(R.id.eyelist_picture_imageview);
            viewHolder.eyelist_title_textview= (TextView) convertView.findViewById(R.id.eyelist_title_textview);
            viewHolder.eyelist_time_textview= (TextView) convertView.findViewById(R.id.eyelist_time_textview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (EyeListViewHolder) convertView.getTag();
        }
        viewHolder.eyelist_title_textview.setText(listBean.get(position).getTitle());
        Glide.with(context).load(listBean.get(position).getPicurl()).into(viewHolder.eyelist_picture_imageview);
        viewHolder.eyelist_time_textview.setText(listBean.get(position).getFocus_date()+"");

        //转化为年月日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String format = sdf.format(listBean.get(position).getFocus_date());
        viewHolder.eyelist_time_textview.setText(format);

        return convertView;
    }


    class EyeListViewHolder {
        ImageView eyelist_picture_imageview;
        TextView eyelist_title_textview;
        TextView eyelist_time_textview;
    }
}
