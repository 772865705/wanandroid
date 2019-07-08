package com.zy.framework.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.zy.zywanandroid.app.MyApplication;
import com.zy.zywanandroid.db.bean.RecentlySearchBean;
import com.zy.zywanandroid.db.dao.SearchDao;

/**
 * Date: 2019/7/8 0008
 * Author: Zhaoyue
 */
@Database(entities = {RecentlySearchBean.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "wananzhuo";

    private volatile static AppDatabase appDatabase;
    public static AppDatabase getInstance(){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(MyApplication.getApp(),AppDatabase.class,DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public abstract SearchDao getSearchDao();

}
