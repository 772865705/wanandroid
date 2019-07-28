package com.zy.framework.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Date: 2019/7/8 0008
 * Author: Zhaoyue
 */
public abstract class BaseMvpFragment<T extends IPresenter> extends BaseFragment {

    private T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mPresenter=setPresenter();
        if (mPresenter!=null) {
            mPresenter.onCreate(savedInstanceState);
        }
        return view;
    }

    public T  getPresenter() {
        return mPresenter;
    }

    public abstract T setPresenter();

    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter!=null) {
            mPresenter.onStart();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter!=null) {
            mPresenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mPresenter!=null) {
            mPresenter.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter!=null) {
            mPresenter.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter!=null) {
            mPresenter.onDestroy();
        }
    }
}
