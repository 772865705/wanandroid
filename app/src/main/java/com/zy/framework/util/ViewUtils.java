package com.zy.framework.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.View;

import com.zy.zywanandroid.R;

import java.util.Random;

/**
 * Created by ZhaoYue on 2019/6/25.
 */
public class ViewUtils {

    public static void setBgDrawable(View view,@DrawableRes int res){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setBackground(view.getContext().getDrawable(res));
        }else {
            view.setBackground(view.getContext().getResources().getDrawable(res));
        }
    }

    public static Drawable getDrawable(Context context,@DrawableRes int res){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getDrawable(res);
        }else {
            return context.getResources().getDrawable(res);
        }
    }

    /**
     * 获取随机rgb颜色值
     */
    public static @ColorInt int randomColor() {
        Random random = new Random();
        //0-190, 如果颜色值过大,就越接近白色,就看不清了,所以需要限定范围
        int red =random.nextInt(150);
        //0-190
        int green =random.nextInt(150);
        //0-190
        int blue =random.nextInt(150);
        //使用rgb混合生成一种新的颜色,Color.rgb生成的是一个int数
        return Color.rgb(red,green, blue);
    }

}
