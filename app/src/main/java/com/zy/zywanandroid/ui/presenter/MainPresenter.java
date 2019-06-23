package com.zy.zywanandroid.ui.presenter;

import com.zy.framework.base.BasePresenter;
import com.zy.zywanandroid.ui.activity.MainActivity;
import com.zy.zywanandroid.ui.contract.MainContract;
import com.zy.zywanandroid.ui.model.MainModel;

/**
 * Created by ZhaoYue on 2019/6/20.
 */
public class MainPresenter extends BasePresenter<MainActivity,MainModel> {
    public MainPresenter(MainActivity view, MainModel model) {
        super(view, model);
    }
}
