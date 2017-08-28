package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.InteractListViewBean;

import java.util.List;

/**
 * Created by 张凯雅 on 2017/8/25.
 */

/**
 * 原创互动
 */
public class InteractListViewAdapter extends BaseAdapter {
    private Context context;
    private List<InteractListViewBean.InteractiveBean> listViewBeen;

    public InteractListViewAdapter(Context context, List<InteractListViewBean.InteractiveBean> listViewBeen) {
        this.context = context;
        this.listViewBeen = listViewBeen;
    }

    @Override
    public int getCount() {
        return listViewBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.interact_listview_item,null);
            holder=new ViewHolder();
            holder.listview_title_imageview= (TextView) convertView.findViewById(R.id.listview_title_imageview);
            holder.listview_image_imageview= (ImageView) convertView.findViewById(R.id.listview_image_imageview);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.listview_title_imageview.setText(listViewBeen.get(position).getTitle());
        Glide.with(context).load(listViewBeen.get(position).getImage()).into(holder.listview_image_imageview);
        return convertView;
        }
    class ViewHolder{
        TextView listview_title_imageview;
        ImageView listview_image_imageview;
    }
}
