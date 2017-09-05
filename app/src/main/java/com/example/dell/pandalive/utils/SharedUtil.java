package com.example.dell.pandalive.utils;

import android.content.SharedPreferences;

import com.example.dell.pandalive.app.Myapp;

/**
 * Created by dell on 2017/9/3.
 */

public class SharedUtil {

    private static SharedPreferences prefs;
    private static SharedUtil sharedUtil;

    private SharedUtil() {

        prefs = Myapp.activity.getSharedPreferences("user_info", 0);
    }

    public static SharedUtil instance(){

        if (sharedUtil == null) {

            synchronized (SharedUtil.class) {
                if (sharedUtil == null) {

                    sharedUtil = new SharedUtil();
                }
            }
        }

        return sharedUtil;
    }

    public void saveNickName(String nickName){

        prefs.edit().putString("nickName", nickName).commit();
    }

    public void saveUserFace(String userface){

        prefs.edit().putString("userface", userface).commit();
    }

    public String getNickName(){

        String nickName = prefs.getString("nickName", "");

        return nickName;
    }

    public String getUserFace(){

        String userface = prefs.getString("userface", "");

        return userface;
    }
}
