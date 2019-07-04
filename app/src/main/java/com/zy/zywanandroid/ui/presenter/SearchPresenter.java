package com.zy.zywanandroid.ui.presenter;

import android.os.Bundle;

import com.yyydjk.library.BannerLayout;
import com.zy.framework.base.BasePresenter;
import com.zy.framework.net.BeanChecker;
import com.zy.framework.net.NetExceptionCatcher;
import com.zy.framework.net.NetManager;
import com.zy.zywanandroid.bean.BannerBean;
import com.zy.zywanandroid.bean.HotWordBean;
import com.zy.zywanandroid.ui.activity.SearchActivity;
import com.zy.zywanandroid.ui.activity.WebActivity;
import com.zy.zywanandroid.ui.contract.SearchContract;
import com.zy.zywanandroid.ui.model.SearchModel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Date: 2019/7/4 0004
 * Author: Zhaoyue
 */
public class SearchPresenter extends BasePresenter<SearchContract.View, SearchContract.Model> {
    public SearchPresenter(SearchActivity view) {
        super(view);
    }

    public SearchPresenter(SearchActivity view, SearchModel model) {
        super(view, model);
    }

    @Override
    public void onCreate(Bundle saveInstance) {
        addDispose(getModel().getHotWord()
                .subscribeOn(Schedulers.io())
                .map(new BeanChecker<>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beans -> {
                    ArrayList<String> hots = new ArrayList<>(beans.size());
                    for (HotWordBean bean : beans) {
                        hots.add(bean.getName());
                    }
                    getView().showHots(hots);
                },new NetExceptionCatcher<>()));
    }
}
