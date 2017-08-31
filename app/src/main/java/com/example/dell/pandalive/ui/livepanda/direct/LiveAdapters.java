package com.example.dell.pandalive.ui.livepanda.direct;

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
 * Created by Administrator on 2017/8/31.
 */

public class LiveAdapters extends BaseAdapter {

    private Context context;
    private List<LiveDirectLiveBean> liveDirectbeanlist = new ArrayList<LiveDirectLiveBean>();

    public LiveAdapters(Context context, List<LiveDirectLiveBean> list1) {
        this.context = context;
        this.liveDirectbeanlist = list1;
    }

    @Override
    public int getCount() {
        return liveDirectbeanlist.size();
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
        if (convertView == null) {
            hu = new Hu();

            convertView = View.inflate(context, R.layout.live_direct_item, null);//live_direct_adapter_name
            hu.live_direct_adapter_name = (TextView) convertView.findViewById(R.id.live_direct_adapter_name);
            hu.live_xrecy_adapter_img = (ImageView) convertView.findViewById(R.id.live_xrecy_adapter_img);


            convertView.setTag(hu);

        } else {
            hu = (Hu) convertView.getTag();
        }
        hu.live_direct_adapter_name.setText(liveDirectbeanlist.get(position).getList().get(position).getTitle());
        Glide.with(context).load(liveDirectbeanlist.get(position).getList().get(position).getImage()).into(hu.live_xrecy_adapter_img);

        return convertView;
    }

    static class Hu {


        ImageView live_xrecy_adapter_img;
        TextView live_direct_adapter_name;
    }


}
