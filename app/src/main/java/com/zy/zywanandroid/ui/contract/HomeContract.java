package com.zy.zywanandroid.ui.contract;

import com.zy.framework.base.BaseBean;
import com.zy.zywanandroid.bean.BannerBean;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by ZhaoYue on 2019/6/26.
 */
public interface HomeContract {
    interface Model {
        Observable<BaseBean<ArrayList<BannerBean>>> getBanners();
    }

    interface View {
        void onBannerBeans(ArrayList<BannerBean> beans);
    }
}
