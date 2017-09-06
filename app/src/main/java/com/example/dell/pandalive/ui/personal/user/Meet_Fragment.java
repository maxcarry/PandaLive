package com.example.dell.pandalive.ui.personal.user;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 张凯雅 on 2017/9/3.
 */

public class Meet_Fragment extends BaseFragment implements View.OnClickListener {

    private View view;
    private Button meet_submit_button;
    private Toast mToast;
    private EditText mEt_conact;
    private EditText mEt_content;
    private CheckBox mCB1;
    private CheckBox mCB2;
    private CheckBox mCB3;
    private CheckBox mCB4;
    private CheckBox mCB5;
    private CheckBox mCB6;

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
        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.fragment_meet, null);
        mCB1 = (CheckBox) view.findViewById(R.id.meet_cb1);
        mCB2 = (CheckBox) view.findViewById(R.id.meet_cb2);
        mCB3 = (CheckBox) view.findViewById(R.id.meet_cb3);
        mCB4 = (CheckBox) view.findViewById(R.id.meet_cb4);
        mCB5 = (CheckBox) view.findViewById(R.id.meet_cb5);
        mCB6 = (CheckBox) view.findViewById(R.id.meet_cb6);
        mEt_conact = (EditText) view.findViewById(R.id.meet_contact_edit);
        mEt_content = (EditText) view.findViewById(R.id.meet_contact_edit);
        meet_submit_button =(Button)view.findViewById(R.id.meet_submit_button);
        meet_submit_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.meet_submit_button:
                if (mToast != null) {
                    mToast.cancel();
                    mToast = null;
                }
                if(TextUtils.isEmpty(makeTypes())||TextUtils.isEmpty(mEt_conact.getText())){
                    String str = TextUtils.isEmpty(makeTypes())?"请选择问题类型！":"联系方式不能为空！";
                    {
                        mToast = Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                    return;
                }
                else{
                    if(!checkEmail()){
                        mToast = Toast.makeText(getActivity(),"邮箱格式不正确", Toast.LENGTH_SHORT);
                        mToast.show();
                        return;
                    }
                    String content = mEt_content.getText().toString();
                    if(null != meet_submit_button.getTag() && content.equals(meet_submit_button.getTag())){
                        mToast = Toast.makeText(getActivity(), "内容重复提交！", Toast.LENGTH_SHORT);
                        mToast.show();
                        return;
                    }
                    meet_submit_button.setTag(content);
//                    requestHisData();
                    meet_submit_button.setClickable(false);
                }
                meet_submit_button.setClickable(true);
                Toast.makeText(getActivity(), "提交成功！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //检查邮箱
    private boolean checkEmail(){
        String emailString  = mEt_conact.getText().toString().trim();
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(emailString);
        if(matcher.matches()){
            return true;
        }else {
            return false;
        }
    }

    private String makeTypes(){
        String types = "";
        if(mCB1.isChecked()){
            types += "1,";
        }
        if(mCB2.isChecked()){
            types += "2,";
        }
        if(mCB3.isChecked()){
            types += "3,";
        }
        if(mCB4.isChecked()){
            types += "4,";
        }
        if(mCB5.isChecked()){
            types += "5,";
        }
        if(mCB6.isChecked()){
            types += "6,";
        }
        return types;
    }
}
