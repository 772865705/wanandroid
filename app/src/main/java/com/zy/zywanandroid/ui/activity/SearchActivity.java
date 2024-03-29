package com.zy.zywanandroid.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.zy.framework.base.BaseMvpActivity;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.db.bean.RecentlySearchBean;
import com.zy.zywanandroid.ui.contract.SearchContract;
import com.zy.zywanandroid.ui.model.SearchModel;
import com.zy.zywanandroid.ui.presenter.SearchPresenter;
import com.zy.zywanandroid.view.AutoWrapLayout;
import com.zy.zywanandroid.view.TagView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseMvpActivity<SearchPresenter> implements SearchContract.View {

    @BindView(R.id.toolbar_title)
    EditText toolbarTitle;
    @BindView(R.id.wrap_hot)
    AutoWrapLayout wrapHot;
    @BindView(R.id.wrap_history)
    AutoWrapLayout wrapHistory;
    @BindView(R.id.tv_delete_search_history)
    TextView tvDeleteSearchHistory;

    public static void start(Context context) {
        context.startActivity(new Intent(context, SearchActivity.class));
    }


    @Override
    public SearchPresenter setPresenter() {
        return new SearchPresenter(this, new SearchModel());
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    protected void initToolbar(Toolbar toolbar) {
        super.initToolbar(toolbar);
    }

    @Override
    protected void initView() {
    }

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (menu.findItem(R.id.action_setting) != null) {
            menu.removeItem(R.id.action_setting);
        }
        if (menu.findItem(R.id.action_login) != null) {
            menu.removeItem(R.id.action_login);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void showHots(List<String> hots) {
        for (String hot : hots) {
            TagView tagView = new TagView(this);
            tagView.setText(hot);
            wrapHot.addView(tagView);
            tagView.setOnClickListener(v -> {
                toolbarTitle.setText(hot);
            });
        }
        wrapHot.invalidate();
    }

    @Override
    public void showHistory(List<RecentlySearchBean> list) {
        wrapHistory.removeAllViews();
        for (RecentlySearchBean record : list) {
            TagView tagView = new TagView(this);
            tagView.setText(record.searchTxt);
            tagView.setBackgroundColor(Color.GRAY);
            wrapHistory.addView(tagView);
            tagView.setOnClickListener(v -> {
                toolbarTitle.setText(record.searchTxt);
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                getPresenter().onSearch(toolbarTitle.getText().toString());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.tv_delete_search_history)
    public void onViewClicked() {
        getPresenter().onDelete();
    }
}
