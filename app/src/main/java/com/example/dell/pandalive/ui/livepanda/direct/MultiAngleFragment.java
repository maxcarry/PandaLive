package com.example.dell.pandalive.ui.livepanda.direct;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.direct.directinterface.ListviewBean;
import com.example.dell.pandalive.ui.livepanda.direct.directinterface.MyMultiAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 */

public class MultiAngleFragment extends BaseFragment {
    List<ListviewBean> list = new ArrayList<>();
    private View view;
    private ListView live_multi_listview;
    private EditText live_listview_edittext;
    private Button live_listview_send;
    private MyMultiAdapter myMultiAdapter;
    int a = 0;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.live_direct_multis, null);
//        live_multi_listview = (ListView) view.findViewById(R.id.live_multi_listview);
//        live_listview_edittext = (EditText) view.findViewById(R.id.live_listview_edittext);
//        live_listview_send = (Button) view.findViewById(R.id.live_listview_send);
//
//
//        live_listview_send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                a++;
//                String comment = live_listview_edittext.getText().toString().trim();
//                if (TextUtils.isEmpty(comment)) {
//                    Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//
//                SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MM-yyyy ");
//                String date = sDateFormat.format(new java.util.Date());
//
//                ListviewBean listviewBean = new ListviewBean();
//
//                listviewBean.setShijian(date);
//                listviewBean.setLoushu(a+"楼");
//                listviewBean.setReirong(comment);
//                list.add(0, listviewBean);
//                myMultiAdapter.notifyDataSetChanged();
//                live_listview_edittext.setText("");
//            }
//        });
//
//
        myMultiAdapter = new MyMultiAdapter(getActivity(), list);
//
//
//        live_multi_listview.setAdapter(myMultiAdapter);


    }
}
