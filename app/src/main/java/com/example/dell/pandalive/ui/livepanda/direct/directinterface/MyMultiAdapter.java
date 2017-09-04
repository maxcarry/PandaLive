package com.example.dell.pandalive.ui.livepanda.direct.directinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.pandalive.R;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class MyMultiAdapter extends BaseAdapter {

    private Context context;
    private List<ListviewBean> performBeen;

    public MyMultiAdapter(Context context,  List<ListviewBean> performBeen) {

        this.context = context;
        this.performBeen = performBeen;
    }

    @Override
    public int getCount() {
        return performBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return performBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Myholder ho;
        if (convertView == null) {
            ho = new Myholder();

            convertView = LayoutInflater.from(context).inflate(R.layout.live_multi_items, null);
            ho.live_textview = (TextView) convertView.findViewById(R.id.live_textview);
             ho.live_time = (TextView) convertView.findViewById(R.id.live_time);
             ho.live_text = (TextView) convertView.findViewById(R.id.live_text);



            convertView.setTag(ho);
        } else {
            ho = (Myholder) convertView.getTag();
        }

        //介绍
        ho.live_textview.setText(performBeen.get(position).getReirong());

  //时间
        ho.live_time.setText(performBeen.get(position).getShijian());

  //楼书
        ho.live_text.setText(performBeen.get(position).getLoushu());


        return convertView;
    }

    private class Myholder{


        TextView live_textview
                ,live_time
        ,live_text;
    }
}

/*<!--
live_time   时间

live_text   几楼
-->*/