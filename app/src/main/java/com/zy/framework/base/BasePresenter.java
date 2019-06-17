package com.zy.framework.base;

import android.os.Bundle;

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

    private V mView;
    private M mModel;

    public BasePresenter(V view) {
        this.mView = view;
    }

    public BasePresenter(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    public M getModel() {
        return mModel;
    }

    public V getView() {
        return mView;
    }

    @Override
    public void onCreate(Bundle saveInstance) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
}