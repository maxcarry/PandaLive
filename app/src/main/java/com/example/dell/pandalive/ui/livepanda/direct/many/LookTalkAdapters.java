package com.example.dell.pandalive.ui.livepanda.direct.many;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/3.
 */

public class LookTalkAdapters extends BaseAdapter {

    private Context context;
    private List<LookTalkBean.ListBean> list1=new ArrayList<LookTalkBean.ListBean>();

    public LookTalkAdapters(Context context, List<LookTalkBean.ListBean> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @Override
    public int getCount() {
        return list1.size();
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
        Hu hu;
        if (convertView==null){
            hu =new Hu();

            convertView=View.inflate(context, R.layout.look_adapterss,null);
            hu.look_name= (TextView) convertView.findViewById(R.id.look_name);
            hu.look_img= (ImageView) convertView.findViewById(R.id.look_img);

            convertView.setTag(hu);

        }else {
            hu= (Hu) convertView.getTag();
        }

        //图片
        Glide.with(context).load(list1.get(position).getImage()).into(hu.look_img);

        hu.look_img.setScaleType(ImageView.ScaleType.FIT_XY);

        hu.look_name.setText(list1.get(position).getTitle());

        return convertView;
    }
    static class Hu{
        TextView look_name;
        ImageView look_img;

    }


}

