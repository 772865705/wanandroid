package com.zy.zywanandroid.ui.model;

import com.zy.framework.base.BaseBean;
import com.zy.framework.net.NetManager;
import com.zy.zywanandroid.bean.BannerBean;
import com.zy.zywanandroid.ui.contract.HomeContract;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by ZhaoYue on 2019/6/26.
 */
public class HomeModel implements HomeContract.Model {

    public Observable<BaseBean<ArrayList<BannerBean>>> getBanners(){
        return NetManager.getInstance().getService().getBanner();
    }

}
