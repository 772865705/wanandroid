package com.zy.zywanandroid.ui.activity;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.EditText;

import com.zy.framework.base.BaseActivity;
import com.zy.framework.util.LogUtil;
import com.zy.zywanandroid.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity";

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
                .delay(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(i -> {
                    MainActivity.start(WelcomeActivity.this);
                    Log.i(TAG, "initData: startActivity on "+ Thread.currentThread().getName());
                    finish();
                });
    }
}
