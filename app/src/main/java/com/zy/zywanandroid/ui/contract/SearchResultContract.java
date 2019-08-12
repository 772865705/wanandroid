package com.zy.zywanandroid.ui.contract;

import android.app.Activity;

import com.zy.framework.base.BaseBean;
import com.zy.zywanandroid.bean.SearchResultBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.Path;

/**
 * Date: 2019/8/12 0012
 * Author: Zhaoyue
 */
public interface SearchResultContract {
    interface Model {
        Observable<BaseBean<SearchResultBean>> getSearchResult(int page, String k);
    }

    interface View {
        Activity getActivity();
        void setBarTitle(String title);
        void showResults(SearchResultBean data);
    }

    interface Presenter {
    }
}
