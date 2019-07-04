package com.zy.zywanandroid.ui.contract;

import com.zy.framework.base.BaseBean;
import com.zy.zywanandroid.bean.HotWordBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Date: 2019/7/4 0004
 * Author: Zhaoyue
 */
public interface SearchContract {
    interface Model {
        Observable<BaseBean<ArrayList<HotWordBean>>> getHotWord();
    }

    interface View {
        void showHots(List<String> hots);
    }

}
