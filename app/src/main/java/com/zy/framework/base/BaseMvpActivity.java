package com.zy.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseMvpActivity<T extends IPresenter> extends BaseActivity {

    private Unbinder mUnbinder;
    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=setPresenter();
        beforeSetContentView();

        setContentView(getContentView());
        mUnbinder = ButterKnife.bind(this);
        initStatusBar();
        initView();
        initData();

        if (mPresenter!=null) {
            mPresenter.onCreate(savedInstanceState);
        }
    }

    public T  getPresenter() {
        return mPresenter;
    }

    public abstract T setPresenter();

    protected abstract void initView();

    protected void initData(){};

    protected void beforeSetContentView() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter!=null) {
            mPresenter.onStart();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter!=null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter!=null) {
            mPresenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter!=null) {
            mPresenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null) {
            mPresenter.onDestroy();
        }
    }
}
