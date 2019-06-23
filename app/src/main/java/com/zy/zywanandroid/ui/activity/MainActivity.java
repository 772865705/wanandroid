package com.zy.zywanandroid.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zy.framework.base.BaseMvpActivity;
import com.zy.framework.util.IntentUtils;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.ui.contract.MainContract;
import com.zy.zywanandroid.ui.model.MainModel;
import com.zy.zywanandroid.ui.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    public static void start(Context context){
        IntentUtils.startActivity(context,MainActivity.class);
    }

    @Override
    public MainPresenter setPresenter() {
        return new MainPresenter(this,new MainModel());
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
