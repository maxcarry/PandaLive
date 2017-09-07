package com.example.dell.pandalive.ui.personal.setuser;

import android.app.Dialog;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.entity.UplodBean;
import com.example.dell.pandalive.utils.SharedUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 张凯雅 on 2017/9/4.
 */

public class Revise_Activity extends BaseActivity implements TextWatcher {

    private ImageView revise_back_imageview;
    private TextView updata_name;
    private EditText username_ed;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {
        revise_back_imageview =(ImageView)findViewById(R.id.revise_back_imageview);
        updata_name = (TextView) findViewById(R.id.updata_name);
        username_ed = (EditText) findViewById(R.id.username_ed);
        revise_back_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        username_ed.setText(getIntent().getStringExtra("username"));

        username_ed.addTextChangedListener(this);
    }

    @Override
    protected int initlayout() {
        return R.layout.revise_activity;
    }

    public void upload(String url, String name) {

        OkHttpClient client = new OkHttpClient();

        Log.e(">>>>>>>>>>>>>>>>>>>>>", "upload: "+url+"&nickname="+name );
        Request build = new Request.Builder().url(url+"&nickname="+name).build();

        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Revise_Activity.this, "提交失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Gson gson = new Gson();
                UplodBean bean = gson.fromJson(response.body().string(), UplodBean.class);
                Log.e("修改用户名", "onResponse: "+bean.getCode()+bean.getError() );
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ShowDialog();
                    }
                });

            }
        });
    }

    public void ShowDialog(){

        View view = LayoutInflater.from(Myapp.activity).inflate(R.layout.updata_dialog, null);
        final Dialog dialog = new Dialog(Myapp.activity);
        dialog.setContentView(view);
        TextView te = (TextView) view.findViewById(R.id.dialog_te);
        te.setText("您的昵称已提交审核\n\n请稍后回来确认吧");
        TextView bt = (TextView) view.findViewById(R.id.sure_bt);
        dialog.show();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });


    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        updata_name.setTextColor(Color.WHITE);
    }

    @Override
    public void afterTextChanged(Editable s) {

        if (s.length() <= 0) {
            updata_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Revise_Activity.this, "设置用户昵称不能为空", Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }
        if (s.length() < 3 || s.length() > 10) {
            updata_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Revise_Activity.this, "用户昵称不符合规范", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            updata_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s = username_ed.getText().toString();
                    String url = "http://my.cntv.cn/intf/napi/api.php?client=ipanda_mobile&method=user.alterUserFace&userid=";
                    upload(url+ SharedUtil.instance().getUserId(), s);
                }
            });
        }
    }
}
