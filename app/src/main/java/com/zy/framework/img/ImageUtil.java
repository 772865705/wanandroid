package com.zy.framework.img;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zy.framework.app.MyApplication;
import com.zy.zywanandroid.R;

public class ImageUtil {
    private static boolean load = true;
    private static int defaultPlaceHolder = R.mipmap.ic_launcher;
    private static int defaultErrHolder = R.mipmap.ic_launcher;

    public static void loadByUrl(Context context, ImageView view,String url,
                                 @DrawableRes int placeHolder,@DrawableRes int errorHolder){
        if (load){
            Glide.with(context)
                    .load(url)
                    .placeholder(placeHolder)
                    .error(errorHolder)
                    .fitCenter()
                    .into(view);
        }
    };
    public static void loadByUrl(Context context, ImageView view,String url){
        loadByUrl(context, view, url,defaultPlaceHolder,defaultErrHolder);
    };
    public static void loadByUrl(ImageView view,String url){
        loadByUrl(MyApplication.getApp().getApplicationContext(),view,url);
    };

    public static void loadByRes(ImageView view,@DrawableRes int id){
        Glide.with(view)
                .load(id)
                .into(view);
    }

    public static boolean isLoad() {
        return load;
    }

    public static void setLoad(boolean load) {
        ImageUtil.load = load;
    }

    public static int getDefaultPlaceHolder() {
        return defaultPlaceHolder;
    }

    public static int getDefaultErrHolder() {
        return defaultErrHolder;
    }
}
