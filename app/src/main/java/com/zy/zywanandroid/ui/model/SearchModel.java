package com.zy.zywanandroid.ui.model;

import com.zy.framework.base.BaseBean;
import com.zy.framework.db.AppDatabase;
import com.zy.framework.net.NetManager;
import com.zy.zywanandroid.bean.HotWordBean;
import com.zy.zywanandroid.db.bean.RecentlySearchBean;
import com.zy.zywanandroid.ui.contract.SearchContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

/**
 * Date: 2019/7/4 0004
 * Author: Zhaoyue
 */
public class SearchModel implements SearchContract.Model {

    @Override
    public Observable<BaseBean<ArrayList<HotWordBean>>> getHotWord() {
        return NetManager.getInstance().getService().getHotWord();
    }

    public Flowable<List<RecentlySearchBean>> getRecord(){
        return AppDatabase.getInstance().getSearchDao().getBeans(5);
    }

    @Override
    public void addRecord(String text) {
        AppDatabase.getInstance().getSearchDao().insert(new RecentlySearchBean(text));
    }

    @Override
    public void deleteRecord() {
        AppDatabase.getInstance().getSearchDao().deleteAll();
    }
}
