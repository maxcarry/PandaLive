package com.example.dell.pandalive.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.dell.pandalive.R;

/**
 * Created by yuerq on 2016/6/1.
 */
public class ChoosePictureDialog extends Dialog {


    private Button btnSelectPhoto;
    private Button btnCamera;
    private  Button btnCancel;

    private Listener mListener;

    public ChoosePictureDialog(Context context, Listener l) {
        super(context, R.style.style_dialog);
        setContentView(R.layout.personal_photo_tips);

        Window window = getWindow();
        window.setGravity(Gravity.BOTTOM);

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;

        mListener = l;

        btnCancel = (Button) findViewById(R.id.btn_photocancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              dismiss();
            }
        });
        btnSelectPhoto = (Button) findViewById(R.id.tv_selectphoto);
        btnSelectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dismiss();
                //从手机相册选择
                mListener.choosePic();
            }
        });
        btnCamera = (Button) findViewById(R.id.btn_makeaphoto);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               dismiss();
                //拍一张
                 mListener.chooseCamera();
            }
        });
    }


    public interface Listener {
        void choosePic();
        void chooseCamera();
    }

}
