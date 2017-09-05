package com.example.dell.pandalive.ui.personal.register.emilsregister;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
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
import com.example.dell.pandalive.ui.personal.register.emilsregister.presenter.EmilPresenter;
import com.example.dell.pandalive.utils.DialogUtil;
import com.example.dell.pandalive.utils.Netwoke;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
        emils_image_custcode.setOnClickListener(this);
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
                emilPresenter.SendEmil(emailString,passwordString,mCaptchaEditTextString);

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
    public void SendSuccess() {

    }
}
