package com.example.dell.pandalive.ui.personal.register.phoneregister;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.personal.register.phoneregister.presenter.PhonePresenter;
import com.example.dell.pandalive.utils.DialogUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dell on 2017/8/28.
 */

public class PhoneRegFragment extends BaseFragment implements View.OnClickListener ,IPhoneView{
    private View view;
    private EditText username_phone;
    private EditText code_image;
    private ImageView getcode_view;
    private EditText code_phone;
    private Button getcode_bt;
    private EditText password_phone;
    private CheckBox protocol_check;
    private Button register_phone;
    private PhonePresenter phonePresenter;

    @Override
    protected void restartdata() {

    }

    @Override
    protected void initdata() {

        getimacode();
    }

    @Override
    protected View initlayout() {
        return view;
    }

    @Override
    protected void initview() {

        view = LayoutInflater.from(Myapp.activity).inflate(R.layout.phone_register, null);
        phonePresenter = new PhonePresenter(this);

        username_phone = (EditText) view.findViewById(R.id.username_phone);
        code_image = (EditText) view.findViewById(R.id.code_image);
        getcode_view = (ImageView) view.findViewById(R.id.getcode_view);
        code_phone = (EditText) view.findViewById(R.id.code_phone);
        getcode_bt = (Button) view.findViewById(R.id.getcode_bt);
        password_phone = (EditText) view.findViewById(R.id.password_phone);
        protocol_check = (CheckBox) view.findViewById(R.id.protocol_check);
        register_phone = (Button) view.findViewById(R.id.register_phone);

        getcode_view.setScaleType(ImageView.ScaleType.FIT_XY);

        getcode_view.setOnClickListener(this);
        getcode_bt.setOnClickListener(this);
        register_phone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getcode_bt:

                Toast.makeText(Myapp.activity, "请求", Toast.LENGTH_SHORT).show();
                phonePresenter.GetCode(username_phone.getText().toString().trim(),code_image.getText().toString().trim());
                break;
            case R.id.register_phone:

                break;

            case R.id.getcode_view:

                getimacode();
                break;
        }
    }

    private void getimacode() {

        DialogUtil.instance().Showdialog(Myapp.activity);
        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();

        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                final Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());

                Myapp.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        getcode_view.setImageBitmap(bitmap);
                        DialogUtil.instance().Hidedialog();
                    }
                });
            }
        });
    }

    @Override
    public void SendCode(String msg) {

        Toast.makeText(Myapp.activity, msg, Toast.LENGTH_SHORT).show();

    }
}
