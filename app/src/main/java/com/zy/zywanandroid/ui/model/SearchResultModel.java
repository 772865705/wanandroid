package com.zy.zywanandroid.ui.model;

import com.zy.framework.base.BaseBean;
import com.zy.framework.net.NetManager;
import com.zy.zywanandroid.bean.SearchResultBean;
import com.zy.zywanandroid.ui.contract.SearchResultContract;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Date: 2019/8/12 0012
 * Author: Zhaoyue
 */
public class SearchResultModel implements SearchResultContract.Model {

    public Observable<BaseBean<SearchResultBean>> getSearchResult(int page, String k){
        return NetManager.getInstance().getService().getSearchResult(page, k);
    }

}
