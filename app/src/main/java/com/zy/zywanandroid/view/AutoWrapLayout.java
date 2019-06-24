package com.zy.zywanandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

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
        int rows = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int vw = view.getMeasuredWidth();
            int vh = view.getMeasuredHeight();
            if (i > 0)
                x += vw + text_margin;
            if (x +vw + text_margin > layoutWidth) {
                x = getPaddingLeft();
                rows++;
            }
            y = rows * (vh + text_margin) + getPaddingTop();
            view.layout(x, y, x + vw, y + vh);
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

