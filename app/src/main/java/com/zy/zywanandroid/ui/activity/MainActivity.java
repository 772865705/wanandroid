package com.zy.zywanandroid.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zy.framework.base.BaseMvpActivity;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.ui.contract.MainContract;
import com.zy.zywanandroid.ui.model.MainModel;
import com.zy.zywanandroid.ui.presenter.MainPresenter;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @Override
    public MainPresenter setPresenter() {
        return new MainPresenter(this,new MainModel());
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }
}
