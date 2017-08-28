package com.example.dell.pandalive.ui;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;

public class DebarkActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView debark_return_img;
    private TextView debark_enroll;
    private ImageView debark_thirdly_weixin;
    private ImageView debark_thirdly_qq;
    private ImageView debark_thirdly_weibo;
    private EditText debark_input_name;
    private EditText debark_input_pwd;
    private TextView debark_forget_pwd;
    private Button debark_landing;
    private TextView debark_ped_sky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        //返回图片
        debark_return_img = (ImageView) findViewById(R.id.debark_return_img);
        //注册
        debark_enroll = (TextView) findViewById(R.id.debark_enroll);
        //微信
        debark_thirdly_weixin = (ImageView) findViewById(R.id.debark_thirdly_weixin);
        //QQ
        debark_thirdly_qq = (ImageView) findViewById(R.id.debark_thirdly_qq);
        //微博
        debark_thirdly_weibo = (ImageView) findViewById(R.id.debark_thirdly_weibo);
        //输入账号debark_ped_sky
        debark_input_name = (EditText) findViewById(R.id.debark_input_name);
        //账号为空时显示
        debark_ped_sky = (TextView) findViewById(R.id.debark_ped_sky);
        //输入密码
        debark_input_pwd = (EditText) findViewById(R.id.debark_input_pwd);
        //忘记密码
        debark_forget_pwd = (TextView) findViewById(R.id.debark_forget_pwd);
        //登陆按钮
        debark_landing = (Button) findViewById(R.id.debark_landing);
        //忘记密码的下划线
        debark_forget_pwd.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
        debark_landing.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.debark_landing:

                break;
        }
    }

    private void submit() {
        // validate
        String name = debark_input_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "账号：请输入邮箱或手机号", Toast.LENGTH_SHORT).show();
            debark_ped_sky.setText("邮箱/手机号不能为空");
            return;
        }

        String pwd = debark_input_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}
