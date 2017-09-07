package com.example.dell.pandalive.ui.personal.user;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseActivity;

import java.util.ArrayList;

/**
 * Created by 张凯雅 on 2017/9/3.
 */

public class User_Activity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageView user_back_imageview;
    private ViewPager mViewPager;
    private RadioButton mRb_left;
    private RadioButton mRb_right;
    private ArrayList<Fragment> mListFragment;


    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        user_back_imageview =(ImageView)findViewById(R.id.user_back_imageview);
        user_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.user_content_viewpager);
        mRb_left = (RadioButton) findViewById(R.id.user_rb_left);
        mRb_right = (RadioButton) findViewById(R.id.user_rb_right);

        mRb_left.setOnClickListener(this);
        mRb_right.setOnClickListener(this);

        mRb_right.getPaint().setFakeBoldText(true);
        mRb_left.getPaint().setFakeBoldText(true);

        mListFragment = new ArrayList<Fragment>();
        mListFragment.add(new Meet_Fragment());
        mListFragment.add(new Common_Fragment());
        mViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(2);
        mRb_left.setChecked(true);
        refreshRadioButton();

    }

    @Override
    protected int initlayout() {
        return R.layout.user_activity;
    }

    class MyFragmentAdapter extends FragmentStatePagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mListFragment.get(position);
        }

        @Override
        public int getCount() {
            return mListFragment.size();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_rb_left:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.user_rb_right:
                mViewPager.setCurrentItem(1);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch(position){
            case 0:
                mRb_left.setChecked(true);
                break;
            case 1:
                mRb_right.setChecked(true);
                break;
        }
        refreshRadioButton();

    }

    public void refreshRadioButton(){

        Drawable bottom = getResources().getDrawable(R.drawable.custom_tab_indicator_selected2);
        bottom.setBounds(0, 0, getResources().getDisplayMetrics().widthPixels/2, bottom.getMinimumHeight());//必须设置图片大小，否则不显示
        if(mRb_left.isChecked())
        {
            mRb_left.setCompoundDrawables(null, null, null, bottom);
            mRb_left.setTextColor(Color.parseColor("#1E539C"));

            mRb_right.setCompoundDrawables(null, null, null, null);
            mRb_right.setTextColor(Color.BLACK);
        }
        else
        {
            mRb_right.setCompoundDrawables(null, null, null, bottom);
            mRb_right.setTextColor(Color.parseColor("#1E539C"));

            mRb_left.setCompoundDrawables(null, null, null, null);
            mRb_left.setTextColor(Color.BLACK);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                hideKeyboard(v.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击EditText的事件，忽略它。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     * @param token
     */
    private void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
