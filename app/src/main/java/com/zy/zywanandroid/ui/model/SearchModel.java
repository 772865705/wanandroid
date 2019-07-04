package com.zy.zywanandroid.ui.model;

import com.zy.framework.base.BaseBean;
import com.zy.framework.net.NetManager;
import com.zy.zywanandroid.bean.HotWordBean;
import com.zy.zywanandroid.ui.contract.SearchContract;

import java.util.ArrayList;

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
}
