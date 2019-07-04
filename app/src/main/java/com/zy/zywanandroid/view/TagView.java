package com.zy.zywanandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.zy.framework.util.LogUtil;
import com.zy.framework.util.ViewUtils;
import com.zy.zywanandroid.R;

import java.util.Random;

/**
 * Created by ZhaoYue on 2019/6/25.
 */
public class TagView extends android.support.v7.widget.AppCompatTextView {

    private int mPadding = 10;

    public TagView(Context context) {
        this(context,null);
    }

    public TagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setTextColor(Color.WHITE);
        GradientDrawable background = (GradientDrawable) ViewUtils.getDrawable(getContext(),R.drawable.shape_bg_cornor);
        background.setColor(ViewUtils.randomColor());
        setBackground(background);
        setPadding(mPadding,mPadding,mPadding,mPadding);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int cornor = Math.min(w,h) / 2;
        ((GradientDrawable) getBackground()).setCornerRadius(cornor);
        LogUtil.d("onSizeChanged width:"+ w + " height:" + h);
    }

    private @ColorInt int getRandomColor(){
        return new Random().nextInt(0x1000000);
    }
}
