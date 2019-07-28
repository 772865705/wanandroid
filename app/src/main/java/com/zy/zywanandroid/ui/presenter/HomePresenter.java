package com.zy.zywanandroid.ui.presenter;

import android.os.Bundle;

import com.zy.framework.base.BasePresenter;
import com.zy.framework.base.IPresenter;
import com.zy.framework.net.BeanChecker;
import com.zy.framework.net.NetExceptionCatcher;
import com.zy.framework.net.NetManager;
import com.zy.zywanandroid.ui.contract.HomeContract;
import com.zy.zywanandroid.ui.fragment.HomeFragment;
import com.zy.zywanandroid.ui.model.HomeModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZhaoYue on 2019/6/26.
 */
public class HomePresenter extends BasePresenter<HomeContract.View,HomeContract.Model> {
    public HomePresenter(HomeContract.View view, HomeContract.Model homeModel) {
        super(view,homeModel);
    }

    @Override
    public void onCreate(Bundle saveInstance) {
        addDispose(getModel()
                .getBanners()
                .subscribeOn(Schedulers.io())
                .map(new BeanChecker<>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beans -> {
                    getView().onBannerBeans(beans);
                },new NetExceptionCatcher<>()));
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
