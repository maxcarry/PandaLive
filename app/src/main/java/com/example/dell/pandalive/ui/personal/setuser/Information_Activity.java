package com.example.dell.pandalive.ui.personal.setuser;

import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.dell.pandalive.R;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.entity.UplodBean;
import com.example.dell.pandalive.loaderutils.GlideImageLoader;
import com.example.dell.pandalive.utils.ChoosePictureDialog;
import com.example.dell.pandalive.utils.SharedUtil;
import com.google.gson.Gson;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 张凯雅 on 2017/9/4.
 */

public class Information_Activity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "Tag";
    private LinearLayout information_name_linearlayout;
    private ImageView information_back_imageview;
    private ImageView user_icon;
    private LinearLayout updata_icon;
    private TextView user_id;
    private Button logoff_bt;
    private TextView photo_album;
    private TextView photograph;
    private Button dismiss_bt;

    private GalleryConfig galleryConfig;
    public static final MediaType MEDIA_TYPE_MARKDOWN
            = MediaType.parse("multipart/form-data");
    private SharedUtil instance;


    @Override
    protected void initdata() {

        IHandlerCallBack iHandlerCallBack = new IHandlerCallBack() {
            @Override
            public void onStart() {
                Log.i(TAG, "onStart: 开启");
            }

            @Override
            public void onSuccess(List<String> photoList) {
                Log.i(TAG, "onSuccess: 返回数据");
                for (String s : photoList) {
                    Log.i(TAG, s);
                    File file = new File(s);
                    String url = "http://my.cntv.cn/intf/napi/api.php?client=ipanda_mobile&method=user.alterUserFace&userid=";
                    Log.e(TAG, "onSuccess: "+url+instance.getUserId() );
                    upload(url+instance.getUserId(),file);
                }
            }

            @Override
            public void onCancel() {
                Log.i(TAG, "onCancel: 取消");
            }

            @Override
            public void onFinish() {
                Log.i(TAG, "onFinish: 结束");
            }

            @Override
            public void onError() {
                Log.i(TAG, "onError: 出错");
            }
        };

        List<String> path = new ArrayList<>();

        galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider("com.yancy.gallerypickdemo.fileprovider")   // provider (必填)
                .pathList(path)                         // 记录已选的图片
                .crop(true)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .isShowCamera(true)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery/Pictures")          // 图片存放路径
                .build();
    }

    @Override
    protected void initview() {

        instance = SharedUtil.instance();
        information_back_imageview = (ImageView) findViewById(R.id.information_back_imageview);
        information_name_linearlayout = (LinearLayout) findViewById(R.id.information_name_linearlayout);
        user_icon = (ImageView) findViewById(R.id.user_icon);
        updata_icon = (LinearLayout) findViewById(R.id.updata_icon);
        user_id = (TextView) findViewById(R.id.user_id);
        logoff_bt = (Button) findViewById(R.id.logoff_bt);

        logoff_bt.setOnClickListener(this);

        updata_icon.setOnClickListener(this);
        information_back_imageview.setOnClickListener(this);
        information_name_linearlayout.setOnClickListener(this);

        Glide.with(Myapp.activity).load(instance.getUserFace()).diskCacheStrategy(DiskCacheStrategy.NONE).into(user_icon);
        user_id.setText(instance.getNickName());
    }

    @Override
    protected int initlayout() {
        return R.layout.information_activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.information_back_imageview:

                finish();

                break;

            case R.id.information_name_linearlayout:

                Intent intent = new Intent(Myapp.activity, Revise_Activity.class);
                intent.putExtra("username", user_id.getText().toString());
                startActivity(intent);

                break;
            case R.id.logoff_bt:

                instance.logoff();
                finish();
                break;

            case R.id.updata_icon:

                ChoosePictureDialog dialog = new ChoosePictureDialog(this, new ChoosePictureDialog.Listener() {
                    @Override
                    public void choosePic() {
                        Toast.makeText(Myapp.activity, "相册", Toast.LENGTH_SHORT).show();
                        GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(Myapp.activity);
                    }

                    @Override
                    public void chooseCamera() {

                        galleryConfig.getBuilder().isOpenCamera(true).build();
                        GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(Myapp.activity);
                    }
                });

                dialog.show();

                break;

        }
    }

    public void upload(String url, File file) {

        OkHttpClient client = new OkHttpClient();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        builder.addFormDataPart("","", RequestBody.create(MEDIA_TYPE_MARKDOWN,file));

        MultipartBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                Gson gson = new Gson();
                UplodBean bean = gson.fromJson(response.body().string(), UplodBean.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        View view = LayoutInflater.from(Myapp.activity).inflate(R.layout.updata_dialog, null);
                        final Dialog dialog = new Dialog(Myapp.activity);
                        dialog.setContentView(view);
                        TextView te = (TextView) view.findViewById(R.id.dialog_te);
                        te.setText("您的头像已提交审核\n\n请稍后回来确认吧");
                        TextView bt = (TextView) view.findViewById(R.id.sure_bt);
                        dialog.show();
                        bt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                });
                Log.e(TAG, "onResponse: "+bean.getCode()+bean.getError() );

            }
        });

    }
}
