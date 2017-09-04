package com.example.dell.pandalive.ui.personal.register;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.custom_view.CustomCode;

/**
 * Created by 贾成昆 on 2017/8/28.
 */

public class EmilsRegistFragment extends BaseFragment {


    private View view;
    private EditText emils_username;
    private EditText emils_pwd;
    private EditText emils_comfirm_pwd;
    private EditText emils_image_code;
    private CustomCode emils_image_custcode;
    private CheckBox emils_check;
    private Button emils_regist;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_emilsregist, null);
        emils_username = (EditText) view.findViewById(R.id.emils_username);
        emils_pwd = (EditText) view.findViewById(R.id.emils_pwd);
        emils_comfirm_pwd = (EditText) view.findViewById(R.id.emils_comfirm_pwd);
        emils_image_code = (EditText) view.findViewById(R.id.emils_image_code);
        emils_image_custcode = (CustomCode) view.findViewById(R.id.emils_image_custcode);
        emils_check = (CheckBox) view.findViewById(R.id.emils_check);
        emils_regist = (Button) view.findViewById(R.id.emils_regist);

        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_emilsregist,null);
    }
}
