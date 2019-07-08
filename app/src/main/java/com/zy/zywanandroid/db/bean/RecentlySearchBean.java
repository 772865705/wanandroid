package com.zy.zywanandroid.db.bean;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.zy.framework.db.AppDatabase;

/**
 * Date: 2019/7/8 0008
 * Author: Zhaoyue
 * 搜索记录
 */
@Entity(tableName = "search")
public class RecentlySearchBean {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "searchtxt")
    public String searchTxt;

    @ColumnInfo
    public long time;

    public RecentlySearchBean(String searchTxt) {
        this.searchTxt = searchTxt;
        time = System.currentTimeMillis();
    }
}
