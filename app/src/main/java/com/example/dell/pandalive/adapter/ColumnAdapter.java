package com.example.dell.pandalive.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.entity.ChinaUriBean;
import com.example.dell.pandalive.entity.ColumnBean;
import com.example.dell.pandalive.entity.HintContentBean;
import com.example.dell.pandalive.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * Created by dell on 2017/8/28.
 */

public class ColumnAdapter extends BaseAdapter {

    private Context context;
    private List<ColumnBean.LiveBean> list;
    private String pathid;
    ArrayList<HintContentBean> flylist = new ArrayList<>();

    public ColumnAdapter(Context context, List<ColumnBean.LiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder ho;
        flylist.add(new HintContentBean(1));
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
            ho = new ViewHolder(convertView);
            convertView.setTag(ho);
        } else {
            ho = (ViewHolder) convertView.getTag();
        }

        if (list.get(position).getId() != null) {

            pathid = "pa://cctv_p2p_hd" + list.get(position).getId();
            RetrofitUtil.instance("").Webchinaplay(new Observer() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Object value) {

                    ChinaUriBean bean = (ChinaUriBean) value;
                    ho.videoplayer_item.setUp(bean.getHls_url().getHls1()
                            , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);
                }

                @Override
                public void onError(Throwable e) {

                    Log.e(TAG, "onError: 请求错误视频" );
                }

                @Override
                public void onComplete() {

                }
            },"http://vdn.live.cntv.cn/api2/live.do"+"?"+"channel"+"="+pathid+"&"+"client"+"androidapp");

        }

        ho.videoplayer_item.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4"
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL);

        if (Util.isOnMainThread()) {
            try {

                Glide.with(context).load(list.get(position).getImage()).into(ho.videoplayer_item.thumbImageView);
            } catch (Exception e) {

            }
        }

        if (flylist.get(position).getFly() == 1) {
            ho.spread_ima_item.setChecked(false);
        } else {
            ho.spread_ima_item.setChecked(true);
        }

        if (ho.spread_ima_item.isChecked()) {
            ho.brief_ln.setVisibility(View.VISIBLE);
        } else {
            ho.brief_ln.setVisibility(View.GONE);
        }

        ho.brief_te.setText(list.get(position).getBrief());
        ho.title_item.setText("正在直播  "+list.get(position).getTitle());
        ho.spread_ima_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flylist.get(position).setFly(2);
                if (flylist.get(position).getFly() == 2) {
                    ho.spread_ima_item.setChecked(true);
                } else {
                    ho.spread_ima_item.setChecked(false);
                }

                if (ho.spread_ima_item.isChecked()) {
                    if (ho.brief_ln.getVisibility() != View.VISIBLE) {
                        ho.brief_ln.setVisibility(View.VISIBLE);
                    } else {
                        flylist.get(position).setFly(1);
                        ho.spread_ima_item.setChecked(false);
                        ho.brief_ln.setVisibility(View.GONE);
                    }
                }
                }
        });
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public JCVideoPlayerStandard videoplayer_item;
        public TextView title_item;
        public CheckBox spread_ima_item;
        public TextView brief_te;
        public LinearLayout brief_ln;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.videoplayer_item = (JCVideoPlayerStandard) rootView.findViewById(R.id.videoplayer_item);
            this.title_item = (TextView) rootView.findViewById(R.id.title_item);
            this.spread_ima_item = (CheckBox) rootView.findViewById(R.id.spread_ima_item);
            this.brief_te = (TextView) rootView.findViewById(R.id.brief_te);
            this.brief_ln = (LinearLayout) rootView.findViewById(R.id.brief_ln);


        }

    }
}
