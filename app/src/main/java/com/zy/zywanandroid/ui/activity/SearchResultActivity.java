package com.zy.zywanandroid.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.zy.framework.base.BaseMvpActivity;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.bean.SearchResultBean;
import com.zy.zywanandroid.ui.SearchResultAdapter;
import com.zy.zywanandroid.ui.contract.SearchResultContract;
import com.zy.zywanandroid.ui.model.SearchResultModel;
import com.zy.zywanandroid.ui.presenter.SearchResultPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultActivity extends BaseMvpActivity<SearchResultPresenter> implements SearchResultContract.View {
    public static final String EXTRA_SEARCH_KEY = "searchKey";
    @BindView(R.id.rv_search_result)
    RecyclerView rvSearchResult;

    public static void start(Context context, String key) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        intent.putExtra(EXTRA_SEARCH_KEY, key);
        context.startActivity(intent);
    }

    private SearchResultAdapter adapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_search_result;
    }

    @Override
    public SearchResultPresenter setPresenter() {
        return new SearchResultPresenter(this, new SearchResultModel());
    }

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    public void setBarTitle(String title) {
        ((TextView) findViewById(R.id.toolbar_title)).setText(title);
    }

    @Override
    public void showResults(SearchResultBean data) {
        adapter.addData(0,data.getDatas());
    }


    @Override
    protected void initView() {
        adapter = new SearchResultAdapter(null);
//        adapter.setCollectPage(true);
        adapter.setOnItemClickListener(((adapter1, view, position) -> {
            SearchResultBean.DatasBean datasBean = adapter.getData().get(position);
            WebActivity.start(this, datasBean.getTitle(),datasBean.getLink());
        }));

        rvSearchResult.setAdapter(adapter);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this));
        rvSearchResult.setHasFixedSize(true);
        rvSearchResult.setAdapter(adapter);
    }
}
