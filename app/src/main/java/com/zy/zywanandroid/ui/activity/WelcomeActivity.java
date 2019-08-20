package com.zy.zywanandroid.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.support.design.widget.Snackbar;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zy.framework.base.BaseActivity;
import com.zy.framework.util.LogUtil;
import com.zy.framework.util.ToastUtil;
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

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if(!granted){
                        ToastUtil.showToast("没有文件权限");
                    }
                    jump2Main();
                });
    }

    private void jump2Main() {
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
    protected void onResume() {
        super.onResume();
        Snackbar.make(findViewById(R.id.img_welcome), "试试看", Snackbar.LENGTH_SHORT)
        .setAction("Action", v->{LogUtil.i("log");})
        .show();
        Snackbar.make(findViewById(R.id.img_welcome),"试试看",Snackbar.LENGTH_SHORT);
    }
}
