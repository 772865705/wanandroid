package com.zy.framework.net;


import com.zy.framework.util.ToastUtil;

import io.reactivex.functions.Consumer;

public class NetExceptionCatcher<T> implements Consumer<T> {
    @Override
    public void accept(T t) throws Exception {
        if (t instanceof NetException){
            ToastUtil.showToast(((NetException) t).getMessage()+" code:"+((NetException) t).result + " msg:" +((NetException) t).msg);
        }else {

        }
    }
}
