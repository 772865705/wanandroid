package com.zy.zywanandroid.ui.presenter;

import android.os.Bundle;
import android.text.TextUtils;

import com.zy.framework.base.BasePresenter;
import com.zy.framework.net.NetExceptionCatcher;
import com.zy.framework.util.LogUtil;
import com.zy.framework.util.ToastUtil;
import com.zy.zywanandroid.ui.activity.SearchResultActivity;
import com.zy.zywanandroid.ui.contract.SearchResultContract;
import com.zy.zywanandroid.ui.model.SearchResultModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Date: 2019/8/12 0012
 * Author: Zhaoyue
 */
public class SearchResultPresenter extends BasePresenter<SearchResultContract.View, SearchResultModel> implements SearchResultContract.Presenter {
    public static final String EXTRA_SEARCH_KEY = "searchKey";

    private String key;

    public SearchResultPresenter(SearchResultContract.View view, SearchResultModel model) {
        super(view, model);
    }

    @Override
    public void onCreate(Bundle saveInstance) {
        key = getView().getActivity().getIntent().getStringExtra(EXTRA_SEARCH_KEY);
        if (getView().getActivity().getIntent() == null || TextUtils.isEmpty(key)){
            ToastUtil.showError("err:no intent");
            getView().getActivity().finish();
            return;
        }

        getView().setBarTitle(key);
        addDispose(
                getModel().getSearchResult(0,key)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(stringBaseBean -> {
                            LogUtil.i(stringBaseBean.getData().toString());
                            getView().showResults(stringBaseBean.getData());
                        },new NetExceptionCatcher<>())

        );



    }
}
