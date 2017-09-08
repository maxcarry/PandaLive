package com.example.dell.pandalive.ui.personal.login;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.ui.personal.login.presenter.LoginPresenter;
import com.example.dell.pandalive.ui.personal.register.RegisterActivity;
import com.example.dell.pandalive.ui.videopanda.Constants;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.Netwoke;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.umeng.socialize.UMShareAPI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DebarkActivity extends BaseActivity implements View.OnClickListener ,ILoginView{

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
    private LoginPresenter loginPresenter;
    private SsoHandler mSsoHandler;
    private Oauth2AccessToken accesstokn;


    @Override
    protected void initdata() {

    }

    @Override
    protected void initview() {

        loginPresenter = new LoginPresenter(this);
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
        debark_enroll.setOnClickListener(this);
        debark_return_img.setOnClickListener(this);
        debark_thirdly_weibo.setOnClickListener(this);
    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.debark_landing:

                if (getnetwoke()) {

                    Toast.makeText(this, "网络无连接", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!checkEmailAndPhone()) {
                    return;
                }
                debark_ped_sky.setText("");

                if (checkEmpty(debark_input_pwd) == false) {

                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                DialogUtil.instance().Showdialog(Myapp.activity);
                debark_ped_sky.setText("");
                goLogin();

                break;

            case R.id.debark_enroll:

                startActivity(new Intent(Myapp.activity,RegisterActivity.class));
                break;

            case R.id.debark_return_img:

                finish();
                break;
            case R.id.debark_thirdly_weibo:
                //
                WbSdk.install(Myapp.activity,new AuthInfo(Myapp.activity, Constants.APP_KEY, Constants.REDIRECT_URL,
                        Constants.SCOPE));

                mSsoHandler = new SsoHandler(DebarkActivity.this);
                mSsoHandler.authorize(new SelfWbAuthListener());

                break;
        }
    }



    private class SelfWbAuthListener implements WbAuthListener {
        @Override
        public void onSuccess(final Oauth2AccessToken token) {
            DebarkActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    accesstokn = token;
                    String name = token.getPhoneNum();
                    String token1 = token.getToken();
                    Bundle bundle = token.getBundle();
                    String token2 = token.getRefreshToken();
                    long time = token.getExpiresTime();
                    String uid = token.getUid();
                    Log.e("login", "name==" + name + "----time==" + time + "----uid==" + uid);
                    Log.e("login", "name==" + token1 + "----time==" + bundle + "----uid==" + token2);
                    if(accesstokn.isSessionValid()) {
                        AccessTokenKeeper.writeAccessToken(DebarkActivity.this, accesstokn);
                        Toast.makeText(DebarkActivity.this,
                                "name==" + name + "----time==" + time + "----uid==" + uid, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        public void cancel() {
            Toast.makeText(DebarkActivity.this,
                    "取消了", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            Toast.makeText(DebarkActivity.this, wbConnectErrorMessage.getErrorMessage(), Toast.LENGTH_LONG).show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(mSsoHandler!=null) {
            mSsoHandler.authorizeCallBack(requestCode,resultCode,data);
        }
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
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

    // 检查邮箱、手机号
    private boolean checkEmailAndPhone() {
        String emailString = debark_input_name.getText().toString().trim();
        if (TextUtils.isEmpty(emailString)) {
            debark_ped_sky.setText("邮箱/手机号不能为空");
            return false;
        }
        String tEmail = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        if (emailString.indexOf("@") == -1) {
            tEmail = "^1[3578]\\d{9}$";
        }
        Pattern pattern = Pattern
                .compile(tEmail);
        Matcher matcher = pattern.matcher(emailString);
        if (matcher.matches()) {
            debark_ped_sky.setText("");
            return true;
        } else {
            debark_ped_sky.setText("邮箱/手机号格式不正确");
            return false;
        }
    }

    /**
     * 检查是否为空
     *
     * @param editText
     * @return
     */
    private boolean checkEmpty(EditText editText) {
        String testTxt = editText.getText().toString();
        if (testTxt == null || "".equals(testTxt)) {
            return false;
        }
        return true;
    }

    /**
     * 登录
     */
    private void goLogin() {

        String userName = debark_input_name.getText().toString()
                .trim();
        String password = debark_input_pwd.getText().toString();

        loginPresenter.GetUser(userName,password);

    }

    @Override
    public void LoginSuccess() {

        DialogUtil.instance().Hidedialog();
        finish();
    }

    @Override
    public void LoginError(String msg) {

        DialogUtil.instance().Hidedialog();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}