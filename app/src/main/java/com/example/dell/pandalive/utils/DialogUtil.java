package com.example.dell.pandalive.utils;

import android.content.Context;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.custom_view.CustomDialog;

/**
 * Created by dell on 2017/8/24.
 */

public class DialogUtil {

    private static DialogUtil dialogUtil;
    public CustomDialog dialog;

    private DialogUtil() {

    }

    public static DialogUtil instance(){

        if (dialogUtil == null) {
            synchronized (DialogUtil.class) {
                if (dialogUtil == null) {
                    dialogUtil = new DialogUtil();
                }
            }
        }
        return dialogUtil;
    }

    //显示等待
    public void Showdialog(Context context) {

        dialog = new CustomDialog(context, R.style.CustomDialog);
        dialog.show();
    }

    //隐藏等待
    public void Hidedialog(){

        dialog.dismiss();
    }
}
