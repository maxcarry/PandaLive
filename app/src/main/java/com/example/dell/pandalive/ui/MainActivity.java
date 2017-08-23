package com.example.dell.pandalive.ui;


import android.Manifest;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.ui.eyepanda.EyeFragment;
import com.example.dell.pandalive.ui.home.HomeFragment;
import com.example.dell.pandalive.ui.livechina.ChinaFragment;
import com.example.dell.pandalive.ui.livepanda.LiveFragment;
import com.example.dell.pandalive.ui.videopanda.VideoFragment;
import com.example.dell.pandalive.utils.Netwoke;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    //网络状态工具类
    private Netwoke netwoke;
    //退出时的时间
    private long mExitTime;
    private RadioButton home_radiobt;
    private RadioButton live_radiobt;
    private RadioButton video_radiobt;
    private RadioButton eye_radiobt;
    private RadioButton china_radiobt;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] tags = new String[]{"home", "live", "video", "eye","china"};
    private Fragment fhome,flive,fvideo,feye,fchina,mfragment;
    private FragmentManager fm;
    // 所需的全部权限
    static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };



    @Override
    protected void initdata() {

        getnetwoke();
    }

    @Override
    protected void initview() {

        setPermissions();

        home_radiobt = (RadioButton) findViewById(R.id.home_radiobt);
        live_radiobt = (RadioButton) findViewById(R.id.live_radiobt);
        video_radiobt = (RadioButton) findViewById(R.id.video_radiobt);
        eye_radiobt = (RadioButton) findViewById(R.id.eye_radiobt);
        china_radiobt = (RadioButton) findViewById(R.id.china_radiobt);

        home_radiobt.setOnClickListener(this);
        live_radiobt.setOnClickListener(this);
        video_radiobt.setOnClickListener(this);
        eye_radiobt.setOnClickListener(this);
        china_radiobt.setOnClickListener(this);

        init();
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }


    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }


    //判断网络状态
    private void getnetwoke() {

        if (netwoke == null) {
            netwoke = new Netwoke();
        }

        String getnetwoke = netwoke.getnetwoke(MainActivity.this);

        Toast.makeText(MainActivity.this, getnetwoke, Toast.LENGTH_SHORT).show();

        if (getnetwoke.equals("网络无连接")) {
            setNetwork();
        }
    }

    private void setNetwork() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.mipmap.ic_launcher);

        builder.setTitle("无法连接网络");

        builder.setMessage("网络不可用，如果继续，请先设置网络！");

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Intent intent = null;

                /**

                 * 判断手机系统的版本！如果API大于10 就是3.0+

                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同

                 */

                if (Build.VERSION.SDK_INT > 10) {

                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);

                } else {

                    intent = new Intent();

                    ComponentName component = new ComponentName(

                            "com.android.settings",

                            "com.android.settings.WirelessSettings");

                    intent.setComponent(component);

                    intent.setAction("android.intent.action.VIEW");

                }

                startActivity(intent);

            }

        });

        builder.setNegativeButton("我是穷逼", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this, "兄弟,没网怎么玩,搞不懂你", Toast.LENGTH_SHORT).show();

            }

        });

        builder.create();

        builder.show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.home_radiobt:

                switchfragment(mfragment,fragments.get(0),0);
                break;
            case R.id.live_radiobt:

                switchfragment(mfragment,fragments.get(1),1);
                break;
            case R.id.video_radiobt:

                switchfragment(mfragment,fragments.get(2),2);
                break;
            case R.id.eye_radiobt:

                switchfragment(mfragment,fragments.get(3),3);
                break;
            case R.id.china_radiobt:

                switchfragment(mfragment,fragments.get(4),4);
                break;
        }
    }

    private void init() {

        fm = getSupportFragmentManager();

        fhome = new HomeFragment();
        flive = new LiveFragment();
        fvideo = new VideoFragment();
        feye = new EyeFragment();
        fchina = new ChinaFragment();
        fragments.add(fhome);
        fragments.add(flive);
        fragments.add(fvideo);
        fragments.add(feye);
        fragments.add(fchina);
        mfragment = fhome;

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fm_show, mfragment);
        ft.commitAllowingStateLoss();
        home_radiobt.setChecked(true);
    }

    //切换碎片的方法
    private void switchfragment(Fragment from, Fragment to, int position) {

        if (mfragment != to) {

            mfragment = to;
            FragmentTransaction ft = fm.beginTransaction();

            if (!to.isAdded()) {
                ft.hide(from).add(R.id.fm_show, to, tags[position]).commitAllowingStateLoss();
            } else {
                ft.hide(from).show(to).commitAllowingStateLoss();
            }
        }
    }

    private void setPermissions() {

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //Android 6.0申请权限
            ActivityCompat.requestPermissions(this,PERMISSION,1);
        }else{

        }
    }
}
