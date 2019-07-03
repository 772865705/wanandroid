package com.zy.framework.net;

import android.content.Context;

import com.zy.framework.util.LogUtil;
import com.zy.zywanandroid.net.NetApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetManager {

    private NetManager(){}
    private static NetManager manager;
    public static NetManager getInstance(){
        if (manager == null){
            synchronized (NetManager.class){
                if (manager == null){
                    manager = new NetManager();
                }
            }
        }
        return manager;
    }

    private NetApiService mNetService;

    public NetApiService getService(){
        return mNetService;
    }

    public void init(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        mNetService = retrofit.create(NetApiService.class);
    }
}
