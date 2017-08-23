package com.example.dell.pandalive.loaderutils;

import android.app.Activity;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.example.dell.pandalive.R;
import com.yancy.gallerypick.inter.ImageLoader;
import com.yancy.gallerypick.widget.GalleryImageView;

/**
 * Created by dell on 2017/8/23.
 */
public class GlideImageLoader implements ImageLoader {



    private final static String TAG = "GlideImageLoader";



    @Override

    public void displayImage(Activity activity, Context context, String path, GalleryImageView galleryImageView, int width, int height) {

        Glide.with(context)

                .load(path)

                .placeholder(R.mipmap.gallery_pick_photo)

                .centerCrop()

                .into(galleryImageView);

    }



    @Override

    public void clearMemoryCache() {



    }

}
