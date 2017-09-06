package com.example.dell.pandalive.ui.personal.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.HistoryBean;

import java.util.List;


////* convertView=View.inflate(context, R.layout.history_adapters_item,null);*/
public class HistoryAdapters extends BaseAdapter {

    private Context mContext;

    private List<HistoryBean> mDatas;

    private LayoutInflater mInflater;

    public boolean flage = false;


    public HistoryAdapters(Context mContext, List<HistoryBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;

        mInflater = LayoutInflater.from(this.mContext);

    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (convertView == null) {
            // 下拉项布局
//            convertView = mInflater.inflate(R.layout.history_adapters_item, null);

            convertView = mInflater.inflate(R.layout.histoty_adapters_data, null);

            holder = new ViewHolder();

            holder.checkboxOperateData = (CheckBox) convertView.findViewById(R.id.checkbox_operate_data);
            holder.material_item_img=(ImageView) convertView.findViewById(R.id.material_item_img);
            holder.textTitle = (TextView) convertView.findViewById(R.id.text_title);



            holder.textDesc = (TextView) convertView.findViewById(R.id.text_desc);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        final HistoryBean dataBean = mDatas.get(position);
        if (dataBean != null) {
//http://p4.img.cctvpic.com/fmspic/2017/08/24/9668c35873f447278bf1fc9285fed95a-50.jpg?p=2&h=120
            //图片
            Glide.with(mContext).load(dataBean.historyimg).into(holder.material_item_img);
//            holder.material_item_img.setImageResource(dataBean.img);
            //名字
            holder.textTitle.setText(dataBean.historytitle);
            //简介
            holder.textDesc.setText(dataBean.getHistorydesc());
            //播放时间
            holder.time.setText(dataBean.historytimes);

            // 根据isSelected来设置checkbox的显示状况
            if (flage) {
                holder.checkboxOperateData.setVisibility(View.VISIBLE);
            } else {
                holder.checkboxOperateData.setVisibility(View.GONE);
            }

            holder.checkboxOperateData.setChecked(dataBean.historyisCheck);

            //注意这里设置的不是onCheckedChangListener，还是值得思考一下的
            holder.checkboxOperateData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dataBean.historyisCheck) {
                        dataBean.historyisCheck = false;
                    } else {
                        dataBean.historyisCheck = true;
                    }
                }
            });
        }
        return convertView;
    }

    class ViewHolder {

        public CheckBox checkboxOperateData;

        public TextView textTitle;

        public TextView text_desc;
        public TextView textDesc;
        public TextView time;
        public ImageView material_item_img;



    }
}

