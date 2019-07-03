package com.zy.zywanandroid.net;

import com.zy.framework.base.BaseBean;
import com.zy.zywanandroid.bean.BannerBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface NetApiService {

    String BASE_URL = "https://www.wanandroid.com";

    @GET("banner/json")
    Observable<BaseBean<ArrayList<BannerBean>>> getBanner();

}
