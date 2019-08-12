package com.zy.framework.base;

import android.app.Activity;
import android.os.Bundle;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V, M> implements IPresenter {

    private V mView;
    private M mModel;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter(V view) {
        this.mView = view;
    }

    public BasePresenter(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    protected M getModel() {
        return mModel;
    }

    protected V getView() {
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
        unDispose();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    /**
     * 将 {@link Disposable} 添加到 {@link CompositeDisposable} 中统一管理
     * 可在 {@link Activity#onDestroy()} 中使用 {@link #unDispose()} 停止正在执行的 RxJava 任务,避免内存泄漏
     *
     * @param disposable
     */
    protected void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);//将所有 Disposable 放入集中处理
    }

    protected void addDispose(Disposable... disposables){
        for (Disposable d :
                disposables) {
            addDispose(d);
        }
    }

    /**
     * 停止集合中正在执行的 RxJava 任务
     */
    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();//保证 Activity 结束时取消所有正在执行的订阅
        }
    }
}