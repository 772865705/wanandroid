package com.zy.zywanandroid.ui.contract;

import com.zy.framework.base.BaseBean;
import com.zy.zywanandroid.bean.HotWordBean;
import com.zy.zywanandroid.db.bean.RecentlySearchBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

/**
 * Date: 2019/7/4 0004
 * Author: Zhaoyue
 */
public interface SearchContract {
    interface Model {
        Observable<BaseBean<ArrayList<HotWordBean>>> getHotWord();
        Flowable<List<RecentlySearchBean>> getRecord();
        void addRecord(String text);
    }

    interface View {
        void showHots(List<String> hots);
        void showHistory(List<RecentlySearchBean> list);
    }

}
