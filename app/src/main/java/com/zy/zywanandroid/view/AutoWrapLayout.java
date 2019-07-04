package com.zy.zywanandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.zy.framework.util.LogUtil;

public class AutoWrapLayout extends ViewGroup {

    private int xmargin = 10;//水平方向padding
    private int ymaggin = 5;//垂直方向padding
    private int text_margin = 10;

    public AutoWrapLayout(Context context) {
        this(context, null);
    }

    public AutoWrapLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoWrapLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int layoutWidth = r - l - getPaddingRight();
        int x = getPaddingLeft();//横坐标开始
        int y = getPaddingTop();//纵坐标开始
        int rows = 1;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int width = view.getMeasuredWidth();
            int height = view.getMeasuredHeight();
            x += width+text_margin;
            if(x>layoutWidth){
                x = width+text_margin;
                rows++;
            }
            y = rows*(height+text_margin);
            if(i==0){
                view.layout(x-width-text_margin, y-height, x-text_margin, y);
            }else{
                view.layout(x-width, y-height, x, y);
            }
            LogUtil.d("child at " + i + " width: " + width + " layoutx : " + x);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int x = 0, y = 0;
        int rows = 1;

        int specWidth = MeasureSpec.getSize(widthMeasureSpec);
        int actualWidth = specWidth - getPaddingLeft() - getPaddingRight();//实际宽度
        for (int index = 0; index < getChildCount(); index++) {
            View child = getChildAt(index);
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            int width = child.getMeasuredWidth();
            LogUtil.d("child at " + index + " width: " + width);
            int height = child.getMeasuredHeight();
            x += width + text_margin;//
            if (x > actualWidth) {//换行
                x = width;
                rows++;
            }
            y = rows * (height + text_margin) + getPaddingTop();
        }
        setMeasuredDimension(actualWidth, y);

    }
}

