package com.example.dell.pandalive.ui.livepanda.Livemain;


import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.livepanda.direct.directinterface.ListviewBean;
import com.example.dell.pandalive.ui.livepanda.direct.directinterface.MyMultiAdapter;
import com.example.dell.pandalive.ui.livepanda.direct.many.LookTalkAdapters;
import com.example.dell.pandalive.ui.livepanda.direct.many.LookTalkBean;
import com.example.dell.pandalive.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 熊猫直播
 */
public class LiveDirectFragment extends BaseFragment implements ILiveDirectFragment{


    boolean isChanged = false;

    private View view;
    private ImageView live_play_img;
    private TextView live_plau_introduce;
    private RelativeLayout live_play_relative;

//    ArrayList<String> livedirecttag = new ArrayList<String>();
//    ArrayList<Fragment> livedirectfraglist = new ArrayList<Fragment>();
//    private NoScrollViewPager live_plau_viewpager;
//    private TabLayout live_plau_tablelayout;
    private Button look_but1;
    private Button look_but2;
    private TextView look_but1_text1;
    private TextView look_but2_text2;
    private GridView look_but1_gridview;
    private EditText look_but2_edittext;
    private Button look_but2_but2;
    private ListView look_but1_listview;
    private LiveDirectPresenter liveDirectPresenter;
    List<ListviewBean>looklist=new ArrayList<ListviewBean>();
    int a=0;
    private MyMultiAdapter myMultiAdapter;
    private List<LookTalkBean.ListBean> list;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {
        DialogUtil.instance().Showdialog(Myapp.activity);
        liveDirectPresenter.ShowPerform();
        liveDirectPresenter.SentLook();
        DialogUtil.instance().Hidedialog();

    }


    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_live_direct, null);
//       //找id
        getid();
//        //箭头图标监听
        getmonitor();
//        initData();


        myMultiAdapter = new MyMultiAdapter(getActivity(),looklist);
        look_but1_listview.setAdapter(myMultiAdapter);
    }

  /*  private void initData() {

//        LookTalkFragment lookTalkFragment = new
        //添加Fragment

        //MultiAngleFragment 多视角直播
        livedirectfraglist.add(new LookTalkFragment());
        //LookTalkFragment 边看边聊
//        livedirectfraglist.add(new MultiAngleFragment());

    }
*/
    @Override
    public void livemainBean(List<LiveMainBean> liveBeen) {
//        List<LiveMainBean> liveBeen2 = liveBeen;
//        List<LiveMainBean.LiveBean> live = liveBeen2.get(0).getLive();
//
//        //视频播放的数据
//        List<LiveMainBean.LiveBean> liveBeen1 = live;



    }

    @Override
    public void lookBean(List<LookTalkBean> lookTalkBean) {
        //九宫格
        List<LookTalkBean> lookTalkBeen=lookTalkBean;
        for (int i = 0; i <lookTalkBeen.size() ; i++) {
            list = lookTalkBeen.get(i).getList();
            LookTalkAdapters lookTalkAdapters=new LookTalkAdapters(getActivity(),list);

            look_but1_gridview.setAdapter(lookTalkAdapters);
            look_but1_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getActivity(),"点击第了"+i+"个直播",Toast.LENGTH_LONG).show();
                }
            });
        }

    }

    //箭头隐藏文字
    private void getmonitor() {
        live_play_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == live_play_relative) {

                    if (isChanged) {

                        live_play_img.setImageDrawable(getResources().getDrawable(R.mipmap.lpanda_show));

                        live_plau_introduce.setVisibility(View.GONE);
                        //隐藏文字
                    } else {
                        live_play_img.setImageDrawable(getResources().getDrawable(R.mipmap.lpanda_off));
                        //显示文字
                        live_plau_introduce.setVisibility(View.VISIBLE);
                    }
                    isChanged = !isChanged;


                }

                }
        });
    }

    private void getid() {
        //介绍小三角图标
        live_play_img = (ImageView) view.findViewById(R.id.live_play_img);

        liveDirectPresenter = new LiveDirectPresenter(this);


        //介绍（文字）
        live_plau_introduce = (TextView) view.findViewById(R.id.live_plau_introduce);
        live_play_relative = (RelativeLayout) view.findViewById(R.id.live_play_relative);

        look_but1 = (Button) view.findViewById(R.id.look_but1);
        look_but2 = (Button) view.findViewById(R.id.look_but2);
        look_but1_text1 = (TextView) view.findViewById(R.id.look_but1_text1);
        look_but2_text2 = (TextView)view. findViewById(R.id.look_but2_text2);
        look_but1_gridview = (GridView)view. findViewById(R.id.look_but1_gridview);
        look_but2_edittext = (EditText) view.findViewById(R.id.look_but2_edittext);
        look_but2_but2 = (Button) view.findViewById(R.id.look_but2_but2);
        look_but1_listview = (ListView) view.findViewById(R.id.look_but1_listview);

        getjudgment();


    }




    private void getjudgment() {
        //多视角直播
        look_but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                look_but1_text1.setVisibility(View.VISIBLE);
                look_but1_gridview.setVisibility(view.VISIBLE);
              /*隐藏*/
                //红线
                look_but2_text2.setVisibility(View.INVISIBLE);
                //输入框
                look_but2_edittext.setVisibility(View.GONE);
                //确认按钮
                look_but2_but2.setVisibility(View.GONE);
                //listview
                look_but1_listview.setVisibility(View.GONE);





            }
        });
        //边看边聊
        look_but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //红线
                look_but2_text2.setVisibility(View.VISIBLE);
                //输入框
                look_but2_edittext.setVisibility(View.VISIBLE);
                //确认按钮
                look_but2_but2.setVisibility(View.VISIBLE);
                //listview
                look_but1_listview.setVisibility(View.VISIBLE);
                /*隐藏*/
                look_but1_text1.setVisibility(View.INVISIBLE);

                look_but1_gridview.setVisibility(view.GONE);

            }
        });
        //发送按钮
        look_but2_but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                String comment = look_but2_edittext.getText().toString().trim();
                if (TextUtils.isEmpty(comment)) {
                    Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }

                SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MM-yyyy ");
                String date = sDateFormat.format(new java.util.Date());

                ListviewBean listviewBean = new ListviewBean();

                listviewBean.setShijian(date);
                listviewBean.setLoushu(a+"楼");
                listviewBean.setReirong(comment);
                looklist.add(0, listviewBean);
                myMultiAdapter.notifyDataSetChanged();
                look_but2_edittext.setText("");
            }
        });
    }



}
