package com.zy.zywanandroid.ui.activity;

import android.content.Context;
import android.widget.TextView;

import com.zy.framework.base.BaseMvpActivity;
import com.zy.framework.util.IntentUtils;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.ui.contract.MainContract;
import com.zy.zywanandroid.ui.model.MainModel;
import com.zy.zywanandroid.ui.presenter.MainPresenter;
import com.zy.zywanandroid.view.AutoWrapLayout;
import com.zy.zywanandroid.view.TagView;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IView {

    @BindView(R.id.autowrap)
    AutoWrapLayout mWrap;

    public static void start(Context context){
        IntentUtils.startActivity(context,MainActivity.class);
    }

    @Override
    public MainPresenter setPresenter() {
        return new MainPresenter(this,new MainModel());
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < 30; i++) {
            TagView tv = new TagView(this);
            tv.setText("我是"+i);
            mWrap.addView(tv);
        }
    }
}
