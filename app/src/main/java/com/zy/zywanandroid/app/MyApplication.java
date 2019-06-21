package com.zy.zywanandroid.app;

import android.app.Application;

import me.jessyan.autosize.AutoSizeConfig;

public class MyApplication extends Application {

    private static MyApplication app;
    public static MyApplication getApp(){
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        initAutosize();

    }

    private void initAutosize(){
        AutoSizeConfig.getInstance().setCustomFragment(true);
    }
}
