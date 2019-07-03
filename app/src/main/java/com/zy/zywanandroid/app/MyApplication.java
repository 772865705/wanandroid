package com.zy.zywanandroid.app;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.zy.framework.net.NetManager;
import com.zy.framework.util.LogUtil;

import me.jessyan.autosize.AutoSizeConfig;

public class MyApplication extends Application {

    private static MyApplication app;
    public static MyApplication getApp(){
        return app;
    }

    public static boolean isDebug() {
        try { ApplicationInfo info = app.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        initAutosize();
        initlog();
        initNet();
    }

    private void initNet() {
        NetManager.getInstance().init(this);
    }

    private void initlog() {
        LogUtil.defaultInit(this);
    }

    private void initAutosize(){
        AutoSizeConfig.getInstance().setCustomFragment(true);
    }
}
