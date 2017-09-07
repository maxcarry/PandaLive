package com.example.dell.pandalive.ui.personal.register.phoneregister;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseFragment;
import com.example.dell.pandalive.ui.personal.register.phoneregister.presenter.PhonePresenter;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.Netwoke;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

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
    private String JSESSIONID = null;
    private int tim = 180;
    private boolean or = false;
    private TextView hint_phone;
    private TextView hint_imagecheck;
    private TextView hint_phonecheck;
    private TextView hint_surepawd;
    private TextView hint_xieyi;

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
        hint_phone = (TextView) view.findViewById(R.id.hint_phone);
        hint_imagecheck = (TextView) view.findViewById(R.id.hint_imagecheck);
        hint_phonecheck = (TextView) view.findViewById(R.id.hint_phonecheck);
        hint_surepawd = (TextView) view.findViewById(R.id.hint_surepawd);
        hint_xieyi = (TextView) view.findViewById(R.id.hint_xieyi);


        getcode_view.setScaleType(ImageView.ScaleType.FIT_XY);

        getcode_bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return or;
            }
        });
        getcode_view.setOnClickListener(this);
        getcode_bt.setOnClickListener(this);
        register_phone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getcode_bt:

                String username = username_phone.getText().toString().trim();
                String code_ima = code_image.getText().toString().trim();

                phonePresenter.GetCode(username,code_ima,JSESSIONID);
                break;
            case R.id.register_phone:

                if (getnetwoke()) {
                    Toast.makeText(Myapp.activity, "网络无连接", Toast.LENGTH_SHORT).show();
                    return;
                }

                //点击注册
                if (!checkPhone()) {
                    return;
                }


                if (!checkCaptcha()) {
                    return;
                }

                if (!checkPhoneCheck()) {

                    return;
                }
                if (!checkPasswork()) {
                    return;
                }


                if (!checkXieyi()) {
                    return;
                }

                String tPhoneNumber = username_phone.getText().toString().trim();
                String tCheckPhone = code_phone.getText().toString().trim();
                String tPassWord = password_phone.getText().toString();
                Map<String, String> map = new HashMap<>();
                map.put("method", "saveMobileRegisterM");
                map.put("mobile", tPhoneNumber);
                map.put("verfiCode", tCheckPhone);
                try {
                    map.put("passWd", URLEncoder.encode(tPassWord, "UTF-8"));
                    map.put("verfiCodeType", "1");
                    map.put("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                phonePresenter.Register(map);
                break;

            case R.id.getcode_view:

                getimacode();
                break;
        }
    }

    private void getimacode() {

        DialogUtil.instance().Showdialog(Myapp.activity);

        CookieJar cookieJar = new CookieJar() {

            List<Cookie> cookies_c = new ArrayList<Cookie>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookies_c = cookies;

                for (Cookie cookie : cookies_c) {
                    Log.e(TAG, "saveFromResponse: 这是cookieName====="+cookie.name() );
                    Log.e(TAG, "saveFromResponse: 这是cookieValue====="+cookie.value() );

                    if ("JSESSIONID".equals(cookie.name())) {
                        JSESSIONID = cookie.value();
                        Log.e(TAG, "---------------------------------------------");
                    }
                }

            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return cookies_c;
            }
        };

        OkHttpClient client= new  OkHttpClient.Builder().cookieJar(cookieJar).build();

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


        if (msg.endsWith("success")) {
            Toast.makeText(Myapp.activity, "发送成功", Toast.LENGTH_SHORT).show();
            ShowTimer();
        } else if (msg.endsWith("registered")) {
            Toast.makeText(Myapp.activity, "您的手机号已注册", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("sendfailure")) {
            Toast.makeText(Myapp.activity, "验证码发送失败", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("sendagain")) {
            Toast.makeText(Myapp.activity, "三分钟内只能获取一次", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("ipsendagain")) {
            Toast.makeText(Myapp.activity, "同一IP用户请求校验码超过5次", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("mobileoften")) {
            Toast.makeText(Myapp.activity, "同一手机号用户请求校验码超过3次", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("mobilecodeerror")) {
            Toast.makeText(Myapp.activity, "验证码不正确", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void RegisterSuccer(String msg) {

        if (msg.endsWith("success")) {
            Toast.makeText(Myapp.activity, "手机号注册成功", Toast.LENGTH_SHORT).show();
            Myapp.activity.finish();
        } else if (msg.endsWith("registered")) {
            Toast.makeText(Myapp.activity, "该手机号已注册", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("error")) {
            Toast.makeText(Myapp.activity, "验证码输入有误", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("mobilenull")) {
            Toast.makeText(Myapp.activity, "手机号为空", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("timeout")) {
            Toast.makeText(Myapp.activity, "校验码已超过有效时间", Toast.LENGTH_SHORT).show();
        } else if (msg.endsWith("passwordnull")) {
            Toast.makeText(Myapp.activity, "密码为空", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Myapp.activity, "请求错误", Toast.LENGTH_SHORT).show();
        }
    }

    private void ShowTimer() {

        or = true;
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Myapp.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tim--;
                        if (tim == 0) {
                            timer.cancel();
                            or = false;
                            getcode_bt.setText("获取验证码");
                        } else {
                            getcode_bt.setText("重新获取"+"("+tim+")");
                        }
                    }
                });
            }
        };
        timer.schedule(task,0,1000);
    }

    //判断网络状态
    private boolean getnetwoke() {

        Netwoke netwoke = new Netwoke();

        String getnetwoke = netwoke.getnetwoke(Myapp.activity);

        if (getnetwoke.equals("网络无连接")) {

            return true;
        }
        return false;
    }

    //检查手机号
    private boolean checkPhone() {
        String phoneString = username_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            hint_phone.setText("手机号码不能为空");
            return false;
        }
        Pattern pattern = Pattern.compile("^1[3578]\\d{9}$");
        Matcher matcher = pattern.matcher(phoneString);
        if (matcher.matches()) {
            hint_phone.setText("");
            return true;
        } else {
            hint_phone.setText("手机格式不正确");
            return false;
        }
    }

    /**
     * 检查验证码
     *
     * @return
     */
    private boolean checkCaptcha() {

        String mCaptchaEditTextString = code_image.getText().toString().trim();
        if(mCaptchaEditTextString.contains(" ")){
            hint_imagecheck.setText("验证码不正确");
            return false;
        }
        if (mCaptchaEditTextString == null || "".equals(mCaptchaEditTextString)) {
            hint_imagecheck.setText("验证码不能为空");
            return false;
        } else {
            hint_imagecheck.setText("");
            return true;
        }

    }

    /**
     * 检查手机验证码
     */

    private boolean checkPhoneCheck() {
        String phonecheck = code_phone.getText().toString().trim();

        if (TextUtils.isEmpty(phonecheck)) {
            hint_phonecheck.setText("验证码不能为空");
            return false;
        } else {
            hint_phonecheck.setText(" ");
            return true;
        }
    }

    /**
     * 检查密码
     *
     * @return
     */
    private boolean checkPasswork() {
        String editpasswordsString = password_phone.getText().toString();

        if (TextUtils.isEmpty(editpasswordsString)) {
            hint_surepawd.setText("密码不能为空");
            return false;
        } else if (editpasswordsString.length() < 6 || editpasswordsString.length() > 16) {
            hint_surepawd.setText("密码仅限6-16个字符");
            return false;
        } else {
            hint_surepawd.setText("");
            return true;
        }
    }

    /**
     * 检查协议
     *
     * @return
     */
    private boolean checkXieyi() {

        if (!protocol_check.isChecked()) {
            hint_xieyi.setText("未勾选《央视网网络服务使用协议》");
            return false;
        } else {
            hint_xieyi.setText("");
            return true;
        }

    }
}
