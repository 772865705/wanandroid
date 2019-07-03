package com.zy.framework.util;

import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;
import com.zy.zywanandroid.app.MyApplication;

public class ToastUtil {

    public static void showToast(String msg){
        Toast.makeText(MyApplication.getApp(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(int resid){
        Toast.makeText(MyApplication.getApp(), resid, Toast.LENGTH_SHORT).show();
    }

}
