package com.zy.zywanandroid.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.zy.zywanandroid.db.bean.RecentlySearchBean;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

/**
 * Date: 2019/7/8 0008
 * Author: Zhaoyue
 */
@Dao
public interface SearchDao {

    /**
     * 使用Flowable 可以在每一次改变的时候 都会发射数据 所以可以在数据库修改的时候直接同步修改界面）
     * @param number 只显示最近数量
     */
    @Query("SELECT * FROM search order by time desc limit 0,:number")
    Flowable<List<RecentlySearchBean>> getBeans(int number);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RecentlySearchBean ... bean);

    @Query("DELETE FROM search")
    void deleteAll();

}
