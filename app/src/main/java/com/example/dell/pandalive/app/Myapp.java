package com.example.dell.pandalive.app;

import android.app.Activity;
import android.app.Application;

import io.vov.vitamio.Vitamio;

/**
 * Created by dell on 2017/8/23.
 */

public class Myapp extends Application {

    public static Activity activity;

    @Override
    public void onCreate() {
        super.onCreate();

        Vitamio.isInitialized(this);
    }
}
