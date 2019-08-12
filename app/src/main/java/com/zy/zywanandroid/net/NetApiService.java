package com.zy.zywanandroid.net;

import com.zy.framework.base.BaseBean;
import com.zy.zywanandroid.bean.BannerBean;
import com.zy.zywanandroid.bean.HotWordBean;
import com.zy.zywanandroid.bean.SearchResultBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface NetApiService {

    String BASE_URL = "https://www.wanandroid.com";

    @GET("banner/json")
    Observable<BaseBean<ArrayList<BannerBean>>> getBanner();

    @GET("hotkey/json")
    Observable<BaseBean<ArrayList<HotWordBean>>> getHotWord();

    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<BaseBean<SearchResultBean>> getSearchResult(@Path("page") int page, @Field("k")String k);



}
