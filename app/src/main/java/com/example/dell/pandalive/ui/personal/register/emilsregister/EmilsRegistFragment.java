package com.example.dell.pandalive.ui.personal.register.emilsregister;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.example.dell.pandalive.ui.personal.register.emilsregister.presenter.EmilPresenter;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.Netwoke;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * Created by 贾成昆 on 2017/8/28.
 */

public class EmilsRegistFragment extends BaseFragment implements View.OnClickListener ,IEmilView{


    private View view;
    private EditText emils_username;
    private EditText emils_pwd;
    private EditText emils_comfirm_pwd;
    private EditText emils_image_code;
    private ImageView emils_image_custcode;
    private CheckBox emils_check;
    private Button emils_regist;
    private EmilPresenter emilPresenter;
    public String JSESSIONID;

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

        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_emilsregist, null);

        emilPresenter = new EmilPresenter(this);

        emils_username = (EditText) view.findViewById(R.id.emils_username);
        emils_pwd = (EditText) view.findViewById(R.id.emils_pwd);
        emils_comfirm_pwd = (EditText) view.findViewById(R.id.emils_comfirm_pwd);
        emils_image_code = (EditText) view.findViewById(R.id.emils_image_code);
        emils_image_custcode = (ImageView) view.findViewById(R.id.emils_image_custcode);
        emils_check = (CheckBox) view.findViewById(R.id.emils_check);
        emils_regist = (Button) view.findViewById(R.id.emils_regist);

        emils_regist.setOnClickListener(this);
        emils_image_custcode.setScaleType(ImageView.ScaleType.FIT_XY);
        emils_image_custcode.setOnClickListener(this);
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

                        emils_image_custcode.setImageBitmap(bitmap);
                        DialogUtil.instance().Hidedialog();
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.emils_regist:

                if (getnetwoke()) {
                    Toast.makeText(Myapp.activity, "网络无连接", Toast.LENGTH_SHORT).show();
                    return;
                }

                //点击注册
                if (!checkEmail()) {
                    return;
                }
                if (!checkPasswork()) {
                    return;
                }
                if (!checkAgainPasswork()) {
                    return;
                }

                if (!checkCaptcha()) {
                    return;
                }

                if (!checkXieyi()) {
                    return;
                }

                String emailString = emils_username.getText().toString().trim();
                String passwordString = emils_pwd.getText().toString();
                String mCaptchaEditTextString = emils_image_code.getText().toString().trim();
                emilPresenter.SendEmil(emailString,passwordString,mCaptchaEditTextString,JSESSIONID);

                break;

            case R.id.emils_image_custcode:

                getimacode();

                break;
        }
    }

    private boolean checkXieyi() {

        if (emils_check.isChecked()) {

            return true;
        }

        return false;
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

    //检查邮箱
    private boolean checkEmail() {
        String emailString = emils_username.getText().toString().trim();
        if (TextUtils.isEmpty(emailString)) {
            Toast.makeText(Myapp.activity, "\"邮箱不能为空\"", Toast.LENGTH_SHORT).show();
            // shakeViewToNotifyUser(edit_email);
            return false;
        }
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(emailString);
        if (matcher.matches()) {
//            hint_emamil.setText("");
            return true;
        } else {
            Toast.makeText(Myapp.activity, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean checkPasswork() {
        String editpasswordsString = emils_pwd.getText().toString();

        if (TextUtils.isEmpty(editpasswordsString)) {
            Toast.makeText(Myapp.activity, "\"密码不能为空\"", Toast.LENGTH_SHORT).show();
            // shakeViewToNotifyUser(edit_password);
            return false;
        } else if (editpasswordsString.length() < 6 || editpasswordsString.length() > 16) {
            Toast.makeText(Myapp.activity, "密码仅限6-16个字符", Toast.LENGTH_SHORT).show();
            return false;
        } else {
//            hint_passwork.setText("");
            return true;
        }
    }

    private boolean checkAgainPasswork() {

        String editagainpasswordsString = emils_comfirm_pwd.getText().toString();
        if (TextUtils.isEmpty(editagainpasswordsString)) {
            Toast.makeText(Myapp.activity, "确认密码不能为空", Toast.LENGTH_SHORT).show();
            // shakeViewToNotifyUser(edit_again_password);
            return false;
        } else {
//            hint_again_passord.setText("");
            String passwordsString = emils_pwd.getText().toString();
            if (!passwordsString.equals(editagainpasswordsString)) {
                Toast.makeText(Myapp.activity, "密码不一致", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * 检查验证码
     *
     * @return
     */
    private boolean checkCaptcha() {

        String mCaptchaEditTextString = emils_image_code.getText().toString().trim();
        if(mCaptchaEditTextString.contains(" ")){
            Toast.makeText(Myapp.activity, "验证码不正确", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mCaptchaEditTextString == null || "".equals(mCaptchaEditTextString)) {
            // shakeViewToNotifyUser(edit_yanzhengma);
            Toast.makeText(Myapp.activity, "验证码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else {
//            hint_yanzhengma.setText("");
            return true;
        }

    }

    @Override
    public void SendSuccess(String msg) {

        if (msg.equals("成功")) {

            Activation();
        } else {

            Toast.makeText(Myapp.activity, msg, Toast.LENGTH_SHORT).show();
            emils_image_code.setText("");
            getimacode();
        }
    }

    private void Activation() {

        final String key = emils_username.getText().toString().trim().split("@")[1].toLowerCase();
        if (mEmailAddress.getmEmailAddress().containsKey(key)) {
            View tview = View
                    .inflate(getActivity(), R.layout.dialog_internet_tishi, null);
            TextView tishiContent = (TextView) tview
                    .findViewById(R.id.play_continue_content);
            tishiContent.setText("请到您的邮箱激活账号后登录，是否现在去邮箱激活");
            TextView tishiCancel = (TextView) tview
                    .findViewById(R.id.play_continue_cancel);
            TextView tishiSure = (TextView) tview
                    .findViewById(R.id.play_continue_sure);
            final Dialog registerDialog = new Dialog(getActivity(), R.style.aadialog);
            tishiSure.setText("确定");
            tishiCancel.setText("取消");

            registerDialog.setContentView(tview);
            registerDialog.setCanceledOnTouchOutside(true);

            tishiCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registerDialog.dismiss();

                }
            });
            tishiSure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registerDialog.dismiss();
                    String mEmailAdd = mEmailAddress.getmEmailAddress().get(key);
                    Uri uri = Uri.parse(mEmailAdd);
                    Intent it = new Intent();
                    it.setAction("android.intent.action.VIEW");
                    it.setData(uri);
                    startActivity(it);
                    getActivity().finish();
                }
            });
            registerDialog.show();

        } else {
            Toast.makeText(Myapp.activity, "通行证需激活后才可登录", Toast.LENGTH_SHORT).show();
        }
    }

    private static mEmailAddressMap mEmailAddress;

    public static class mEmailAddressMap implements Serializable {
        private Map<String, String> mEmailAddress;

        public Map<String, String> getmEmailAddress() {
            return mEmailAddress;
        }

        public void setmEmailAddress(Map<String, String> mEmailAddress) {
            this.mEmailAddress = mEmailAddress;
        }

    }

    static {
        mEmailAddress = new mEmailAddressMap();
        mEmailAddress.setmEmailAddress(new HashMap<String, String>());
        mEmailAddress.getmEmailAddress().put("qq.com", "http://mail.qq.com");
        mEmailAddress.getmEmailAddress().put("gmail.com", "http://mail.google.com");
        mEmailAddress.getmEmailAddress().put("sina.com", "http://mail.sina.com.cn");
        mEmailAddress.getmEmailAddress().put("163.com", "http://mail.163.com");
        mEmailAddress.getmEmailAddress().put("126.com", "http://mail.126.com");
        mEmailAddress.getmEmailAddress().put("yeah.net", "http://www.yeah.net/");
        mEmailAddress.getmEmailAddress().put("sohu.com", "http://mail.sohu.com/");
        mEmailAddress.getmEmailAddress().put("tom.com", "http://mail.tom.com/");
        mEmailAddress.getmEmailAddress().put("sogou.com", "http://mail.sogou.com/");
        mEmailAddress.getmEmailAddress().put("139.com", "http://mail.10086.cn/");
        mEmailAddress.getmEmailAddress().put("hotmail.com", "http://www.hotmail.com");
        mEmailAddress.getmEmailAddress().put("live.com", "http://login.live.com/");
        mEmailAddress.getmEmailAddress().put("live.cn", "http://login.live.cn/");
        mEmailAddress.getmEmailAddress().put("live.com.cn", "http://login.live.com.cn");
        mEmailAddress.getmEmailAddress().put("189.com", "http://webmail16.189.cn/webmail/");
        mEmailAddress.getmEmailAddress().put("yahoo.com.cn", "http://mail.cn.yahoo.com/");
        mEmailAddress.getmEmailAddress().put("yahoo.cn", "http://mail.cn.yahoo.com/");
        mEmailAddress.getmEmailAddress().put("eyou.com", "http://www.eyou.com/");
        mEmailAddress.getmEmailAddress().put("21cn.com", "http://mail.21cn.com/");
        mEmailAddress.getmEmailAddress().put("188.com", "http://www.188.com/");
        mEmailAddress.getmEmailAddress().put("foxmail.coom", "http://www.foxmail.com");
    }
}
