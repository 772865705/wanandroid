package com.zy.framework.db;

import android.arch.persistence.room.Room;

import com.zy.zywanandroid.app.MyApplication;

/**
 * Date: 2019/7/8 0008
 * Author: Zhaoyue
 */
public class DbManager {
    public static final String DB_NAME = "wananzhuo";

    private volatile static DbManager dbManager;
    public static DbManager getInstance(){
        if (dbManager == null){
            dbManager = new DbManager();
        }
        return dbManager;
    }
    private DbManager(){

    };

    AppDatabase db = Room.databaseBuilder(MyApplication.getApp(),AppDatabase.class,DB_NAME).build();


}
