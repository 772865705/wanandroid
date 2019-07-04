package com.zy.framework.sp;

import android.content.Context;

import com.cocosw.favor.FavorAdapter;
import com.zy.zywanandroid.app.MyApplication;

public class SharePreferenceHelper {

    SPDefault spDefault;
    public SPDefault getDefault(){
        if (spDefault == null){
            spDefault = new FavorAdapter.Builder(MyApplication.getApp()).build().create(SPDefault.class);
        }
        return spDefault;
    }

    private SharePreferenceHelper(){}
    private static SharePreferenceHelper helper;
    public static SharePreferenceHelper get(){
        if (helper == null){
            synchronized (SharePreferenceHelper.class){
                if (helper == null){
                    helper = new SharePreferenceHelper();
                }
            }
        }
        return helper;
    }

}
