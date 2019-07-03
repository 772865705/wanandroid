package com.zy.zywanandroid.ui.activity;

import android.annotation.SuppressLint;

import com.zy.framework.base.BaseActivity;
import com.zy.framework.util.LogUtil;
import com.zy.zywanandroid.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
    }

    @SuppressLint("CheckResult")
    @Override
    protected void initData() {
        Observable.just(0)
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(i -> {
                    MainActivity.start(WelcomeActivity.this);
                    LogUtil.i("initData: startActivity on "+ Thread.currentThread().getName());
                    finish();
                });
    }

    @Override
    protected boolean showToolbar() {
        return false;
    }
}
