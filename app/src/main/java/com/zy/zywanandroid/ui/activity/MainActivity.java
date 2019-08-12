package com.zy.zywanandroid.ui.activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.zy.framework.base.BaseMvpActivity;
import com.zy.framework.util.IntentUtils;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.ui.contract.MainContract;
import com.zy.zywanandroid.ui.fragment.HomeFragment;
import com.zy.zywanandroid.ui.fragment.KnowledgeFragment;
import com.zy.zywanandroid.ui.fragment.NavigationFragment;
import com.zy.zywanandroid.ui.model.MainModel;
import com.zy.zywanandroid.ui.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.tool_common)
    Toolbar toolMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    Fragment[] fragments = new Fragment[]{new HomeFragment(),
            new KnowledgeFragment(),
            new NavigationFragment(),
            new KnowledgeFragment(),
            new NavigationFragment()
    };
    int[] tabid = new int[]{R.drawable.slt_ic_home,R.drawable.slt_ic_knowledge,
            R.drawable.slt_ic_navigation,R.drawable.slt_ic_project,R.drawable.slt_ic_me};
    int[] titleid = new int[]{R.string.homepage,R.string.knowledge,R.string.navigate,R.string.project,R.string.me};

    public static void start(Context context) {
        IntentUtils.startActivity(context, MainActivity.class);
    }

    @Override
    public MainPresenter setPresenter() {
        return new MainPresenter(this, new MainModel());
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragments[i];
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        tablayout.setupWithViewPager(vpMain);
        tablayout.removeAllTabs();
        for (int i = 0; i < fragments.length; i++) {
            tablayout.addTab(tablayout.newTab().setText(titleid[i]).setIcon(tabid[i]));
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                break;
            case R.id.action_search:
                SearchActivity.start(this);
                break;
            case R.id.action_login:
                WebActivity.start(this,"百度","https://www.baidu.com");
                break;
        }
        return true;
    }

    @Override
    protected boolean showToolbar() {
        return true;
    }
}
