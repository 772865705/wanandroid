package com.zy.zywanandroid.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sdsmdg.tastytoast.TastyToast;
import com.yyydjk.library.BannerLayout;
import com.zy.framework.base.BaseFragment;
import com.zy.framework.base.BaseMvpFragment;
import com.zy.framework.img.ImageUtil;
import com.zy.framework.net.BeanChecker;
import com.zy.framework.net.NetExceptionCatcher;
import com.zy.framework.net.NetManager;
import com.zy.framework.util.ToastUtil;
import com.zy.zywanandroid.R;
import com.zy.zywanandroid.bean.BannerBean;
import com.zy.zywanandroid.ui.activity.WebActivity;
import com.zy.zywanandroid.ui.contract.HomeContract;
import com.zy.zywanandroid.ui.model.HomeModel;
import com.zy.zywanandroid.ui.presenter.HomePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZhaoYue on 2019/6/26.
 */
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.banner)
    BannerLayout banner;

    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initContentView() {
        //设置加载器
        banner.setImageLoader(new BannerLayout.ImageLoader() {
            @Override
            public void displayImage(Context context, String s, ImageView imageView) {
                ImageUtil.loadByUrl(context,imageView,s);
            }
        });
    }

    @Override
    protected void initData() {
        addDispose(NetManager.getInstance().getService().getBanner()
                .subscribeOn(Schedulers.io())
                .map(new BeanChecker<>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(beans -> {

                    ArrayList<String> urls = new ArrayList<>(beans.size());
                    for (BannerBean datum : beans) {
                        urls.add(datum.getImagePath());
                    }
                    //网络地址
                    banner.setViewUrls(urls);

                    //添加点击监听
                    banner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
//                            Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                            WebActivity.start(getActivity(),beans.get(position).getTitle(),beans.get(position).getUrl());
                        }
                    });
                },new NetExceptionCatcher<>()));
    }

    @Override
    public HomePresenter setPresenter() {
        return new HomePresenter(this,new HomeModel());
    }
}
