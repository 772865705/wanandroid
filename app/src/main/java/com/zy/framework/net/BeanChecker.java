package com.zy.framework.net;

import android.support.annotation.NonNull;

import com.zy.framework.base.BaseBean;

import io.reactivex.functions.Function;

public class BeanChecker<T> implements Function<BaseBean<T>,T> {

    @Override
    public @NonNull T apply(BaseBean<T> tBaseBean) throws Exception {
        if (!tBaseBean.isOK()){
            throw new NetException("server return error",tBaseBean.getErrorCode(),tBaseBean.getErrorMsg());
        }
        if (tBaseBean.getData() == null){
            throw new NetException("server return null data",tBaseBean.getErrorCode(),tBaseBean.getErrorMsg());
        }
        return tBaseBean.getData();
    }

    public static <DATA> BeanChecker<DATA> create(BaseBean<DATA> baseBean){
        return new BeanChecker<DATA>();
    }
}
