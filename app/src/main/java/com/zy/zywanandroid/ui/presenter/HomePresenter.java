package com.zy.zywanandroid.ui.presenter;

import android.os.Bundle;

import com.zy.framework.base.BasePresenter;
import com.zy.framework.base.IPresenter;
import com.zy.zywanandroid.ui.contract.HomeContract;
import com.zy.zywanandroid.ui.fragment.HomeFragment;
import com.zy.zywanandroid.ui.model.HomeModel;

/**
 * Created by ZhaoYue on 2019/6/26.
 */
public class HomePresenter extends BasePresenter<HomeContract.View,HomeContract.Model> {
    public HomePresenter(HomeContract.View view, HomeContract.Model homeModel) {
        super(view,homeModel);
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
