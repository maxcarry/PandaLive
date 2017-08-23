package com.example.dell.pandalive.loaderutils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by dell on 2017/8/23.
 */
public class BannerGlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        //Glide 加载图片简单用法
        Glide.with(context).load(path).into(imageView);

    }
}